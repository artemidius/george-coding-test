package com.sborets.codingtest.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton
@Singleton
class StorageRepositoryImpl<T> @Inject constructor(): StorageRepository<T> {

    private val storage = HashMap<String, T>()
    private val _bus = MutableStateFlow<Pair<String, T?>>(Pair("", null))

    override val dataUpdateBus: Flow<Pair<String, T?>>
        get() = _bus

    override fun persistData(key: String, data: T) {
        storage[key] = data
        _bus.value = Pair(key, data)
    }

    override fun getData(key: String): T? {
        return storage[key]
    }
}
