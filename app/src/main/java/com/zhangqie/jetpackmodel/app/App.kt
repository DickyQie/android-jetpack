package com.zhangqie.jetpackmodel.app

import com.alibaba.android.arouter.launcher.ARouter
import com.zhangqie.base.BaseApplication

/**
 * Created by zhangqie on 2021/1/29
 * Describe:
 */
class App : BaseApplication() {

    companion object{
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

}