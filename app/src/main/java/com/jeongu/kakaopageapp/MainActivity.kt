package com.jeongu.kakaopageapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

const val EXTRA_STRING_CHIP = "chip"

class MainActivity : AppCompatActivity() {

    private val chipGroup by lazy { findViewById<ChipGroup>(R.id.chip_group) }
    private var previousChipId: Int = View.NO_ID

    private val thumbnailImageList = listOf(
        R.drawable.img_content_01,
        R.drawable.img_content_16,
        R.drawable.img_content_17,
        R.drawable.img_content_18,
        R.drawable.img_content_19
    )

    private val TitleList = listOf(
        R.drawable.img_content_01_title,
        R.drawable.img_content_16_title,
        R.drawable.img_content_17_title,
        R.drawable.img_content_18_title,
        R.drawable.img_content_19_title
    )

    private val descriptionList = listOf(
        "레전드의 귀환을 경배하라!",
        "천재적 작품 감상하면 캐시!",
        "이세계에 떨어진 무림고수?",
        "지금 바로 캐시 선물 받아가세요!",
        "왕년에 주먹 쓴 놈이 돌아왔다"
    )

    private val freeTypeList = listOf(
        R.drawable.ic_free_3_days_waiting,
        null,
        null,
        null,
        R.drawable.ic_free_serial
    )

    private val upList = listOf(
        R.drawable.ic_up,
        null,
        null,
        null,
        null
    )

    private val genreList = listOf(
        "웹소설·판타지",
        null,
        null,
        null,
        "웹툰·액션·349.8만"
    )

    private val pageList = listOf(
        "1/5",
        "2/5",
        "3/5",
        "4/5",
        "5/5"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 50, systemBars.right, 0)
            insets
        }

        setLayout()
    }

    private fun setLayout() {
        setViewPager2()
        setToolbar()
        setTopBanner()
        setBottomNavigation()
        setChip()
    }

    private fun setViewPager2() {
        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
        val adapter = ViewPagerAdapter(thumbnailImageList, TitleList, descriptionList, freeTypeList, upList, genreList, pageList)
        viewPager.adapter = adapter
        //viewPager.setCurrentItem(Int.MAX_VALUE / 2, false) // 중앙으로 설정
    }

    private fun setToolbar() {
        val toolbar = findViewById<View>(R.id.layout_toolbar)
        toolbar.findViewById<View>(R.id.iv_toolbar_cash).setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/history/cash"))
            startActivity(intent)
        }
    }

    private fun setTopBanner() {
        val topBanner = findViewById<View>(R.id.view_top_banner)
        topBanner.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
            startActivity(intent)
        }
    }

    private fun setBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    if (bottomNavigationView.selectedItemId == R.id.navigation_home) return@setOnItemSelectedListener true
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
                R.id.navigation_shortcut -> {
                    if (bottomNavigationView.selectedItemId == R.id.navigation_shortcut) return@setOnItemSelectedListener true
                    val intent = Intent(this, ShortcutActivity::class.java)
                    startActivity(intent)
                }
            }
            true
        }
    }

    private fun setChip() {
        val chipData = intent.getStringExtra(EXTRA_STRING_CHIP) ?: ""
        chipGroup.children.forEach {
            if ((it as Chip).text == chipData) {
                it.performClick() // 바로가기에서 넘어온 칩을 클릭한 상태로 설정
                // 레이아웃이 다 그려지지 않아서 밑에 scrollToChip을 호출하면 chipStart, chipEnd, scrollViewWidth가 0으로 나옴
                it.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
                    override fun onGlobalLayout() {
                        it.viewTreeObserver.removeOnGlobalLayoutListener(this) // 메모리 누수를 방지하기 위해 (이거 없어도 작동되긴 하는데, 구글링 해보니 width가 0으로 나오는 경우가 있어서 추가함)
                        scrollToChip(it)
                    }
                })
            }
        }

        previousChipId = chipGroup.checkedChipId // 이전에 선택한 칩을 저장
        var selectedChip = chipGroup.findViewById<Chip>(chipGroup.checkedChipId) // 현재 선택한 칩을 저장 (실행하고 미리 체크돼있는 칩을 저장하기 위해)
        selectedChip.apply {
            isChipIconVisible = true
            setChipIconResource(setChipIcon(selectedChip.text.toString()))
            textStartPadding = 0f
            //scrollToChip(this) // 이거 하면 0으로 나옴
        }
        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
            if (checkedIds.isNotEmpty()) {
                selectedChip = group.findViewById<Chip>(checkedIds[0])
                if (previousChipId != View.NO_ID) {
                    val previousChip = group.findViewById<Chip>(previousChipId)
                    previousChip?.apply {
                        isChipIconVisible = false
                        textStartPadding = 22f // 이전에 선택한 칩의 padding을 원래대로 돌려놓음(사실 디폴트 padding 값을 못찾겠음. 야매임)
                    }
                }
                selectedChip?.apply {
                    isChipIconVisible = true
                    setChipIconResource(setChipIcon(selectedChip.text.toString()))
                    textStartPadding = 0f // 이걸 해야 아이콘과 텍스트가 붙어서 나옴
                    scrollToChip(this)
                }
                previousChipId = selectedChip?.id ?: View.NO_ID // 이전에 선택한 칩에 현재 선택한 칩을 저장 -> 다른 칩을 계속해서 선택하기 때문에 이전에 선택한 칩을 저장해놔야 함
            }
        }
    }

    private fun setChipIcon(text: String): Int {
        val icon = when (text) {
            "지금핫한" -> R.drawable.ic_thunder
            "실시간 랭킹" -> R.drawable.ic_crown
            "오늘신작" -> R.drawable.ic_bell
            "TV속 작품" -> R.drawable.ic_popcorn
            "이벤트" -> R.drawable.ic_star
            "남성인기" -> R.drawable.ic_men
            "여성인기" -> R.drawable.ic_women
            "완결추천" -> R.drawable.ic_ring
            "브랜드" -> R.drawable.ic_c_coin
            else -> R.drawable.ic_thunder
        }
        return icon
    }

    private fun scrollToChip(chip: Chip) {
        val scrollView = chip.parent.parent as? HorizontalScrollView ?: return  // 칩의 부모의 부모가 스크롤뷰

        // 칩의 위치 계산
        val chipStart = chip.left
        val chipEnd = chip.right
        val scrollViewWidth = scrollView.width

        Log.d("MainActivity", "chipStart: $chipStart, chipEnd: $chipEnd, scrollViewWidth: $scrollViewWidth")

        val scrollX = (chipStart + chipEnd - scrollViewWidth) / 2 // 칩이 스크롤뷰의 가운데에 오도록 스크롤
        scrollView.smoothScrollTo(scrollX, 0)
    }
}