package com.example.uasdwi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieTVData(
    val movietvImg: Int,
    val movietvTitle: String,
    val movietvDescription: String,
) : Parcelable