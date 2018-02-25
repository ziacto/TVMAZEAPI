package com.lovoo.android.tvmaze

import android.content.Intent
import android.os.Bundle
import com.lovoo.android.tvmaze.constants.Configs
import com.lovoo.android.tvmaze.data.models.episode.Episode
import com.lovoo.android.tvmaze.ui.detail.EpisodeDetailsActivity
import com.lovoo.android.tvmaze.ui.main.MainAdapter
import com.lovoo.android.tvmaze.ui.main.MainMvpPresenter
import com.lovoo.android.tvmaze.ui.main.MainMvpView
import com.lovoo.android.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity(), MainMvpView  {
    @Inject
    lateinit var mainMvpPresenter: MainMvpPresenter<MainMvpView>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainMvpPresenter.onAttach(this)
        mainMvpPresenter.loadTvEpisodeList(Configs.starTrekId)
    }

    override fun onTvEpisodeResult(episodes: List<Episode>) {
        recycler_view.adapter = MainAdapter(episodes, object : MainAdapter.OnItemClickListener {
            override fun onClick(episode: Episode) {
                val intent = Intent(this@MainActivity, EpisodeDetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable("episodeDetails", episode)
                intent.putExtra("myBundleKey", bundle)
                startActivity(intent)

            }
        })
    }
}
