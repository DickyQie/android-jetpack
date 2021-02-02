package com.zhangqie.jetpackmodel.zproject1

import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.zhangqie.base.api.AppARouterUrl
import com.zhangqie.base.base.BaseActivity
import com.zhangqie.base.ext.init
import com.zhangqie.jetpackmodel.R

import kotlinx.android.synthetic.main.project1_main.*


/**
 * Created by zhangqie on 2021/2/2
 * Describe:
 *
 * 为了方便组件开发： 这里就可以用ARouter了
 *
 * 这样是为了 isRunModule    =  true 切换
 *
 * 这里的代码不报错
 *
 * 组件项目时（isRunModule    =  true）  每个模块都是一个apk
 *
 * 运行的主apk是没用的
 *
 */
 class ProjectMain2 : BaseActivity(){


    var fragments = arrayListOf<Fragment>()
    private val homeFragment: Fragment by lazy {
        ARouter.getInstance().build(AppARouterUrl.PAGER_HOME).navigation() as Fragment
    }
    private val projectFragment: Fragment by lazy {
        ARouter.getInstance().build(AppARouterUrl.PAGER_PROJECT).navigation() as Fragment
    }
    private val publicNumberFragment: Fragment by lazy {
        ARouter.getInstance().build(AppARouterUrl.PAGER_PUBLIC).navigation() as Fragment
    }
    private val mineFragment: Fragment by lazy {
        ARouter.getInstance().build(AppARouterUrl.PAGER_MINE).navigation() as Fragment
    }

    init {
        fragments.apply {
            add(homeFragment)
            add(projectFragment)
            add(publicNumberFragment)
            add(mineFragment)
        }
    }



    override fun layoutId(): Int {
        return R.layout.project1_main
    }

    override fun initView() {


        //初始化viewpager2
        main_viewpager.init(this,fragments,false).run {
            offscreenPageLimit = fragments.size
        }
        main_viewpager.isSaveEnabled = false

        //初始化 bottombar
        main_bottom.run {
            enableAnimation(true)
            setTextSize(12F)
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main -> main_viewpager.setCurrentItem(0, false)
                    R.id.menu_project -> main_viewpager.setCurrentItem(1, false)
                    R.id.menu_public -> main_viewpager.setCurrentItem(2, false)
                    R.id.menu_me -> main_viewpager.setCurrentItem(3, false)
                }
                true
            }
        }
    }

    override fun initData() {

    }
}