package ru.effective.effectivelabs.ui.view

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.calculateCurrentOffsetForPage
import ru.effective.effectivelabs.data.Hero
import kotlin.math.absoluteValue
import androidx.compose.ui.util.lerp
import androidx.navigation.NavController
import com.google.accompanist.pager.rememberPagerState
import ru.effective.effectivelabs.navigation.HeroDescription


@OptIn(ExperimentalPagerApi::class)
@Composable
fun LayoutHeroes(navController: NavController) {
    val pagerState = rememberPagerState()
    val heroes by remember { mutableStateOf(Hero.create()) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Header()

        HorizontalPager(
            count = heroes.size,
            contentPadding = PaddingValues(40.dp),
            state = pagerState
        ) { page ->
            Card(
                Modifier
                    .width(300.dp)
                    .height(500.dp)
                    .graphicsLayer {
                        // Calculate the absolute offset for the current page from the
                        // scroll position. We use the absolute value which allows us to mirror
                        // any effects for both directions
                        val pageOffset = calculateCurrentOffsetForPage(page).absoluteValue
                        // We animate the scaleX + scaleY, between 85% and 100%
                        lerp(
                            start = 0.85f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        ).also { scale ->
                            scaleX = scale
                            scaleY = scale
                        }
                        // We animate the alpha, between 50% and 100%
                        alpha = lerp(
                            start = 0.5f,
                            stop = 1f,
                            fraction = 1f - pageOffset.coerceIn(0f, 1f)
                        )
                    }
                    .shadow(
                        elevation = 40.dp,
                        spotColor = heroes[page].color,
                        shape = MaterialTheme.shapes.large
                    )
            ) {
                Box(Modifier.clickable { navController.navigate(HeroDescription.navigation(page)) }) {
                    ImageHero(hero = heroes[page])
                }
            }
        }
    }
}
