package com.sborets.codingtest.ui.screens.tags

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sborets.codingtest.R

@Composable
fun InputScreen(
    onSubmit:() -> Unit = {},
    viewModel: InputViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        var text by remember { mutableStateOf("") }
        Text(
            text = stringResource(R.string.input_screen_title),
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.height(32.dp))
        TextInput(initialText = viewModel.getCurrentTags(), onChange = { text = it })
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                viewModel.saveTags(text)
                onSubmit()
            },
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
        ) {
            Text(text = stringResource(R.string.button_text_submit), color = Color.White)
        }
    }
}

@Composable
fun TextInput(initialText: String = "", onChange: (String) -> Unit) {
    var text by remember { mutableStateOf(initialText) }
    val re = Regex("[^A-Za-z0-9 ]")
    OutlinedTextField(
        modifier = Modifier.fillMaxWidth(),
        value = text,
        onValueChange = {
            text = re.replace(it, "") //filter out service symbols
            onChange(text)
        },
        label = { Text(stringResource(R.string.edittext_hint_tags)) }
    )
}
