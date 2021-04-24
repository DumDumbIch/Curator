package com.dumdumbich.curator.data.db.room.entity

import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    foreignKeys = [
        ForeignKey(
            entity = CompanyEntity::class,
            parentColumns = ["id"],
            childColumns = ["companyId"]
        ),
        ForeignKey(
            entity = CuratorEntity::class,
            parentColumns = ["id"],
            childColumns = ["curatorId"]
        ),
        ForeignKey(
            entity = AborigineEntity::class,
            parentColumns = ["id"],
            childColumns = ["aborigineId"]
        )
    ]
)
class MenteeEntity(
    val id: String,
    val nick: String,
    val description: String,
    val companyId: String,
    val curatorId: String,
    val aborigineId: String
)