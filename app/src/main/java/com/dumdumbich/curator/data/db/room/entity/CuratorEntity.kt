package com.dumdumbich.curator.data.db.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PersonalEntity::class,
            parentColumns = ["id"],
            childColumns = ["personalId"]
        )
    ]
)
class CuratorEntity(
    @PrimaryKey val id: String,
    val nick: String,
    val position: String,
    val personalId: String
)