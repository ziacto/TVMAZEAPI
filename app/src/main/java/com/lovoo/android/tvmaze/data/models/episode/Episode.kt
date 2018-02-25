package com.lovoo.android.tvmaze.data.models.episode

import android.annotation.SuppressLint
import android.os.Parcelable
import com.lovoo.android.data.model.episode.Image
import com.lovoo.android.data.model.episode.Links
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
 class Episode(
        val summary: String? = null,
        val number: Int? = null,
        val airtime: String? = null,
        val image: Image? = null,
        val links: Links? = null,
        val airdate: String? = null,
        val name: String? = null,
        val season: Int? = null,
        val runtime: Int? = null,
        val airstamp: String? = null,
        val id: Int? = null,
        val url: String? = null
) : Parcelable