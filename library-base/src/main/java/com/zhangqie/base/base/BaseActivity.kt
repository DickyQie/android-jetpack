package com.zhangqie.base.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by zhangqie on 2021/2/2
 * Describe:BaseActivity
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())
        initView()
        initData()
    }

    abstract fun layoutId(): Int

    abstract fun initView()

    abstract fun initData()

}