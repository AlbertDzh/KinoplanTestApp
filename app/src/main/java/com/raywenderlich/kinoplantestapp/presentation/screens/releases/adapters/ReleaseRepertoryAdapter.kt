package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.loadImage
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.ReleaseInfoFragment
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.ReleaseRepertoryItem

class ReleaseRepertoryAdapter(
    private val releases: List<ReleaseRepertoryItem>,
):
    RecyclerView.Adapter<ReleaseRepertoryAdapter.ReleaseViewHolder>() {
    class ReleaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.releasePoster)
        val releaseType: TextView = itemView.findViewById(R.id.releaseType)
        val releaseTitle: TextView = itemView.findViewById(R.id.releaseTitle)
        fun bind(release: ReleaseRepertoryItem){
            imageView.loadImage(release.poster)
            releaseType.text = release.genre
            releaseTitle.text = release.title
            itemView.setOnClickListener {
                val releaseInfoFragment = ReleaseInfoFragment()
                releaseInfoFragment.arguments = Bundle().apply {
                    putParcelable("release", release.release)
                }
                val activityContext = it.context as AppCompatActivity
                activityContext.supportFragmentManager.beginTransaction()
                    .replace(R.id.repertoryMainFragment, releaseInfoFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReleaseViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_release, parent, false)
        return ReleaseViewHolder(view)
    }

    override fun getItemCount(): Int = releases.size

    override fun onBindViewHolder(holder: ReleaseViewHolder, position: Int) {
        holder.bind(releases[position])
    }

}
