package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.model.Release

data class ReleaseScreenItems (
    val banners: List<Banner>,
    val now: RepertoryItem,
    val premiere: RepertoryItem,
    val kids: RepertoryItem,
    val soon: RepertoryItem
) {
    val size: Int = 5
}

data class RepertoryItem(
    val title: String,
    val releases: List<Release>
)

