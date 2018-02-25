package com.lovoo.android.tvmaze.ui.main

import com.lovoo.android.ui.base.MvpPresenter

interface MainMvpPresenter<V : MainMvpView> : MvpPresenter<V> {
    fun loadTvEpisodeList(id: Int)
}