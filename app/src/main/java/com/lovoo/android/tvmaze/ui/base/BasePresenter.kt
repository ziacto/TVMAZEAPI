package com.lovoo.android.ui.base

open class BasePresenter<V : MvpView>  : MvpPresenter<V> {

    private var mMvpView: V? = null

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


