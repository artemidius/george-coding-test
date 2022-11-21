package com.sborets.codingtest.network.repo.images.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ImageTDO(
    val title: String,
    val media: Media,
    @SerialName("tags")
    val tagsString: String
) {
    val imageUrl: String
        get() = media.url
    val tags: List<String>
        get() = tagsString.split(" ")
}