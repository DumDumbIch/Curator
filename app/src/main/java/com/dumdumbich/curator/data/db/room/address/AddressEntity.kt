package com.dumdumbich.curator.data.db.room.address

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.dumdumbich.curator.data.db.room.coordinate.CoordinateEntity


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CoordinateEntity::class,
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