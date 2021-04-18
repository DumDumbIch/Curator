package com.dumdumbich.curator.domain.entity.hero

import android.os.Parcelable
import com.dumdumbich.curator.domain.entity.contact.PersonalContactInfo
import kotlinx.parcelize.Parcelize

@Parcelize
data class Curator(
    var contactInfo: PersonalContactInfo
) : Parcelable