package com.sample.base.utils

import android.app.Activity
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.myapplication.base.R
import com.google.android.material.snackbar.Snackbar
import java.text.SimpleDateFormat
import java.util.Locale

fun View.showToast(
    @StringRes messageRes: Int,
    length: Int = Snackbar.LENGTH_LONG,
    f: Snackbar.() -> Unit
) {
    val snackBar = Snackbar.make(this, resources.getString(messageRes), length)
    snackBar.f()
    snackBar.show()
}

fun View.showToast(
    message: String,
    length: Int = Snackbar.LENGTH_LONG,
) {
    val snackBar = Snackbar.make(this, message, length)
    snackBar.show()
}


fun ImageView.loadImage(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .error(R.mipmap.ic_launcher)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

fun ImageView.loadCircularImage(url: String) {
    Glide.with(this)
        .load(url)
        .centerCrop()
        .error(R.mipmap.ic_launcher_round)
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(this)
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}

fun Activity.getColorRes(@ColorRes id: Int) = ContextCompat.getColor(applicationContext, id)

@BindingAdapter("dateFormatter")
fun TextView.dateFormatter(string: String?) {
    if (string?.isNotEmpty() == true) {
        val date = SimpleDateFormat("yyyy-mm-dd'T'HH:mm:ss'Z'", Locale.getDefault()).parse(string)
        date?.let {
            val format = SimpleDateFormat("dd/MM/yyy", Locale.getDefault())
            this.text = format.format(it)
        }

    }

}