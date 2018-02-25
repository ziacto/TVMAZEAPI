package com.lovoo.android.tvmaze.data.api

import com.lovoo.android.data.model.show.ShowDetails
import com.lovoo.android.tvmaze.data.models.episode.Episode
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RestApi {

    @GET("/shows/{id}/episodes")
    fun getTvEpisodeList(@Path("id") id: Int?): Observable<List<Episode>>

    @GET("/shows/{id}")
    fun getTvShowDetail(@Path("id") id: Int?): Observable<ShowDetails>
}