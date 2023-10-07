package com.raywenderlich.kinoplantestapp.presentation.screens.releases

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter

class RepertoryFragment : Fragment(), RepertoryView {

    lateinit var presenter: RepertoryScreenPresenter
    lateinit var adapter: ParentRepertoryAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_repertory, container, false)
        presenter = RepertoryScreenPresenter(this)
        recyclerView = view.findViewById(R.id.repertoireParentView)
        presenter.loadRepertory(this)
        return view
    }

    override fun showRepertoryData(repertoryData: ReleaseScreenItems) {
        adapter = ParentRepertoryAdapter(repertoryData)
        recyclerView.adapter = adapter
    }

}