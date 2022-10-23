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
        MovieFragment()
    }

    private val myPageFragment by lazy {
        MyPageFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        changeFragment(movieFragment)
        initBottomNavigationView()
    }

    private fun initBottomNavigationView() {
        binding.bnMain.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_bn_main_movie -> {
                        changeFragment(movieFragment)
                        return@setOnItemSelectedListener true
                    }
                    R.id.menu_bn_main_myPage -> {
                        changeFragment(myPageFragment)
                        return@setOnItemSelectedListener true
                    }
                }
                false
            }
            selectedItemId = R.id.menu_bn_main_movie
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_main, fragment)
            .commitAllowingStateLoss()
    }

    override fun observeEvent() {
    }
}