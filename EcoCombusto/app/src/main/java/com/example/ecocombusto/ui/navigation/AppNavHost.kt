package com.example.ecocombustao.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecocombustao.ui.screens.HomeScreen
import com.example.ecocombustao.ui.screens.ResultScreen

object Routes {
    const val HOME = "home"
    // passaremos carbonKg como Float (kg)
    const val RESULT = "result/{carbonKg}"
    fun resultRoute(carbonKg: Float) = "result/$carbonKg"
}

@Composable
fun AppNavHost(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME, modifier = modifier) {
        composable(Routes.HOME) {
            HomeScreen(
                onNavigateToResult = { carbonKg ->
                    navController.navigate(Routes.resultRoute(carbonKg))
                }
            )
        }

        composable(
            route = Routes.RESULT,
            arguments = listOf(navArgument("carbonKg") {
                type = NavType.FloatType
            })
        ) { backStackEntry ->
            val arg = backStackEntry.arguments?.getFloat("carbonKg") ?: 0f
            ResultScreen(carbonKg = arg, onBack = { navController.popBackStack() })
        }
    }
}
