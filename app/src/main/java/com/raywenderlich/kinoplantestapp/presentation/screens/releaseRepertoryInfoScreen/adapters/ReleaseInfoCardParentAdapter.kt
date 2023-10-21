package com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.app.extensions.loadImage
import com.raywenderlich.kinoplantestapp.model.Banner
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.BannerRepertoryAdapter
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.adapters.ParentRepertoryAdapter
import org.w3c.dom.Text

class ReleaseInfoCardParentAdapter(private val releaseInfoItems: List<ReleaseInfoCardItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    class primaryInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var ageRating: TextView = itemView.findViewById(R.id.ageRating)
        var genre: TextView = itemView.findViewById(R.id.filmGenre)
        var countryInfo: TextView = itemView.findViewById(R.id.countryCardInfo)
        var releaseImage: ImageView = itemView.findViewById(R.id.releaseInfoScreenPosterId)
        val releaseDuration: TextView = itemView.findViewById(R.id.premiereStartDate)

        fun bind(cardItem: ReleasePrimaryInformationSectionItem){
            ageRating.text = cardItem.ageRating
            genre.text = cardItem.genre
            releaseDuration.text = cardItem.premiere.toString()
            countryInfo.text = cardItem.country
            releaseImage.loadImage(cardItem.posterUrl)
        }
    }

    class releaseTrailerInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val releaseImageView: ImageView = itemView.findViewById(R.id.releaseInfoCardTrailer)

        fun bind(trailerItem: ReleaseTrailerSectionItem){
            releaseImageView.loadImage(trailerItem.trailerUrl)
        }
    }

    class mainInfoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var releaseDuration: TextView = itemView.findViewById(R.id.releaseDurationInfo)
        var releaseDirectors: TextView = itemView.findViewById(R.id.releaseDirectorInfo)
        var releaseCast: TextView = itemView.findViewById(R.id.releaseCastInfo)
        var releasePlot: TextView = itemView.findViewById(R.id.releasePlotInfo)

        fun bind(mainInfoItems: ReleaseMainInformationSectionItem){
            releaseDuration.text = mainInfoItems.duration.toString()
            releaseDirectors.text = mainInfoItems.direrectors
            releaseCast.text = mainInfoItems.cast.toString()
            releasePlot.text = mainInfoItems.story
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType){
            PRIMARY_INFO -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.release_primary_information_item, parent, false)
                primaryInfoViewHolder(view)
            }
            TRAILER_INFO -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.release_trailer_info_item, parent, false)
                releaseTrailerInfoViewHolder(view)
            }
            MAIN_INFO -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.release_main_information_item, parent, false)
                mainInfoViewHolder(view)
            }

            else -> throw IllegalArgumentException("Неверный формат данных")

        }
    }


    override fun getItemCount(): Int = releaseInfoItems.size


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is primaryInfoViewHolder -> {
                val primaryInfo = releaseInfoItems[position] as ReleasePrimaryInformationSectionItem
                holder.bind(primaryInfo)
            }
            is releaseTrailerInfoViewHolder -> {
                val trailerInfo = releaseInfoItems[position] as ReleaseTrailerSectionItem
                holder.bind(trailerInfo)
            }
            is mainInfoViewHolder -> {
                val mainInfo = releaseInfoItems[position] as ReleaseMainInformationSectionItem
                holder.bind(mainInfo)
            }
            else -> throw IllegalArgumentException("Неверные данные")
        }
    }


    override fun getItemViewType(position: Int): Int {

        return when (releaseInfoItems[position]){
            is ReleasePrimaryInformationSectionItem -> PRIMARY_INFO
            is ReleaseTrailerSectionItem -> TRAILER_INFO
            is ReleaseMainInformationSectionItem -> MAIN_INFO
            else -> throw IllegalArgumentException("Неверный формат данных")
        }

    }

    companion object {
        private val PRIMARY_INFO = 0
        private val TRAILER_INFO = 1
        private val MAIN_INFO = 2
    }
}