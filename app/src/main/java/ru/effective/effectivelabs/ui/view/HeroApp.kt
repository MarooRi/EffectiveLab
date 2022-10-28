package ru.effective.effectivelabs.ui.view

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ru.effective.effectivelabs.data.Hero

@Composable
fun HeroApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "List") {
        composable("List") { LayoutHeroes(navController) }
        composable(
            "hero/{Id}",
            arguments = listOf(navArgument("Id") { type = NavType.StringType })
        ) { backStack ->
            Profile(navController, Hero.create()[backStack.arguments?.getString("Id")?.toInt()!!])
        }
    }
}
