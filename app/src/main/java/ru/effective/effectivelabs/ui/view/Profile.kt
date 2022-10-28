package ru.effective.effectivelabs.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import ru.effective.effectivelabs.data.Hero

@Composable
fun Profile(navController: NavController, hero: Hero) {
    Box {
        Box(contentAlignment = Alignment.BottomStart) {
            AsyncImage(
                model = hero.image,
                modifier = Modifier.fillMaxSize(),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = stringResource(id = hero.title).uppercase(),
                    color = Color.White,
                    fontSize = 30.sp,
                    modifier = Modifier
                        .padding(bottom = 20.dp, start = 20.dp),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = stringResource(id = hero.description).uppercase(),
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(bottom = 20.dp, start = 20.dp),
                )
            }
        }

        IconButton(onClick = { navController.popBackStack() }) {
            Icon(
                Icons.Filled.ArrowBack,
                null,
                tint = Color.White,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
    }
}