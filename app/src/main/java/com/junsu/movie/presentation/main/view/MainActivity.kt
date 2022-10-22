package com.junsu.movie.presentation.main.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.junsu.movie.presentation.base.BaseActivity
import com.junsu.movie.presentation.main.fragment.movie.view.MovieFragment
import com.junsu.movie.presentation.main.fragment.mypage.view.MyPageFragment
import com.junsu.movieapplication.R
import com.junsu.movieapplication.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>(
    R.layout.activity_main
) {

    private val movieFragment by lazy {
        MovieFragment(this)
    }

    private val myPageFragment by lazy {
        MyPageFragment(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        with(binding.bnMain) {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_bn_main_movie -> {
                        changeFragment(movieFragment)
                    }
                    R.id.menu_bn_main_myPage -> {
                        changeFragment(myPageFragment)
                    }
                    else -> {
                        false
                    }
                }
            }
            selectedItemId = R.id.menu_bn_main_movie
        }
    }

    private fun changeFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction().replace(R.id.frame_main, fragment)
            .commitAllowingStateLoss()
        return true
    }

    override fun observeEvent() {
    }
}