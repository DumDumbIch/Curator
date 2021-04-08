package com.dumdumbich.curator.data.image

interface IImageLoader<T> {
    fun load(url: String, container: T)
}