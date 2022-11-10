package ru.effective.effectivelabs.navigation

import androidx.navigation.NavType
import androidx.navigation.navArgument

interface Navigation {
    val route: String
}

object StartList : Navigation {
    override val route = "list"
}
object HeroDescription : Navigation {
    override val route = "hero"
    const val typeArgs = "id"
    val routeWithArgs = "$route/{$typeArgs}"

    val arguments = listOf(
        navArgument(typeArgs) { type = NavType.StringType }
    )

    fun navigation(id: Int): String =
        "$route/$id"
}
