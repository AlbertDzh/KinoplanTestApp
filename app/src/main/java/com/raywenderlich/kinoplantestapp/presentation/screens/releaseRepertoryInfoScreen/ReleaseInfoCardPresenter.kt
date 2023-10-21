package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen

import com.raywenderlich.kinoplantestapp.app.extensions.toReleaseInfoCardItemList
import com.raywenderlich.kinoplantestapp.app.extensions.toReleaseRepertoryItem
import com.raywenderlich.kinoplantestapp.model.Release

class ReleaseInfoCardPresenter(private val itemView: LoadReleaseInfoCardView): FormatReleaseInfo {
    override fun convertToValidType(release: Release) {
        var formatedRelease = release.toReleaseInfoCardItemList()
        itemView.loadView(formatedRelease)
    }
}