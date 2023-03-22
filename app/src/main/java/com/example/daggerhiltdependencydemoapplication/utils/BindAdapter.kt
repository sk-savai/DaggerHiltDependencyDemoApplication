package com.example.daggerhiltdependencydemoapplication.utils


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.daggerhiltdependencydemoapplication.R



class BindAdapter {

    companion object {

        @JvmStatic
        @BindingAdapter("android:loadImage")

        fun ImageView.loadImage(url: String?) {
            if (url != null && url.isNotEmpty()) {
                 Glide.with(this.context)
                     .load(url)
                     .error(R.drawable.ic_launcher_background)
                     .into(this)

            }
        }

    }
}