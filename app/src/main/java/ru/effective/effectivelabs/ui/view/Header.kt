package ru.effective.effectivelabs.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.effective.effectivelabs.R

@Preview(showBackground = true)
@Composable
fun Header(){
    Column(modifier = Modifier.background(Color.DarkGray).fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.marvel),
            contentDescription = "Marvel Logo",
            modifier = Modifier
                .width(120.dp)
                .padding(top = 32.dp, bottom = 32.dp),
            contentScale = ContentScale.Fit
        )
        Text(
            text = stringResource(id = R.string.hero),
            color = Color.White,
            fontSize = 30.sp,
            modifier = Modifier.padding( bottom = 32.dp),
            fontWeight = FontWeight.Bold
        )
    }
}