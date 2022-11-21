package com.sborets.codingtest.data

import kotlinx.coroutines.flow.Flow

interface StorageRepository<T> {
    companion object {
        val imageKey = "image_key"
        val tagsKey = "tags_key"
    }
    val dataUpdateBus: Flow<Pair<String, T?>>
    fun persistData(key: String, data: T)
    fun getData(key: String): T?
}
