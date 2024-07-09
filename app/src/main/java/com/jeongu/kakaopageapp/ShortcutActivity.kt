package com.jeongu.kakaopageapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class ShortcutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shortcut)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, 50, systemBars.right, 0)
            insets
        }

        setLayout()
    }

    private fun setLayout() {
        setToolbar()
        setBottomNavigation()
    }

    private fun setToolbar() {
        val toolbar = findViewById<View>(R.id.layout_toolbar_shortcut)
        toolbar.apply {
            findViewById<TextView>(R.id.tv_toolbar_title_recommend).text = "바로가기"
            findViewById<TextView>(R.id.tv_toolbar_title_webtoon).visibility = View.GONE
            findViewById<TextView>(R.id.tv_toolbar_title_web_novel).visibility = View.GONE
            findViewById<TextView>(R.id.tv_toolbar_title_book).visibility = View.GONE
        }
    }

    private fun setBottomNavigation() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation_main)
        bottomNavigationView.selectedItemId = R.id.navigation_shortcut
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
}