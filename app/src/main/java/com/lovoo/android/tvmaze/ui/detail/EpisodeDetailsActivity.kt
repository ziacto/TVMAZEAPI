package com.lovoo.android.tvmaze.ui.detail

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.lovoo.android.tvmaze.R
import com.lovoo.android.tvmaze.data.models.episode.Episode
import com.lovoo.android.tvmaze.ui.ShowDetail.DetailShowActivity
import com.lovoo.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_episode_details.*

class EpisodeDetailsActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_episode_details)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        try {
            val episode = intent.getBundleExtra("myBundleKey").getParcelable<Episode>("episodeDetails") as Episode
            toolbar.title = episode.name
            Glide.with(this).load(episode.image?.medium).apply(RequestOptions().error(R.drawable.noimage)).into(episode_image1)
            Glide.with(this).load(episode.image?.original).apply(RequestOptions().error(R.drawable.noimage)).into(episode_image2)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                summary_text.text = "Summary : \n"+Html.fromHtml(episode.summary, Html.FROM_HTML_MODE_LEGACY)
            } else {
                @Suppress("DEPRECATION")
                summary_text.text = "Summary : \n"+Html.fromHtml(episode.summary)
            }

            airtime_text.text =  "Air Time :"+episode.airtime
            airdate_text.text =  "Air Date :"+episode.airdate
            number_text.text =   "Number :"+" Season "+episode.season+" Episode "+episode.number.toString()

            link_text.text = episode.url
            link_text.setOnClickListener {
                if(isNetworkConnected){
                    val uris = Uri.parse(episode.url)
                    val urlIntent = Intent(Intent.ACTION_VIEW, uris)
                    startActivity(urlIntent)
                }
            }

        }catch (e:Exception){
            Log.d("EpisodeDetailsActivity", e.message)
        }

        show_detail_button.setOnClickListener {
            val intent = Intent(this@EpisodeDetailsActivity, DetailShowActivity::class.java)
            startActivity(intent)
        }

    }
}
