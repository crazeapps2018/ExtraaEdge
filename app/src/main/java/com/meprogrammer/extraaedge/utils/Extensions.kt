package com.meprogrammer.extraaedge.utils

import android.content.Context
import android.text.SpannableStringBuilder
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.text.bold
import com.bumptech.glide.Glide
import com.meprogrammer.extraaedge.R

fun AppCompatImageView.loadImageFromUrl( context: Context,url:String){
    Glide
        .with(context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.loading_spinner)
        .into(this)
}

fun String.makeStringBold(boldText:String): SpannableStringBuilder {
    val status = SpannableStringBuilder()
        .bold {
            append(boldText) }
        .append(this)
    return status
}

