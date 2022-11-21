package com.sborets.codingtest.ui.screens.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sborets.codingtest.ui.kit.ImageCard

@Composable
fun DetailsScreen(
   viewModel: DetailsViewModel = hiltViewModel()
) {
   val state: ImageDetailsViewState by viewModel.uiState.collectAsState()
   when(state) {
      ImageDetailsViewState.Error -> {}
      ImageDetailsViewState.Loading -> {}
      is ImageDetailsViewState.Success -> {
         (state as ImageDetailsViewState.Success).data.let {
            Column(
               modifier = Modifier
                  .fillMaxSize()
                  .padding(32.dp),
               verticalArrangement = Arrangement.Center
            ) {
               ImageCard(image = it, onClickCard = {})
            }
         }
      }
   }
}
