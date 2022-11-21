package com.sborets.codingtest.network.repo.images

import com.sborets.codingtest.common.CoroutineResult
import com.sborets.codingtest.network.repo.images.model.ImageTDO

interface ImagesRepository {
    suspend fun getImages(tags: String? = null): CoroutineResult<List<ImageTDO>>
}
