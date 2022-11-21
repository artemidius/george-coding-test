package com.sborets.codingtest.network.repo.images.model

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class Media(
    @SerialName("m")
    val url: String,
)