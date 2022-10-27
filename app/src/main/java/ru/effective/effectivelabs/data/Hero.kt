package ru.effective.effectivelabs.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import ru.effective.effectivelabs.R

class Hero(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @DrawableRes val color: Color
) {
    companion object {
        fun create() = listOf(
            Hero(R.drawable.thor, R.string.thor, Color.Blue),
            Hero(R.drawable.doctor, R.string.doctor, Color(60, 40, 80)),
            Hero(R.drawable.thor, R.string.thor, Color.Blue),
            Hero(R.drawable.doctor, R.string.doctor, Color(60, 40, 80))
        )
    }
}
