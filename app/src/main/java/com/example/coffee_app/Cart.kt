package com.example.coffee_app


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

@Composable
fun cart(navController: NavHostController) {

    val cursive = FontFamily(Font(R.font.baliana, FontWeight.Bold))
    val increment = remember {
        mutableStateOf(0)
    }
    val increment2 = remember {
        mutableStateOf(0)
    }
    var alertDialog by remember {
        mutableStateOf(false)
    }
    var promocode by remember {
        mutableStateOf("")
    }

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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp),

            ) {
            Text(
                text = "CupfulCanvas", fontSize = 35.sp, fontFamily = cursive,
                color = Color(0xFF392A25),
                textAlign = TextAlign.Center,
                modifier =   Modifier.fillMaxWidth()
            )
            Text(text = "My cart", fontSize = 20.sp, color = Color(0xFF392A25),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp))

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                    .background(
                        Color(0xFFE3D8D3),
                        shape = RoundedCornerShape(20.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.cold_coffee), contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .height(70.dp)
                        .width(70.dp)
                )
                Column(
                    Modifier
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(text = "COLD CREW", color = Color(0xFF220C02), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Large, Almond Milk", color = Color(0xFF6A5750), fontSize = 15.sp,)
                    Text(text = "280", color = Color(0xFF392A25), fontWeight = FontWeight.Black)

                }


                Row(
                    modifier = Modifier
                        .width(90.dp)
                        .padding(end = 10.dp)
                        .border(width = 1.dp, color = Color.Black),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.clickable {if (increment.value>0) increment.value-- }

                    )
                    Text(text = "${ increment.value }")

                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.clickable { increment.value++ }

                    )
                }


            }
            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier
                    .height(80.dp)
                    .fillMaxWidth()
                    .border(width = 1.dp, color = Color.Black, shape = RoundedCornerShape(20.dp))
                    .background(
                        Color(0xFFE3D8D3),
                        shape = RoundedCornerShape(20.dp)
                    ),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(painter = painterResource(id = R.drawable.cold_coffee), contentDescription = null,
                    modifier = Modifier
                        .background(
                            color = Color.White,
                            shape = RoundedCornerShape(20.dp)
                        )
                        .height(70.dp)
                        .width(70.dp)
                )
                Column(
                    Modifier
                        .padding(10.dp)
                        .weight(1f)
                ) {
                    Text(text = "COLD CREW", color = Color(0xFF220C02), fontSize = 15.sp, fontWeight = FontWeight.Bold)
                    Text(text = "Large, Almond Milk", color = Color(0xFF6A5750), fontSize = 15.sp,)
                    Text(text = "280", color = Color(0xFF392A25), fontWeight = FontWeight.Black)

                }


                Row(
                    modifier = Modifier
                        .width(90.dp)
                        .padding(end = 10.dp)
                        .border(width = 1.dp, color = Color.Black),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.clickable { if (increment2.value>0) increment2.value-- }
                    )
                    Text(text = "${ increment2.value }")

                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null,
                        tint = Color.Black,
                        modifier = Modifier.clickable { increment2.value++ }
                    )
                }

            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(text = "Promo code", color = Color(0xFF220C02), fontSize = 15.sp, fontWeight = FontWeight.Bold)

                Button(onClick = { alertDialog=true  },
                    modifier = Modifier.width(120.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF6A5750)
                    )
                ) {
                    Text(text = "Apply")

                }
                if (alertDialog){
                    AlertDialog(onDismissRequest = {alertDialog=false},
                        confirmButton = {
                            Button(onClick = {alertDialog=false},
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF392A25)
                                )

                            ) {
                        Text(text = "Apply")

                    } },
                        dismissButton = {
                            Button(onClick = { alertDialog = false },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color(0xFF392A25)
                                )
                            ) {
                                Text("Dismiss")
                            }
                        },
                        text = {
                            OutlinedTextField(value = promocode ,
                                onValueChange ={promocode=it} ,
                                label = { Text(text ="Promo code")}
                            )
                        },
                        containerColor = Color(0xFFE9C9AD)
                    )

                }

            }


            Column(
                modifier = Modifier.padding(top = 50.dp),
                verticalArrangement = Arrangement.spacedBy(25.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "660", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Discount", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "10%", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
                Row(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Cart", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                    Text(text = "590", fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
            }
            Spacer(modifier = Modifier.height(90.dp))
            Button(onClick = { navController.navigate(screen.payment.route)  },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)

                    .padding(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF220C02)
                ),
                shape = RoundedCornerShape(5.dp)

            ) {
                Text(text = "Check out", fontSize = 17.sp)

            }

        }

    }
}