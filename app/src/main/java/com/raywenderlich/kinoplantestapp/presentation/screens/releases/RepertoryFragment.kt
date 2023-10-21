package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.toReleaseRepertoryItem
import com.raywenderlich.kinoplantestapp.model.Release
import com.raywenderlich.kinoplantestapp.model.Repertory
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.ReleaseInfoFragment
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter

class RepertoryFragment : Fragment(), RepertoryView {

    private val presenter: RepertoryScreenPresenter = RepertoryScreenPresenter(this)
    lateinit var adapter: ParentRepertoryAdapter
    private  lateinit var releaseInfoFragment: ReleaseInfoFragment
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repertory, container, false)
        recyclerView = view.findViewById(R.id.repertoireParentView)
        presenter.loadRepertory()
        return view
    }

    override fun showRepertoryData(repertory: Repertory) {
        val repertoryData = ReleaseScreenItems(
            repertory.banners,
            RepertoryItem(getString(R.string.repertory_context_screen_now), repertory.now.map { it.toReleaseRepertoryItem() }),
            RepertoryItem(getString(R.string.repertory_context_screen_premier), repertory.premiere.map { it.toReleaseRepertoryItem() }),
            RepertoryItem(getString(R.string.repertory_context_screen_kids), repertory.kids.map { it.toReleaseRepertoryItem() }),
            RepertoryItem(getString(R.string.repertory_context_screen_soon), repertory.soon.map { it.toReleaseRepertoryItem() }),
        )
        adapter = ParentRepertoryAdapter(repertoryData)
        recyclerView.adapter = adapter
    }



}