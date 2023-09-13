package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.model.Release

class ReleaseRepertoryAdapter(private val banners: List<Banner>, private val releases: List<Release>):
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val BANNER = 0
    val RELEASE = 1

    class BannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(banner: Banner){
            val imageView: ImageView = itemView.findViewById(R.id.bannerCarouselImageView)
        }
    }

    class ReleaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(release: Release){
            val imageView: ImageView = itemView.findViewById(R.id.releasePoster)
            val releaseType: TextView = itemView.findViewById(R.id.releaseType)
            val releaseTitle: TextView = itemView.findViewById(R.id.releaseTitle)
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            BANNER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_banner, parent)
                ReleaseViewHolder(view)
            }
            RELEASE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_repertory_parent, parent)
                BannerViewHolder(view)
            }

            else -> throw IllegalArgumentException(Resources.getSystem().getString(R.string.error))
        }
    }

    override fun getItemCount(): Int {
        return banners.size + releases.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

    override fun getItemViewType(position: Int): Int {
        return super.getItemViewType(position)
    }
}
