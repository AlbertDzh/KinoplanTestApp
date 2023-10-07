package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import androidx.fragment.app.Fragment
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.getMockRepertory

class RepertoryScreenPresenter(itemView: RepertoryFragment): RepertoryScreenLoader {

    override fun loadRepertory(itemView: RepertoryFragment): Unit {
        val repertory = getMockRepertory()
        val repertoryData = ReleaseScreenItems(
            repertory.banners,
            RepertoryItem(itemView.getString(R.string.repertory_context_screen_now), repertory.now),
            RepertoryItem(itemView.getString(R.string.repertory_context_screen_premier), repertory.premiere),
            RepertoryItem(itemView.getString(R.string.repertory_context_screen_kids), repertory.kids),
            RepertoryItem(itemView.getString(R.string.repertory_context_screen_soon), repertory.soon)
        )
        itemView.showRepertoryData(repertoryData)
    }

}