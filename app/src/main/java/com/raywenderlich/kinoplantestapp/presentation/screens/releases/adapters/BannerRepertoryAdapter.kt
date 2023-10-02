package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.media.audiofx.DynamicsProcessing.EqBand
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.model.RepertoryItem
import com.squareup.picasso.Picasso

class BannerRepertoryAdapter(private val items: List<Banner>): RecyclerView.Adapter<BannerRepertoryAdapter.BannerViewHolder>() {

    class BannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.bannerCarouselImageView)
        fun bind(banner: Banner){
            Picasso.get().load(banner.imageUrl).into(imageView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BannerRepertoryAdapter.BannerViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_banner, parent, false)
        return BannerRepertoryAdapter.BannerViewHolder(view)
    }

    override fun onBindViewHolder(holder: BannerRepertoryAdapter.BannerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}