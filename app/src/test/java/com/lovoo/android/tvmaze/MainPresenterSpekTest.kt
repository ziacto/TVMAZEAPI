package com.lovoo.android.tvmaze

import com.lovoo.android.tvmaze.constants.Configs
import com.lovoo.android.tvmaze.data.AppManager
import com.lovoo.android.tvmaze.data.models.episode.Episode
import com.lovoo.android.tvmaze.ui.main.MainMvpView
import com.lovoo.android.tvmaze.ui.main.MainPresenter
import io.reactivex.Observable
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import org.mockito.Mockito.*
import java.util.*


class MainPresenterSpekTest : Spek( {

    given("a MainPresenter") {

         var activity: MainMvpView = mock(MainMvpView::class.java)
         var appManager: AppManager = mock(AppManager::class.java)
         lateinit var mEpisodePresenter: MainPresenter<MainMvpView>


        on("on MainPresenter Attach") {

            mEpisodePresenter = MainPresenter(appManager)
            mEpisodePresenter.onAttach(activity)

            val mockedResponse: Episode? = mock(Episode::class.java)

            doReturn(Observable.just(Arrays.asList(mockedResponse)))
                    .`when`(appManager)
                    .getTvEpisodeList(Configs.starTrekId)

            mEpisodePresenter.loadTvEpisodeList(Configs.starTrekId)

            it("on Api Response") {
                verify(activity).showLoading()
                verify(activity).onTvEpisodeResult(Arrays.asList(mockedResponse) as List<Episode>)
            }
        }

        on("onDetach") {
            mEpisodePresenter.onDetach()
        }
    }

})