package com.sborets.codingtest.ui.screens.details

import androidx.lifecycle.ViewModel
import com.sborets.codingtest.data.StorageRepository
import com.sborets.codingtest.ui.screens.list.ImageListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor (
    storageRepository: StorageRepository<ImageListItem>
): ViewModel() {
    private val _uiState = MutableStateFlow<ImageDetailsViewState>(value = ImageDetailsViewState.Loading)
    val uiState: StateFlow<ImageDetailsViewState> = _uiState

    init {
        val data: ImageListItem? = storageRepository.getData(StorageRepository.imageKey)
        data?.let {
            _uiState.value = ImageDetailsViewState.Success(it)
        }

    }
}