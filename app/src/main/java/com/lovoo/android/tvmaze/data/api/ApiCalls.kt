package com.lovoo.android.tvmaze.data.api

import com.lovoo.android.data.model.show.ShowDetails
import com.lovoo.android.tvmaze.data.models.episode.Episode
import io.reactivex.Observable
import javax.inject.Inject

class ApiCalls @Inject constructor(private val restApi: RestApi) : ApiInterface {
    override fun getTvEpisodeList(id: Int): Observable<List<Episode>>? = restApi.getTvEpisodeList(id)
    override fun getTvShowDetail(id: Int): Observable<ShowDetails> = restApi.getTvShowDetail(id)
}