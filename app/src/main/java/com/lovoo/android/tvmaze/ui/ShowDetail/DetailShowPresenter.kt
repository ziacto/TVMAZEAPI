package com.lovoo.android.tvmaze.ui.ShowDetail

import com.lovoo.android.data.model.show.ShowDetails
import com.lovoo.android.tvmaze.data.AppManager
import com.lovoo.android.tvmaze.data.api.ApiCallback
import com.lovoo.android.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailShowPresenter<V : DetailShowMvpView> @Inject constructor(private val am: AppManager) : BasePresenter<V>(am), DetailShowMvpPresenter<V> {
    override fun loadShowDetails(id: Int) {
        getMvpView()!!.showLoading()
        getDataManager()!!.getTvShowDetail(id)!!.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : ApiCallback<ShowDetails>() {
                    override fun onSuccess(showDetails: ShowDetails) {
                        getMvpView()!!.hideLoading()
                        getMvpView()!!.onShowData(showDetails)
                    }
                    override fun onError(error: Any) {
                        getMvpView()!!.hideLoading()
                        handleError(error)
                    }
                })
    }
}
