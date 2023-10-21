package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import android.app.Service
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.model.Release
import kotlinx.parcelize.Parcelize

data class ReleaseScreenItems (
    val banners: List<Banner>,
    val now: RepertoryItem,
    val premiere: RepertoryItem,
    val kids: RepertoryItem,
    val soon: RepertoryItem,
) {
    val size: Int = 5
}

data class RepertoryItem(
    val title: String,
    val releases: List<ReleaseRepertoryItem>
    )


@Parcelize
data class ReleaseRepertoryItem(
    val poster: String?,
    val genre: String,
    val title: String,
    val release: Release
): Parcelable