package com.sborets.codingtest.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.sborets.codingtest.ui.app.CodingTestApp
import com.sborets.codingtest.ui.theme.CodingTestTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodingTestTheme {
                CodingTestApp()
            }
        }
    }
}
