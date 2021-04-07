package com.dumdumbich.curator.data.image

import android.widget.ImageView
import com.bumptech.glide.Glide

class ImageLoader : IImageLoader<ImageView> {
    override fun load(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }
}