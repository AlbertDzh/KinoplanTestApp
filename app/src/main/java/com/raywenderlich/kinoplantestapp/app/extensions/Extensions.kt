package com.raywenderlich.kinoplantestapp.app.extensions

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.Release
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.*
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.ReleaseRepertoryItem
import com.squareup.picasso.Picasso



fun ImageView.loadImage(url: String?){
    Picasso.get().load(url).into(this)
}


fun Release.toReleaseRepertoryItem() = ReleaseRepertoryItem(
    poster = this.posterUrl,
    genre = this.genres.first(),
    title = this.title,
    release = this
)

fun Release.toReleaseInfoCardItemList(): List<ReleaseInfoCardItem> {
    return listOf(
        ReleasePrimaryInformationSectionItem(this.ageRating, this.genres.first(), this.duration, this.countries.joinToString(", "), this.posterUrl),
        ReleaseTrailerSectionItem(this.videoThumbnailUrl),
        ReleaseMainInformationSectionItem(this.duration, this.directors.joinToString(", "), this.cast.joinToString(", "), this.story)
    )
}

/*

fun ImageView.loadRoundedImage(url: String?, radiusInDp: Float) {
fun Context.dpToPx(dp: Float): Int {
    val density = resources.displayMetrics.density
    return (dp * density + 0.5f).toInt()
}

val radiusInPx = context.dpToPx(radiusInDp)

val transformation = object : Transformation {
    override fun key(): String {
        return "rounded"
    }

    override fun transform(source: Bitmap): Bitmap {
        val bitmap = Bitmap.createBitmap(source.width, source.height, source.config)
        val canvas = Canvas(bitmap)

        val paint = Paint().apply {
            isAntiAlias = true
            shader = BitmapShader(source, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        }

        val rect = RectF(0f, 0f, source.width.toFloat(), source.height.toFloat())
        canvas.drawRoundRect(rect, radiusInPx.toFloat(), radiusInPx.toFloat(), paint)

        source.recycle()

        return bitmap
    }
}

Picasso.get().load(url).transform(transformation).into(this)
}
 */