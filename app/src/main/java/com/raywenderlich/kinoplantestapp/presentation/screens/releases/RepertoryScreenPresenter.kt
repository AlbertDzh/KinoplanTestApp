package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import androidx.fragment.app.Fragment
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.toReleaseRepertoryItem
import com.raywenderlich.kinoplantestapp.model.getMockRepertory

class RepertoryScreenPresenter(private val itemView: RepertoryView): RepertoryScreenLoader {

    override fun loadRepertory(): Unit {
        val repertory = getMockRepertory()
        itemView.showRepertoryData(repertory)
    }

}