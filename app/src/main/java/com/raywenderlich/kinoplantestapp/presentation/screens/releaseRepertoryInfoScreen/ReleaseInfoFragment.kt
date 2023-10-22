package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen

import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.loadImage
import com.raywenderlich.kinoplantestapp.model.Release
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.ReleaseInfoCardItem
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.ReleaseInfoCardParentAdapter


class ReleaseInfoFragment : Fragment(), LoadReleaseInfoCardView {

    private lateinit var release: Release
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ReleaseInfoCardParentAdapter

    private var presenter: ReleaseInfoCardPresenter = ReleaseInfoCardPresenter(this)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View {

        val view = inflater.inflate(R.layout.release_repertory_info_screen, container, false)
        release = arguments?.getParcelable<Release>("release")!!
        recyclerView = view?.findViewById(R.id.releaseInfoRecyclerView)!!
        recyclerView.addItemDecoration(DividerItemDecoration(view.context, LinearLayoutManager.VERTICAL).apply {
            setDrawable(ContextCompat.getDrawable(view.context, R.drawable.smaller_line_recycler_divider)!!)
        })
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val toolbarTitle: Toolbar = view.findViewById(R.id.releaseInfoScreenToolbar)!!
        val collapsingImage: ImageView = view.findViewById(R.id.collapsingToolbarImage)
        collapsingImage.loadImage(release.videoThumbnailUrl)
        toolbarTitle.title = release.title
        presenter.convertToValidType(release)
    }

    override fun loadView(releases: List<ReleaseInfoCardItem>) {
        adapter = ReleaseInfoCardParentAdapter(releases)
        recyclerView.adapter = adapter
    }
}