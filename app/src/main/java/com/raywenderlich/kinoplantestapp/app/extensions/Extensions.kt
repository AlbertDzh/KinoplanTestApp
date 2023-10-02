package com.raywenderlich.kinoplantestapp.app.extensions

import android.widget.ImageView
import androidx.appcompat.view.menu.MenuView
import com.squareup.picasso.Picasso




fun ImageView.loadImage(url: String?){
    Picasso.get().load(url).into(this)
}
