package ru.effective.effectivelabs.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import ru.effective.effectivelabs.R
import ru.effective.effectivelabs.data.Hero

@Composable
fun ImageHero(hero: Hero) {
    Box(
        contentAlignment = Alignment.BottomStart,
        modifier = Modifier.background(Color.White)
    ) {
        AsyncImage(model = hero.image, contentDescription = null,
            placeholder = painterResource(id = R.drawable.loading_img),
            error = painterResource(id = R.drawable.ic_connection_error),
            modifier = Modifier.size(height = 500.dp, width = 300.dp),
            contentScale = ContentScale.Crop)
        Text(
            text = stringResource(id = hero.title),
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 20.dp, start = 20.dp),
            fontWeight = FontWeight.Bold
        )
    }
}