package com.example.coffee_app


import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun thankyou(navController: NavHostController) {
    val cursive = FontFamily(Font(R.font.baliana, FontWeight.Bold))


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
    }




    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(15.dp),
    ) {
        Text(
            text = "CupfulCanvas", fontSize = 35.sp, fontFamily = cursive,
            color = Color(0xFF392A25),
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        IconButton(
            onClick = { navController.navigate(screen.payment.route) },
            Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack, contentDescription = null,

                )
        }

        Text(text = "Thank you for order!", fontSize = 20.sp, color = Color(0xFF392A25),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 15.dp))


        Spacer(modifier = Modifier.height(30.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(
                    color = Color(0xFFE3D8D3)
                )
        ){
            Text(text ="Order number" , fontSize = 20.sp, modifier = Modifier.padding(start = 20.dp))
            Box(
                modifier = Modifier.size(50.dp),
                contentAlignment = Alignment.Center // Centers the text inside the circle
            ) {
                Canvas(modifier = Modifier.fillMaxSize()) {
                    drawCircle(
                        color = Color(0xFF392A25),
                        radius = size.minDimension / 2
                    )
                }
                BasicText(
                    text = "84", // Your text here
                    style = TextStyle(color = Color.White, fontSize = 24.sp) // Customize the text style
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
        ) {
            Text(text = "Pick-up time", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF392A25))

            Text(text = "9:00 AM", fontSize = 18.sp, color = Color(0xFF392A25))

        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(text = "Pick-up Location", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF392A25))

            Text(text = "23-b, Sector C,\n Indrapuri, Bhopal, Madhya Pradesh \n 462022 · 7.7 km", fontSize = 18.sp, color = Color(0xFF392A25), textAlign = TextAlign.End)

        }

        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Order tracking", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF392A25))
        Spacer(modifier = Modifier.height(50.dp))

        Text(text = "→\tOrder placed", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF392A25))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "→\tPreparing", fontSize = 20.sp, fontWeight = FontWeight.Light, color = Color(0xFF392A25))
        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "→\tOrder is ready", fontSize = 20.sp, fontWeight = FontWeight.ExtraLight, color = Color(0xFF392A25))

        Spacer(modifier = Modifier.height(50.dp))

        Button(onClick = { navController.navigate(screen.home.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)

                .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF220C02)
            ),
            shape = RoundedCornerShape(5.dp)

        ) {
            Text(text = "Back Home", fontSize = 17.sp)

        }



    }


}


