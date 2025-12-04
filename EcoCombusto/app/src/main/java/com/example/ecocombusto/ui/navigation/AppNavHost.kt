package com.example.ecocombusto.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecocombusto.ui.screens.HomeScreen
import com.example.ecocombusto.ui.screens.ResultScreen

object Routes {
    const val HOME = "home"
    const val RESULT = "result/{carbonKg}"
    fun resultRoute(carbonKg: Float) = "result/$carbonKg"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME,
        modifier = modifier
    ) {
        composable(Routes.HOME) {
            HomeScreen(
                onNavigateToResult = { carbonKg ->
                    navController.navigate(Routes.resultRoute(carbonKg))
                }
            )
        }

        composable(
            route = Routes.RESULT,
            arguments = listOf(
                navArgument("carbonKg") { type = NavType.FloatType }
            )
        ) { entry ->
            val carbonValue = entry.arguments?.getFloat("carbonKg") ?: 0f
            ResultScreen(
                carbonKg = carbonValue,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
