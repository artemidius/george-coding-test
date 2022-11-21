package com.sborets.codingtest.network.repo.images

import com.sborets.codingtest.common.CoroutineResult
import com.sborets.codingtest.network.repo.images.model.ImageListResponse
import com.sborets.codingtest.network.repo.images.model.ImageTDO
import io.ktor.client.*
import io.ktor.client.request.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
//TODO:TEST
class ImagesRepositoryImpl @Inject constructor (
    private val client: HttpClient
) : ImagesRepository {
    private val url = "https://api.flickr.com/services/feeds/photos_public.gne"
    override suspend fun getImages(tags: String?): CoroutineResult<List<ImageTDO>> =
        withContext(Dispatchers.IO) {
            try {
                val response: ImageListResponse = client.get(url) {
                    url {
                        parameters.append("format", "json")
                        parameters.append("nojsoncallback", "1")

                        if (!tags.isNullOrEmpty()) {
                            val tagsStr = tags.split(" ").joinToString(separator = ",") //TODO: Remome to external UseCase
                            parameters.append("tags", tagsStr)
                        }
                    }
                }
                CoroutineResult.Success(response.items)
            } catch (e: Throwable) {
                CoroutineResult.Error(e)
            }
        }
}
