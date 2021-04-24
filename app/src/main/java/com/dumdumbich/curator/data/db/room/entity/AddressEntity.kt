package com.dumdumbich.curator.data.db.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CoordinatesEntity::class,
            parentColumns = ["id"],
            childColumns = ["coordinatesId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
class AddressEntity(
    @PrimaryKey val id: String,
    val country: String,
    val region: String,
    val settlement: String,
    val street: String,
    val number: String,
    val letter: String,
    val flat: String,
    val room: String,
    val coordinatesId: String
)