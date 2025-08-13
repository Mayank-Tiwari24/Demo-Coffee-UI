package com.example.coffee_app

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun notification(navController: NavHostController) {
    val cursive = FontFamily( Font(R.font.baliana, FontWeight.Bold)  )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.bgimage), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF392A25))

        )
        Text(text = "CupfulCanvas", fontSize = 35.sp, fontFamily = cursive,
            color = Color(0xFF392A25), textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(top = 15.dp)
        )

        IconButton(
            onClick = {navController.navigate(screen.home.route)},
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = null,
                tint = Color.Black
            )
        }



        Text(text = "No notification", fontWeight = FontWeight.Bold, fontSize = 22.sp,
            color = Color(0xFF392A25),

            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.Center)

        )


    }
}