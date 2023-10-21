package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen

import com.raywenderlich.kinoplantestapp.model.Release

interface FormatReleaseInfo {

    fun convertToValidType(release: Release)

}