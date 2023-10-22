package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.loadImage
import com.raywenderlich.kinoplantestapp.model.Release
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.ReleaseInfoCardItem
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.ReleaseInfoCardParentAdapter
import kotlinx.coroutines.NonDisposableHandle.parent


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
        setHasOptionsMenu(true)
        val toolbarTitle: Toolbar = view.findViewById(R.id.releaseInfoScreenToolbar)!!
        val collapsingImage: ImageView = view.findViewById(R.id.collapsingToolbarImage)

        (activity as? AppCompatActivity)?.let {
            it.setSupportActionBar(toolbarTitle)
            it.supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        collapsingImage.loadImage(release.videoThumbnailUrl)
        toolbarTitle.title = release.title
        presenter.convertToValidType(release)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            R.id.shareBtn -> {
                Toast.makeText(context, "Clicked on banner", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun loadView(releases: List<ReleaseInfoCardItem>) {
        adapter = ReleaseInfoCardParentAdapter(releases)
        recyclerView.adapter = adapter
    }


}