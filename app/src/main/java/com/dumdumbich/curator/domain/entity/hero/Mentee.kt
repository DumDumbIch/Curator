package com.dumdumbich.curator.domain.entity.hero

import android.os.Parcelable
import com.dumdumbich.curator.domain.entity.contact.CompanyContactInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Mentee(
    var contactInfo: CompanyContactInfo
) : Parcelable
