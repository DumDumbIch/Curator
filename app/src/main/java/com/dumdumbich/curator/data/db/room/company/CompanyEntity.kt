package com.dumdumbich.curator.data.db.room.company

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.dumdumbich.curator.data.db.room.address.AddressEntity


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = AddressEntity::class,
            parentColumns = ["id"],
            childColumns = ["addressId"],
        )
    ]
)
class CompanyEntity(
    @PrimaryKey val id: String,
    val name: String,
    val description: String,
    val addressId: String
)