package com.lovoo.android.data.model.episode

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Image(
        val original: String? = null,
        val medium: String? = null
) : Parcelable