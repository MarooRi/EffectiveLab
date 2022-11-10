package ru.effective.effectivelabs.ui.view

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.effective.effectivelabs.data.Hero
import ru.effective.effectivelabs.navigation.HeroDescription
import ru.effective.effectivelabs.navigation.StartList

@Composable
fun HeroApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = StartList.route) {
        composable(StartList.route) { LayoutHeroes(navController) }
        composable(
            HeroDescription.routeWithArgs,
            arguments = HeroDescription.arguments
        ) { backStack ->
            Profile(navController, Hero.create()[backStack.arguments?.getString(HeroDescription.typeArgs)?.toInt()!!])
        }
    }
}
