package com.sborets.codingtest.network.repo.images.model

import kotlinx.serialization.Serializable

@Serializable
data class ImageListResponse (
    val items: List<ImageTDO>
)