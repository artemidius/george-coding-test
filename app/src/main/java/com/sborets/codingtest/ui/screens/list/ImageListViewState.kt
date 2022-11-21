package com.sborets.codingtest.ui.screens.list

sealed class ImageListViewState {
    object Loading : ImageListViewState()
    object Error : ImageListViewState()
    class Success(val data: List<ImageListItem>) : ImageListViewState()
}