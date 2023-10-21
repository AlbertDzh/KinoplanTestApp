package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen

import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.ReleaseInfoCardItem
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.ReleaseRepertoryItem

interface LoadReleaseInfoCardView {

    fun loadView(releases: List<ReleaseInfoCardItem>)

}