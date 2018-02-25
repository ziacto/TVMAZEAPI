package com.lovoo.android.tvmaze.ui.main

import com.lovoo.android.tvmaze.data.models.episode.Episode
import com.lovoo.android.ui.base.MvpView

interface MainMvpView : MvpView {
    fun onTvEpisodeResult(episodes: List<Episode>)
}