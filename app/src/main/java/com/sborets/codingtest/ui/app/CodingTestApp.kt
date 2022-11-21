package com.sborets.codingtest.ui.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sborets.codingtest.ui.navigation.AppNavHost
import com.sborets.codingtest.ui.theme.CodingTestTheme

@Composable
fun CodingTestApp() {
    CodingTestTheme {
        val navController = rememberNavController()
        Scaffold { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}
