package com.dumdumbich.curator.domain.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompanyContactInfo(
    var name: String
) : Parcelable