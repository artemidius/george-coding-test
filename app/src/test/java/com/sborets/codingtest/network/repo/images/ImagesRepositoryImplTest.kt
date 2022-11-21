package com.sborets.codingtest.network.repo.images

import com.sborets.codingtest.common.CoroutineResult
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

internal class ImagesRepositoryImplTest {

    private val client: HttpClient = HttpClient(MockEngine {
        respond(
            content = "",
            status = HttpStatusCode.Unauthorized,
            headers = headersOf(HttpHeaders.ContentType, "application/json")
        )

    })
    private val imageRepo = ImagesRepositoryImpl(client)

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun getImages() = runTest {
        val result = imageRepo.getImages()
        assertThat(result, instanceOf(CoroutineResult.Error::class.java))
    }
}
