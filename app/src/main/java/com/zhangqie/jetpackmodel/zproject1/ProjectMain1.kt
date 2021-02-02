package com.zhangqie.jetpackmodel.zproject1

import androidx.fragment.app.Fragment
import com.zhangqie.base.base.BaseActivity
import com.zhangqie.base.ext.init
import com.zhangqie.jetpackmodel.R

import kotlinx.android.synthetic.main.project1_main.*


import com.zhangqie.home.fragment.HomeFragment

import com.zhangqie.mine.fragment.MineFragment
import com.zhangqie.mpublic.fragment.PublicmFragment
import com.zhangqie.project.fragment.ProjectFragment

/**
 * Created by zhangqie on 2021/2/2
 * Describe:
 *
 * 集成模式1 集成的方式可以直接使用
 *
 * 组件开发： 集成的方式就不可以了
 *
 *
 * 为了方便组件开发，这里我把代码注释了，需要自己打开
 *
 */
 class ProjectMain1 : BaseActivity(){


    var fragments = arrayListOf<Fragment>()
    private val homeFragment: HomeFragment by lazy { HomeFragment() }
    private val projectFragment: ProjectFragment by lazy { ProjectFragment() }
    private val publicNumberFragment: PublicmFragment by lazy { PublicmFragment() }
    private val mineFragment: MineFragment by lazy { MineFragment() }

    /*private val treeArrFragment: Test1Fragment by lazy {
      ARouter.getInstance().build("/mine/Test1").navigation() as Test1Fragment
  }*/


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