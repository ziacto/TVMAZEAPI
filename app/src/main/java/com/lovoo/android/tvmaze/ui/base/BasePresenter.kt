package com.lovoo.android.ui.base

import com.lovoo.android.tvmaze.data.AppManager

open class BasePresenter<V : MvpView> constructor(private val dm: AppManager) : MvpPresenter<V> {

    private var mMvpView: V? = null
    fun getDataManager(): AppManager? = dm
    override fun onDetach() {
        mMvpView = null
    }

    override fun onAttach(mvpView: V) {
        mMvpView = mvpView
    }

    fun getMvpView(): V? = mMvpView

    override fun handleError(error: Any) {
        mMvpView?.onError(error as String)
    }

}


