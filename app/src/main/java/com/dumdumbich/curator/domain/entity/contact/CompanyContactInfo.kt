package com.dumdumbich.curator.domain.entity.contact

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompanyContactInfo(
    var name: String
) : Parcelable