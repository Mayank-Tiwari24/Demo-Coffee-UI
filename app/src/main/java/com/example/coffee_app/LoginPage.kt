package com.example.coffee_app


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun Login(navController: NavHostController) {

    val cursive  = FontFamily(
        Font(R.font.baliana,FontWeight.Bold)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween

    ) {

        Text(text = buildAnnotatedString {
            append("   Welcome to \n")
            withStyle(style = SpanStyle(Color(android.graphics.Color.parseColor("#8B5742")), fontSize = 80.sp, fontFamily = cursive),

                ) { append(" CupfulCanvas \n") }
            append("                          Sip. Smile. Create")
        }, fontSize = 25.sp,
            modifier = Modifier.padding(top = 20.dp)


        )

        Image(painter = painterResource(id = R.drawable.coffeecup) , contentDescription = null,
            modifier = Modifier
                .height(400.dp)
                .width(390.dp)
        )

        Button(onClick = { navController.navigate(screen.SignIn.route) },
            modifier = Modifier
                .height(70.dp)
                .width(150.dp)
                .padding(bottom = 30.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(android.graphics.Color.parseColor("#8B5742"))
            )

        ) {
            Text(text = "Get Started")

        }
    }
}