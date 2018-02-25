package com.lovoo.android.tvmaze.data.api

import com.lovoo.android.tvmaze.data.models.episode.Episode
import io.reactivex.Observable

interface ApiInterface {
    fun getTvEpisodeList(id: Int): Observable<List<Episode>>?
}