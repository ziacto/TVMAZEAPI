package com.lovoo.android.tvmaze.ui.ShowDetail

import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lovoo.android.data.model.show.ShowDetails
import com.lovoo.android.tvmaze.R
import com.lovoo.android.tvmaze.constants.Configs
import com.lovoo.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail_show.*
import javax.inject.Inject

class DetailShowActivity : BaseActivity(), DetailShowMvpView {

    @Inject
    lateinit var mDetailShowMvpPresenter: DetailShowMvpPresenter<DetailShowMvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_show)
        mDetailShowMvpPresenter.onAttach(this)
        mDetailShowMvpPresenter.loadShowDetails(Configs.starTrekId)
    }

    override fun onShowData(showDetails: ShowDetails) {
        toolbar.title = showDetails.name
        Glide.with(this).load(showDetails.image?.medium).apply(RequestOptions().error(R.drawable.noimage)).into(episode_image1)
        Glide.with(this).load(showDetails.image?.original).apply(RequestOptions().error(R.drawable.noimage)).into(episode_image2)
        streame_text.text = "Channel : " + showDetails.webChannel?.name
        runtime_text.text = "Runtime : " + showDetails.runtime.toString()
        status_text.text = "Status : " + showDetails.status
        type_text.text = "Type : " + showDetails.type
        genres_text.text = "General : " + showDetails.genres.toString()
        site_text.text = "Link : " + showDetails.officialSite
    }
}
