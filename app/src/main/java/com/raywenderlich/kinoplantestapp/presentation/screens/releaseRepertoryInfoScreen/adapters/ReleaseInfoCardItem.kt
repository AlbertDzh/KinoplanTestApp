package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters

sealed class ReleaseInfoCardItem

    class ReleasePrimaryInformationSectionItem(
        val ageRating: String,
        val genre: String,
        val premiere: Long?,
        val country: String,
        val posterUrl: String?
    ): ReleaseInfoCardItem()

    class ReleaseTrailerSectionItem(
        val trailerUrl: String
    ): ReleaseInfoCardItem()

    class ReleaseMainInformationSectionItem(
        val duration: Long?,
        val direrectors: String,
        val cast: String,
        val story: String?,
    ): ReleaseInfoCardItem()