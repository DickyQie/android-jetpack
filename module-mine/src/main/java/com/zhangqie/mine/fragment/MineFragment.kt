package com.zhangqie.mine.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.zhangqie.base.api.AppARouterUrl
import com.zhangqie.base.base.BaseFragment
import com.zhangqie.mine.R

/**
 * Created by zhangqie on 2021/2/2
 * Describe: 集成时直接使用
 */
@Route(path = AppARouterUrl.PAGER_MINE)
class MineFragment : BaseFragment() {

    override fun layoutId(): Int {
        return R.layout.fg_mine
    }

    override fun initView() {

    }

    override fun initData() {

    }
}