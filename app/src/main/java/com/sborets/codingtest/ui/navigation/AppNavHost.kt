package com.sborets.codingtest.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sborets.codingtest.ui.screens.details.DetailsScreen
import com.sborets.codingtest.ui.screens.list.ListScreen
import com.sborets.codingtest.ui.screens.tags.InputScreen

@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = ListOfItems.route,
        modifier = modifier
    ) {
        composable(route = ListOfItems.route) {
            ListScreen(
                onClickCard = { navController.navigate(Details.route) },
                onClickFab = { navController.navigate(Input.route) }
            )
        }

        composable(route = Details.route) {
            DetailsScreen()
        }

        composable(route = Input.route) {
            InputScreen(onSubmit = { navController.popBackStack() })
        }
    }
}
