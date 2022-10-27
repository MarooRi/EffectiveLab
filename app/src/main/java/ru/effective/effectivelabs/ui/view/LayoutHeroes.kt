package ru.effective.effectivelabs.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import ru.effective.effectivelabs.data.Hero
import kotlin.math.abs


@OptIn(ExperimentalSnapperApi::class)
@Preview(showBackground = true)
@Composable
fun LayoutHeroes() {
    var color by remember {
        mutableStateOf(Color.DarkGray)
    }
    val lazyState = rememberLazyListState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxSize()
            .background(color)
    ) {
        Header()
        BoxWithConstraints(
            modifier = Modifier
                .clip(CutCornerShape(bottomEnd = 50.dp))
                .background(
                    Color.DarkGray
                )
        ) {
            val halfWidthOfScreen = constraints.maxWidth / 2
            LazyRow(
                state = lazyState,
                flingBehavior = rememberSnapperFlingBehavior(lazyState),
                contentPadding = PaddingValues(16.dp, 8.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 32.dp)
                    .clip(CutCornerShape(bottomEnd = 50.dp))
            ) {
                itemsIndexed(Hero.create()) { i, hero ->
                    val opacity by remember {
                        derivedStateOf {
                            val currentItemInfo = lazyState.layoutInfo.visibleItemsInfo
                                .firstOrNull { it.index == i }
                                ?: return@derivedStateOf 0.5f
                            val itemHalfSize = currentItemInfo.size / 2
                            (1f - minOf(
                                1f,
                                abs(currentItemInfo.offset + itemHalfSize - halfWidthOfScreen).toFloat() / halfWidthOfScreen
                            ) * 0.1f)
                        }
                    }
                    color = if (opacity in 0.9..1.0) hero.color else Color.DarkGray
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                        .scale(opacity)
                        .alpha(opacity)
                    ) {
                        ImageHero(hero)
                    }
                }
            }
        }
    }
}