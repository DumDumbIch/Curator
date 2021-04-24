package com.dumdumbich.curator.data.db.room.coordinate

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class CoordinateEntity(
    @PrimaryKey val id: String,
    val latitude: String,
    val longitude: String
)