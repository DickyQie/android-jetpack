package com.zhangqie.mpublic

import com.alibaba.android.arouter.launcher.ARouter
import com.zhangqie.base.BaseApplication

/**
 * Created by zhangqie on 2021/2/2
 * Describe:
 */

class PublicmApp : BaseApplication(){

    companion object{
        lateinit var instance: PublicmApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

}