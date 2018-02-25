package com.lovoo.android.tvmaze.ui.main

import com.lovoo.android.tvmaze.data.AppManager
import com.lovoo.android.tvmaze.data.api.ApiCallback
import com.lovoo.android.tvmaze.data.models.episode.Episode
import com.lovoo.android.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter<V : MainMvpView> @Inject constructor(private val dm: AppManager) : BasePresenter<V>(dm), MainMvpPresenter<V> {

    override fun loadTvEpisodeList(id: Int) {
        getMvpView()!!.showLoading()
        getDataManager()!!.getTvEpisodeList(id)!!.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiCallback<List<Episode>>() {

                    override fun onSuccess(episodeListResponse: List<Episode>) {
                        getMvpView()!!.hideLoading()
                        getMvpView()!!.onTvEpisodeResult(episodeListResponse)
                    }
                    override fun onError(error: Any) {
                        getMvpView()!!.hideLoading()
                        handleError(error)
                    }
                })
    }

}