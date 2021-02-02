package com.zhangqie.mine

import com.alibaba.android.arouter.launcher.ARouter
import com.zhangqie.base.BaseApplication

/**
 * Created by zhangqie on 2021/2/2
 * Describe:
 */

class MineApp : BaseApplication(){

    companion object{
        lateinit var instance: MineApp
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

}