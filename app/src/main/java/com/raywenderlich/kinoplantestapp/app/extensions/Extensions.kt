package com.raywenderlich.kinoplantestapp.app.extensions


import android.widget.ImageView
import com.raywenderlich.kinoplantestapp.model.Release
import com.raywenderlich.kinoplantestapp.presentation.screens.releaseRepertoryInfoScreen.adapters.*
import com.raywenderlich.kinoplantestapp.presentation.screens.releases.ReleaseRepertoryItem
import com.squareup.picasso.Picasso
import org.threeten.bp.Duration


fun ImageView.loadImage(url: String?){
    Picasso.get().load(url).into(this)
}


fun Release.toReleaseRepertoryItem() = ReleaseRepertoryItem(
    poster = this.posterUrl,
    genre = this.genres.first(),
    title = this.title,
    release = this
)

fun toThreeTenABPDuration(time: Long): String {
    var time =  Duration.ofMinutes(time) //конвертим в экземпляр класса с представлением минут
    var hours = time.toHours() //конвертим в часы
    var remainingMinutes = time.minusMinutes(hours).toMinutes()
    return "$hours ч. $remainingMinutes мин. "
}

fun convertDateToCorrectFormat(date: String): String{
    val splitter = "-"
    val splittedDate = date.split(splitter)
    val monthWords = mapOf(1 to "января", 2 to "февраля", 3 to "марта", 4 to "апреля",
        5 to "мая", 6 to "июня", 7 to "июля", 8 to "августа", 9 to "сентября", 10 to "октября",
        11 to "ноября", 12 to "декабря"
    )
    val monthName = monthWords[splittedDate[1].toInt()]
    val dayName = splittedDate[2].toInt()
    return("С $dayName $monthName ${splittedDate[0]}")
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