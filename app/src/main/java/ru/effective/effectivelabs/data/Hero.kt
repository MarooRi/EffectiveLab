package ru.effective.effectivelabs.data

import androidx.compose.foundation.Image
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.effective.effectivelabs.R
import ru.effective.effectivelabs.ui.theme.Purple500

data class Hero(
    val image: String,
    @StringRes val title: Int,
    @DrawableRes val color: Color
) {
    companion object {
        fun create() = listOf(
            Hero( "https://vignette1.wikia.nocookie.net/marvelmovies/images/5/52/Thor_03.jpg/revision/latest/scale-to-width-down/2000?cb=20121012073645", R.string.thor, Color.Blue),
            Hero("https://www.iamag.co/wp-content/uploads/2016/11/doctor-strange-ca2-770x1024.jpg", R.string.doctor, Purple500),
            Hero("https://vignette1.wikia.nocookie.net/marvelmovies/images/5/52/Thor_03.jpg/revision/latest/scale-to-width-down/2000?cb=20121012073645", R.string.thor, Color.Blue),
            Hero("https://www.iamag.co/wp-content/uploads/2016/11/doctor-strange-ca2-770x1024.jpg", R.string.doctor, Purple500)
        )
    }
}
