package com.dumdumbich.curator.data.db.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class CoordinatesEntity(
    @PrimaryKey val id: String,
    val latitude: String,
    val longitude: String
)