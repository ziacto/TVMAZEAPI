package com.lovoo.android.data.model.episode

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@SuppressLint("ParcelCreator")
@Parcelize
data class Self(
        val href: String? = null
) : Parcelable