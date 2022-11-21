package com.sborets.codingtest.ui.screens.tags

import androidx.lifecycle.ViewModel
import com.sborets.codingtest.data.StorageRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val tagStore: StorageRepository<String>
): ViewModel() {
    fun saveTags(tags: String) {
        tagStore.persistData(StorageRepository.tagsKey, tags)
    }
    fun getCurrentTags(): String = tagStore.getData(StorageRepository.tagsKey)?:""
}