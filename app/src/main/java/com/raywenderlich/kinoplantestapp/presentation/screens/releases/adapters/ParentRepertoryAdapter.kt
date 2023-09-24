package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.model.RepertoryItem
import com.squareup.picasso.Picasso

class ParentRepertoryAdapter(private val items: List<RepertoryItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private val VIEW_TYPE_ITEM = 0
        private val VIEW_TYPE_BANNER = 1
    }

    class BannerViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        val rcRepertoryMain: RecyclerView = itemView.findViewById(R.id.rcBannerCarousel)
        fun bind(repertoryItem: RepertoryItem){
            rcRepertoryMain.apply {
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = BannerRepertoryAdapter(repertoryItem.banners)
            }
        }
    }
    class RepertoryViewholder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val releaseListType: TextView = itemView.findViewById(R.id.releaseListType)
        val rvRepertoryReleases: RecyclerView = itemView.findViewById(R.id.releaseListItem)
        fun bind(repertoryItem: RepertoryItem){
            releaseListType.text = repertoryItem.title
            rvRepertoryReleases.apply {
                layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
                adapter = ReleaseRepertoryAdapter(repertoryItem.releases)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_ITEM -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_release_parent, parent, false)
                RepertoryViewholder(view)
            }
            VIEW_TYPE_BANNER -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_banner_parent, parent, false)
                BannerViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid viewType")
        }
    }
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RepertoryViewholder -> {
                holder.bind(items[position])
            }
            is BannerViewHolder -> {
                holder.bind(items[position])
            }
            else -> throw IllegalArgumentException("Invalid ViewHolder type")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            VIEW_TYPE_BANNER
        } else {
            VIEW_TYPE_ITEM
        }
    }
}