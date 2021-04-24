package com.dumdumbich.curator.data.db.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


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