package com.junsu.movie.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int,
) : AppCompatActivity() {

    protected val binding: B by lazy {
        DataBindingUtil.setContentView(this, layoutRes)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.lifecycleOwner = this
        observeEvent()
    }

    abstract fun observeEvent()
}