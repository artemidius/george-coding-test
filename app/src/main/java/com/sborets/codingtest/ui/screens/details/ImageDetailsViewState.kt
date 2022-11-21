package com.sborets.codingtest.ui.screens.details

import com.sborets.codingtest.ui.screens.list.ImageListItem

sealed class ImageDetailsViewState {
    object Loading : ImageDetailsViewState()
    object Error : ImageDetailsViewState()
    class Success(val data: ImageListItem) : ImageDetailsViewState()
}