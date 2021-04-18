package com.dumdumbich.curator.domain.entity.location

data class Address(
    val country: String,
    val region: String,
    val settlement: String,
    val street: String,
    val number: Int,
    val letter: String
)
