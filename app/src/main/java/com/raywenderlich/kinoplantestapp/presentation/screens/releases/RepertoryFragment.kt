package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.ReleaseScreenItems
import com.raywenderlich.kinoplantestapp.model.RepertoryItem
import com.raywenderlich.kinoplantestapp.model.getMockRepertory
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter

class RepertoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repertory, container, false)

        val repertory = getMockRepertory()
        val repertoryItems = ReleaseScreenItems(
            repertory.banners,
            RepertoryItem(getString(R.string.repertory_context_screen_now), repertory.now),
            RepertoryItem(getString(R.string.repertory_context_screen_premier), repertory.premiere),
            RepertoryItem(getString(R.string.repertory_context_screen_kids), repertory.kids),
            RepertoryItem(getString(R.string.repertory_context_screen_soon), repertory.soon)
        )

        val recyclerView: RecyclerView = view.findViewById(R.id.repertoireParentView)
        val adapter: ParentRepertoryAdapter = ParentRepertoryAdapter(repertoryItems)
        recyclerView.adapter = adapter

        return view
    }

}