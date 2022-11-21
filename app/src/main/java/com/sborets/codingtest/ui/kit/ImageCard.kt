package com.sborets.codingtest.ui.kit

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.sborets.codingtest.ui.screens.list.ImageListItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImageCard(image: ImageListItem, onClickCard: (ImageListItem) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(320.dp)
            .padding(bottom = 16.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        onClick = {
            onClickCard(image)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            ImageLarge(image.url)
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                modifier = Modifier.padding(start = 16.dp),
                text = image.title.ifBlank { "<no title>" },
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
    }

}