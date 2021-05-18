package com.jramirez.pruebanapoleon.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String,
    var isFavorite: Boolean? = false
) : Parcelable
