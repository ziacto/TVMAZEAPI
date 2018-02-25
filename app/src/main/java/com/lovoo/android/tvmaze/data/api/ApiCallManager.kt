package com.lovoo.android.tvmaze.data.api

import com.lovoo.android.tvmaze.data.AppManager
import com.lovoo.android.tvmaze.data.models.episode.Episode
import io.reactivex.Observable
import javax.inject.Inject

open class ApiCallManager @Inject constructor(private val apiHelper: ApiInterface): AppManager {
     override fun getTvEpisodeList(id: Int): Observable<List<Episode>>? = apiHelper.getTvEpisodeList(id)

}