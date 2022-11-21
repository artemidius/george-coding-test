package com.sborets.codingtest.data

import com.sborets.codingtest.ui.screens.list.ImageListItem
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test


internal class StorageRepositoryImplTest {
    @Test
    fun `data read-write operations works fine with string`() {
        val stringRepo = StorageRepositoryImpl<Int>()
        val key = "Unique Key"
        val data = 666
        stringRepo.persistData(key, data)
        assertThat(stringRepo.getData(key), equalTo(data))
    }

    @Test
    fun `data read-write operations works fine with ImageItem`() {
        val stringRepo = StorageRepositoryImpl<ImageListItem>()
        val key = "Unique Key"
        val data = ImageListItem(title = "Hello World", url = "www.google.com")
        stringRepo.persistData(key, data)
        assertThat(stringRepo.getData(key), equalTo(data))
    }

    @Test
    fun `dataUpdateBus emits events on data write operations`() = runTest {
        val stringRepo = StorageRepositoryImpl<Int>()
        val actual = mutableListOf<Int>()
        val collectJob = launch(UnconfinedTestDispatcher()) {
            stringRepo.dataUpdateBus.collect {
                actual.add(it.second?:0)
            }
        }
        val key = "Unique Key"
        val data = 666
        stringRepo.persistData(key, data)
        assert(actual[1] == data)
        collectJob.cancel()
    }
}
