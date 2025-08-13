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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun payment(navController: NavHostController) {


    val cursive = FontFamily(Font(R.font.baliana, FontWeight.Bold))
    var payment by remember {
        mutableStateOf("upi")
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
            modifier =   Modifier.fillMaxWidth()
        )

        IconButton(onClick = {navController.navigate(screen.cart.route)},
            Modifier.align(Alignment.Start)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null,

                )
        }


        Text(text = "Payment", fontSize = 20.sp, color = Color(0xFF392A25),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp))

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Column(
                modifier = Modifier
                    .height(150.dp)
                    .weight(0.3f)
                    .width(120.dp)
                    .clickable { payment = "upi" }
                    .background(
                        color = if (payment == "upi") Color(0xFF8B5742) else Color(0xFFE3D8D3)
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(painter = painterResource(id = R.drawable.bhimupi), contentDescription = null )
                Text(text = "UPI", color = if (payment=="upi") Color.White else Color(0xFF392A25),
                    fontSize = 17.sp
                )
            }
            Column(
                modifier = Modifier
                    .height(150.dp)
                    .weight(0.3f)
                    .width(120.dp)
                    .clickable { payment = "Card" }
                    .background(
                        color = if (payment == "Card") Color(0xFF8B5742) else Color(0xFFE3D8D3)
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = painterResource(id = R.drawable.cardoption), contentDescription = null )
                Text(text = "Card", color = if (payment=="Card") Color.White else Color(0xFF392A25),
                    fontSize = 17.sp
                )
            }
            Column(
                modifier = Modifier
                    .height(150.dp)
                    .weight(0.3f)
                    .width(120.dp)
                    .clickable { payment = "Cash" }
                    .background(
                        color = if (payment == "Cash") Color(0xFF8B5742) else Color(0xFFE3D8D3)
                    ),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(painter = painterResource(id = R.drawable.cashoption), contentDescription = null )
                Text(text = "Cash", color = if (payment=="Cash") Color.White else Color(0xFF392A25),
                    fontSize = 17.sp
                )
            }

        }


        Spacer(modifier = Modifier.height(90.dp))


        if (payment=="upi"){
            upilist()
        } else if (payment=="Card"){
            card()
        } else{
            Spacer(modifier = Modifier.height(50.dp))
            cashOndelivery()
        }






        Spacer(modifier = Modifier.height(60.dp))


        Button(onClick = { navController.navigate(screen.thanku.route) },
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)

                .padding(15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF220C02)
            ),
            shape = RoundedCornerShape(5.dp)

        ) {
            Text(text = "Place Order", fontSize = 17.sp)

        }


    }





}





@Composable
fun upilist(){
    var radioButton by remember {
        mutableStateOf("paytm")
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { radioButton = "paytm" }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(painter = painterResource(id = R.drawable.paytm), contentDescription = null,Modifier.size(50.dp))

            Text(text = "Paytm         ", fontSize = 18.sp)
            RadioButton(selected =radioButton=="paytm" , onClick = {radioButton="paytm"},
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF220C02),  // Custom selected color
                    unselectedColor = Color.Gray
                )
            )

        }




        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { radioButton = "gpay" }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(painter = painterResource(id = R.drawable.gpay), contentDescription = null,Modifier.size(50.dp))

            Text(text = "Google Pay", fontSize = 18.sp)
            RadioButton(selected =radioButton=="gpay" , onClick = {radioButton="gpay"},
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF220C02),  // Custom selected color
                    unselectedColor = Color.Gray
                )
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { radioButton = "phonepe" }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(painter = painterResource(id = R.drawable.phonepe), contentDescription = null,Modifier.size(50.dp))

            Text(text = "Phone Pay  ", fontSize = 18.sp)
            RadioButton(selected =radioButton=="phonepe" , onClick = {radioButton="phonepe"},
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF220C02),  // Custom selected color
                    unselectedColor = Color.Gray
                )
            )

        }


    }
}


@Composable
fun card() {
    var cardbutton by remember {
        mutableStateOf("debit")
    }


    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { cardbutton = "debit" }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = painterResource(id = R.drawable.debitcard),
                contentDescription = null,
                Modifier.size(50.dp)
            )

            Text(text = "Debit card", fontSize = 18.sp)
            RadioButton(
                selected = cardbutton == "debit", onClick = { cardbutton = "debit" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF220C02),
                    unselectedColor = Color.Gray
                )
            )

        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { cardbutton = "credit" }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = painterResource(id = R.drawable.creditcard),
                contentDescription = null,
                Modifier.size(50.dp)
            )

            Text(text = "Credit card", fontSize = 18.sp)
            RadioButton(
                selected = cardbutton == "credit", onClick = { cardbutton = "credit" },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF220C02),
                    unselectedColor = Color.Gray
                )
            )

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween // Space out the image and text
        ) {
            // Image at the start with some padding
            Image(
                painter = painterResource(id = R.drawable.bank),
                contentDescription = null,
                Modifier
                    .padding(start = 50.dp) // Padding on the start side
                    .size(50.dp)
            )

            Spacer(modifier = Modifier.width(50.dp))
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(0.9f),
                contentAlignment = Alignment.CenterStart // Center the text horizontally and vertically
            ) {
                Text(
                    text = "Add your card",
                    fontSize = 18.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }

    }
}

@Preview
@Composable
fun cashOndelivery(){
    var cash by remember {
        mutableStateOf(true)
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { }
                .height(65.dp)
                .border(width = 2.dp, color = Color.Black),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {

            Image(
                painter = painterResource(id = R.drawable.debitcard),
                contentDescription = null,
                Modifier.size(50.dp)
            )

            Text(text = "Cash On Delivery", fontSize = 18.sp)
            RadioButton(
                selected = cash , onClick = {  },
                colors = RadioButtonDefaults.colors(
                    selectedColor = Color(0xFF220C02),
                    unselectedColor = Color.Gray
                )
            )

        }
        Spacer(modifier = Modifier.height(70.dp))
    }


}