package com.dumdumbich.curator.data.db.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
class PersonalEntity(
    @PrimaryKey val id: String,
    val firstName: String,
    val middleName: String,
    val lastName: String
)