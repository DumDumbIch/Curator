package com.dumdumbich.curator.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mentee(
    var name: String
) : Parcelable
