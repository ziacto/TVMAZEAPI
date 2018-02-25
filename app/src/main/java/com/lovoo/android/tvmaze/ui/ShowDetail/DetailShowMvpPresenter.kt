package com.lovoo.android.tvmaze.ui.ShowDetail

import com.lovoo.android.ui.base.MvpPresenter

interface DetailShowMvpPresenter<V : DetailShowMvpView> : MvpPresenter<V> {
    fun loadShowDetails(id: Int)
}
