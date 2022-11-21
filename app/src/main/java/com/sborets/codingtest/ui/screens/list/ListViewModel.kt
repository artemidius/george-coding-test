package com.sborets.codingtest.ui.screens.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sborets.codingtest.common.CoroutineResult
import com.sborets.codingtest.data.StorageRepository
import com.sborets.codingtest.network.repo.images.ImagesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val imageRepository: ImagesRepository,
    private val imageStore: StorageRepository<ImageListItem>,
    private val tagsStore: StorageRepository<String>,
) : ViewModel() {
    private val _uiState = MutableStateFlow<ImageListViewState>(value = ImageListViewState.Loading)
    val uiState: StateFlow<ImageListViewState> = _uiState

    //TODO:TEST
    init {
        loadImageList()
        viewModelScope.launch {
            tagsStore.dataUpdateBus.collect {
                it.second?.let { tags ->
                    loadImageList(tags)
                }
            }
        }
    }

    fun saveChosenImage(imageListItem: ImageListItem) {
        imageStore.persistData(StorageRepository.imageKey, imageListItem)
    }

    private fun loadImageList(tags: String? = null) {
        _uiState.value = ImageListViewState.Loading
        viewModelScope.launch {
            when (val result = imageRepository.getImages(tags)) {
                is CoroutineResult.Error -> _uiState.value = ImageListViewState.Error
                is CoroutineResult.Success -> {
                    val data = result.data.map {
                        ImageListItem(
                            title = it.title,
                            url = it.imageUrl
                        )
                    }
                    _uiState.value = ImageListViewState.Success(data)
                }
                else -> {
                    //NOTHING ELSE MATTERS HERE
                }
            }
        }
    }
}