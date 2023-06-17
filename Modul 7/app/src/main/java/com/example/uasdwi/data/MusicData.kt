package com.example.uasdwi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MusicData(
    val musicImg: Int,
    val musicTitle: String,
    val musicDescription: String,
) : Parcelable