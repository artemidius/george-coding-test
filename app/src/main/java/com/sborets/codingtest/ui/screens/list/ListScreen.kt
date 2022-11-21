package com.sborets.codingtest.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import com.sborets.codingtest.ui.kit.ImageCard
import com.sborets.codingtest.ui.kit.ProgressBar
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect

@Composable
fun ListScreen(
    onClickCard: () -> Unit = {},
    onClickFab: () -> Unit = {},
    viewModel: ListViewModel = hiltViewModel(),
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        color = MaterialTheme.colors.background
    ) {
        val state: ImageListViewState by viewModel.uiState.collectAsState()
        when (state) {
            ImageListViewState.Error -> {
                //TODO: IMPLEMENT ERROR SCREEN
            }
            ImageListViewState.Loading -> {
                ProgressBar()
            }
            is ImageListViewState.Success -> {
                ImagesList(
                    images = (state as ImageListViewState.Success).data,
                    onClickCard = {
                        viewModel.saveChosenImage(it)
                        onClickCard()
                    },
                    onClickFab = onClickFab
                )
            }
        }
    }
}

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ImagesList(
    images: List<ImageListItem>,
    onClickCard: (ImageListItem) -> Unit,
    onClickFab: () -> Unit
) {
    Scaffold(
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(onClick = onClickFab) {
                Row(
                    modifier = Modifier.padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.Add, "")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Tags")
                }
            }
        }
    ) {
        LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
            items(images) { image ->
                ImageCard(image) {
                    onClickCard(it)
                }
            }
        }
    }
}
