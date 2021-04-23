package com.dumdumbich.curator.domain.entity.database

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Table(
    var title: String,
    var description: String,
    var count: Int
) : Parcelable
