package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.loadImage
import com.raywenderlich.kinoplantestapp.model.Release

class ReleaseRepertoryAdapter(private val releases: List<Release>):
    RecyclerView.Adapter<ReleaseRepertoryAdapter.ReleaseViewHolder>() {

    class ReleaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.releasePoster)
        val releaseType: TextView = itemView.findViewById(R.id.releaseType)
        val releaseTitle: TextView = itemView.findViewById(R.id.releaseTitle)
        fun bind(release: Release){
            imageView.loadImage(release.posterUrl)
            releaseType.text = release.genres.first()
            releaseTitle.text = release.title
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
