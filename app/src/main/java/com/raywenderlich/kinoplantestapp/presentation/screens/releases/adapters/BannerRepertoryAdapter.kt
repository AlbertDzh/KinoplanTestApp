package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.media.audiofx.DynamicsProcessing.EqBand
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.loadImage
import com.raywenderlich.kinoplantestapp.model.Banner

class BannerRepertoryAdapter(private val items: List<Banner>): RecyclerView.Adapter<BannerRepertoryAdapter.BannerViewHolder>() {

    class BannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.bannerCarouselImageView)
        fun bind(banner: Banner){
            imageView.loadImage(banner.imageUrl)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_banner, parent, false)
        return BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}