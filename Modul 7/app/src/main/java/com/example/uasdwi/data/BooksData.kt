package com.example.uasdwi.data

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BooksData(
    val booksImg: Int,
    val booksTitle: String,
    val booksDescription: String,
) : Parcelable