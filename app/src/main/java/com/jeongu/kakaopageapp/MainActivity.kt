package com.jeongu.kakaopageapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewTreeObserver
import android.widget.HorizontalScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.chip.Chip
import com.google.android.material.tabs.TabLayoutMediator
import com.jeongu.kakaopageapp.data.ContentManager
import com.jeongu.kakaopageapp.data.HotNowManager
import com.jeongu.kakaopageapp.data.TopContentManager
import com.jeongu.kakaopageapp.databinding.ActivityMainBinding
import com.jeongu.kakaopageapp.ui.contentdetail.ContentDetailActivity
import com.jeongu.kakaopageapp.ui.home.GridContentListAdapter
import com.jeongu.kakaopageapp.ui.home.HomeFragment
import com.jeongu.kakaopageapp.ui.home.HomePagerStateAdapter
import com.jeongu.kakaopageapp.ui.home.HotNowContentListAdapter
import com.jeongu.kakaopageapp.ui.home.ViewPagerAdapter
import com.jeongu.kakaopageapp.ui.shortcut.ShortcutActivity
import com.jeongu.kakaopageapp.ui.shortcut.ShortcutFragment

const val EXTRA_STRING_CHIP = "chip"
const val EXTRA_CONTENT_ID = "contentId"

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    //private val chipGroup by lazy { findViewById<ChipGroup>(R.id.chip_group) }
    private var previousChipId: Int = View.NO_ID

    private val hotNowContentListAdapter by lazy {
        HotNowContentListAdapter(HotNowManager.getList())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 50, systemBars.right, 0)
            insets
        }

        setLayout()
    }

    private fun setLayout() {
        //setViewPager2()
        //initRecyclerView()
        setToolbar()
        //setTopBanner()
        setBottomNavigation()
        //setChip()
    }


    private fun setViewPager2() {
        //binding.viewPager.adapter = ViewPagerAdapter(TopContentManager.getList())
//
//        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
//        val adapter = ViewPagerAdapter(TopContentManager.getList())
//        viewPager.adapter = adapter
        //viewPager.setCurrentItem(Int.MAX_VALUE / 2, false) // 중앙으로 설정
    }

//    private fun initRecyclerView() {
//        binding.rvHotNowContentList.apply {
//            adapter = hotNowContentListAdapter
//        }
//    }

    private fun setToolbar() {
        binding.layoutToolbarHome.ivToolbarCash.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/history/cash"))
            startActivity(intent)
        }


//        val toolbar = findViewById<View>(R.id.layout_toolbar)
//        toolbar.findViewById<View>(R.id.iv_toolbar_cash).setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/history/cash"))
//            startActivity(intent)
//        }
    }

//    private fun setTopBanner() {
//        binding.viewTopBanner.setOnClickListener {
//            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
//            startActivity(intent)
//        }
//
////        val topBanner = findViewById<View>(R.id.view_top_banner)
////        topBanner.setOnClickListener {
////            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://page.kakao.com/event/4ff6db86b64489c957dbd92b8d79d8ea"))
////            startActivity(intent)
////        }
//    }

    private fun setBottomNavigation() {
        binding.bottomNavigationMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    HomeFragment().loadFragment()
                    true
                }
                R.id.navigation_shortcut -> {
                    ShortcutFragment().loadFragment()
                    true
                }
                R.id.navigation_notification -> {
                    ShortcutFragment().loadFragment()
                    true
                }
                R.id.navigation_gift_box -> {
                    ShortcutFragment().loadFragment()
                    true
                }
                R.id.navigation_storage_box -> {
                    ShortcutFragment().loadFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun Fragment.loadFragment() {
        supportFragmentManager.commit {
            replace(R.id.container_home, this@loadFragment)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

//    private fun setChip() {
//        val chipData = intent.getStringExtra(EXTRA_STRING_CHIP) ?: ""
//        val chipGroup = binding.chipGroup
//        chipGroup.children.forEach {
//            val chip = it as Chip
//            if (chip.text == chipData) {
//                it.performClick() // 바로가기에서 넘어온 칩을 클릭한 상태로 설정
//                // 레이아웃이 다 그려지지 않아서 밑에 scrollToChip을 호출하면 chipStart, chipEnd, scrollViewWidth가 0으로 나옴
//                it.viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
//                    override fun onGlobalLayout() {
//                        // 메모리 누수를 방지하기 위해 (이거 없어도 작동되긴 하는데, 구글링 해보니 위치 정보가 0으로 나오는 경우가 있어서 추가함)
//                        it.viewTreeObserver.removeOnGlobalLayoutListener(this)
//                        scrollToChip(it)
//                    }
//                })
//            }
//        }
//
//        previousChipId = chipGroup.checkedChipId // 이전에 선택한 칩을 저장
//        var selectedChip = chipGroup.findViewById<Chip>(chipGroup.checkedChipId) // 현재 선택한 칩을 저장 (실행하고 미리 체크돼있는 칩을 저장하기 위해)
//        selectedChip.apply {
//            isChipIconVisible = true
//            setChipIconResource(setChipIcon(selectedChip.text.toString()))
//            textStartPadding = 0f
//            //scrollToChip(this) // 이거 하면 0으로 나옴
//        }
//        chipGroup.setOnCheckedStateChangeListener { group, checkedIds ->
//            if (checkedIds.isNotEmpty()) {
//                selectedChip = group.findViewById<Chip>(checkedIds[0])
//                if (previousChipId != View.NO_ID) {
//                    val previousChip = group.findViewById<Chip>(previousChipId)
//                    previousChip?.apply {
//                        isChipIconVisible = false
//                        textStartPadding = 22f // 이전에 선택한 칩의 padding을 원래대로 돌려놓음(사실 디폴트 padding 값을 못찾겠음. 야매임)
//                    }
//                }
//                selectedChip?.apply {
//                    isChipIconVisible = true
//                    setChipIconResource(setChipIcon(selectedChip.text.toString()))
//                    textStartPadding = 0f // 이걸 해야 아이콘과 텍스트가 붙어서 나옴
//                    scrollToChip(this)
//                }
//                previousChipId = selectedChip?.id ?: View.NO_ID // 이전에 선택한 칩에 현재 선택한 칩을 저장 -> 다른 칩을 계속해서 선택하기 때문에 이전에 선택한 칩을 저장해놔야 함
//            }
//        }
//    }
//
//    private fun setChipIcon(text: String): Int {
//        val icon = when (text) {
//            "지금핫한" -> R.drawable.ic_thunder
//            "실시간 랭킹" -> R.drawable.ic_crown
//            "오늘신작" -> R.drawable.ic_bell
//            "TV속 작품" -> R.drawable.ic_popcorn
//            "이벤트" -> R.drawable.ic_star
//            "남성인기" -> R.drawable.ic_men
//            "여성인기" -> R.drawable.ic_women
//            "완결추천" -> R.drawable.ic_ring
//            "브랜드" -> R.drawable.ic_c_coin
//            else -> R.drawable.ic_thunder
//        }
//        return icon
//    }
//
//    private fun scrollToChip(chip: Chip) {
//        val scrollView = chip.parent.parent as? HorizontalScrollView ?: return  // 칩의 부모의 부모가 스크롤뷰
//
//        // 칩의 위치 계산
//        val chipStart = chip.left
//        val chipEnd = chip.right
//        val scrollViewWidth = scrollView.width
//
//        Log.d("MainActivity", "chipStart: $chipStart, chipEnd: $chipEnd, scrollViewWidth: $scrollViewWidth")
//
//        val scrollX = (chipStart + chipEnd - scrollViewWidth) / 2 // 칩이 스크롤뷰의 가운데에 오도록 스크롤
//        scrollView.smoothScrollTo(scrollX, 0)
//    }
}