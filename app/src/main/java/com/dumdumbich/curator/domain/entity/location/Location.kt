package com.dumdumbich.curator.domain.entity.location

import com.dumdumbich.curator.domain.entity.location.Address
import com.dumdumbich.curator.domain.entity.location.Coordinates

data class Location(
    val address: Address,
    val coordinates: Coordinates
)
