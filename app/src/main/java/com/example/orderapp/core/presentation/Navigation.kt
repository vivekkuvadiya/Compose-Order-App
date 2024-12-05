package com.example.orderapp.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.orderapp.order_feature.presentation.OrderScreen
import kotlinx.serialization.Serializable

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.OrderScreen
    ){
        composable<Route.OrderScreen>{
            OrderScreen(navController = navController)
        }
    }

}

sealed interface Route {

    @Serializable
    data object OrderScreen : Route

    @Serializable
    data object OrderChooseDelivererScreen : Route

    @Serializable
    data object OrderChooseProductsScreen : Route
}