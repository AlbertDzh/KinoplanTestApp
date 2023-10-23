package com.raywenderlich.kinoplantestapp.app.extensions


import android.content.Context
import android.provider.Settings.System.getString
import android.widget.ImageView
import com.raywenderlich.kinoplantestapp.R
import com.raywenderlich.kinoplantestapp.model.Release
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.*
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.ReleaseRepertoryItem
import com.squareup.picasso.Picasso
import org.threeten.bp.Duration
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import java.util.*


fun ImageView.loadImage(url: String?){
    Picasso.get().load(url).into(this)
}


fun Release.toReleaseRepertoryItem() = ReleaseRepertoryItem(
    poster = this.posterUrl,
    genre = this.genres.first(),
    title = this.title,
    release = this
)

fun Long.toThreeTenABPDuration(context: Context): String {
    var time =  Duration.ofMinutes(this) //конвертим в экземпляр класса с представлением минут
    var hours = time.toHours() //конвертим в часы
    var remainingMinutes = time.minusMinutes(hours).toMinutes()
    return context.getString(R.string.release_duration_format, hours, remainingMinutes)
}

fun String.convertDateToCorrectFormat(context: Context): String{
    var formatter = DateTimeFormatter.ofPattern("d MMMM yyyy").withLocale(Locale("ru"))
    var formattedDate = context.getString(R.string.premier_date_format, LocalDate.parse(this).format(formatter))
    return formattedDate
}

fun Release.toReleaseInfoCardItemList(): List<ReleaseInfoCardItem> {
    return listOf(
        ReleasePrimaryInformationSectionItem(this.ageRating, this.genres.first(), this.premiere, this.countries.joinToString(", "), this.posterUrl),
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