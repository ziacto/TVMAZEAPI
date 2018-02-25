package com.lovoo.android.tvmaze.ui.ShowDetail

import com.lovoo.android.data.model.show.ShowDetails
import com.lovoo.android.ui.base.MvpView

interface DetailShowMvpView : MvpView {
    fun onShowData(showDetails: ShowDetails)
}