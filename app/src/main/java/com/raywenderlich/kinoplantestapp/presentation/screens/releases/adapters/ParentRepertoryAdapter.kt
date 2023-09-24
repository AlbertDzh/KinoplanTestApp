package com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.RepertoryItem

class ParentRepertoryAdapter(private val items: List<RepertoryItem>): RecyclerView.Adapter<ParentRepertoryAdapter.RepertoryViewholder>() {


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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepertoryViewholder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_repertory_parent, parent, false)
        return RepertoryViewholder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RepertoryViewholder, position: Int) {
        holder.bind(items[position])
    }
}