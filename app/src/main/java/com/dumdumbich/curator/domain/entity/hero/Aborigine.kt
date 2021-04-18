package com.dumdumbich.curator.domain.entity.hero

import android.os.Parcelable
import com.dumdumbich.curator.domain.entity.contact.PersonalContactInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Aborigine(
    var contactInfo: PersonalContactInfo
) : Parcelable