package com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.delegates.NewsItemDelegate
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.mvp.views.MainView
import com.padcmyanmar.padcx.padc_x_recyclerview_ypst.veiws.viewpods.EmptyViewPod

interface MainPresenter : NewsItemDelegate, EmptyViewPod.Delegate, BasePresenter<MainView> {
    fun onSwipeRefresh(lifecycleOwner: LifecycleOwner)
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}
