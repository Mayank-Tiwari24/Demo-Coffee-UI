package com.example.coffee_app


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController


@Composable
fun coffeedetail(navController: NavHostController) {

    var isClicked by remember {
        mutableStateOf("")
    }
    var milk by remember {
        mutableStateOf(false)
    }
    var cream by remember {
        mutableStateOf(false)
    }
    var syrup by remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.bgimage), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(color = Color(0xFF220C02)),


                ) {
                val (img,icon) = createRefs()


                IconButton(onClick = {navController.navigate(screen.home.route)},
                    Modifier.constrainAs(icon){
                        start.linkTo(parent.start)
                        top.linkTo(parent.top, margin = 15.dp)

                    }
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null,
                        tint = Color.White

                        )
                }



                Image(painter = painterResource(id = R.drawable.cold_coffee), contentDescription = null,
                    modifier = Modifier
                        .height(500.dp)
                        .width(300.dp)
                        .constrainAs(img) {
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                            bottom.linkTo(parent.bottom)
                        }
                )





            }
            Spacer(modifier = Modifier.height(10.dp))


            Column(
                modifier = Modifier.padding(15.dp),

                ) {
                Text(text = "Frappucino", color = Color(0xFF220C02), fontSize = 20.sp)
                Spacer(modifier = Modifier.height(7.dp))

                Text(text = "A Frappuccino is a blended iced coffee drink trademarked by Starbucks, though many other coffee shops offer similar beverages. It combines coffee or cream as a base with ice and various flavors, which are blended together into a smooth, frosty texture.", fontSize = 17.sp)

                Text(text = "Size", fontWeight = FontWeight.Bold, fontSize = 20.sp, modifier = Modifier.padding(top = 10.dp))


                Row(
                    horizontalArrangement = Arrangement.spacedBy(17.dp),
                    modifier = Modifier.padding(top = 20.dp)
                ) {
                    Button(onClick = { isClicked="small"},
                        modifier = Modifier
                            .height(30.dp)
                            .width(120.dp)
                            .weight(0.3f)
                            .background(
                                color = if (isClicked == "small") Color(0xFF220C02) else Color.Transparent,  // Fill background color
                                shape = RoundedCornerShape(20.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = Color(0xFF8A5742),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isClicked=="small") Color(0xFF220C02) else Color.Transparent,
                            contentColor = if (isClicked=="small") Color.White else Color(0xFF220C02)
                        ),
                        contentPadding = PaddingValues(0.dp)


                    ) {
                        Text(text = "Small", fontSize = 15.sp)

                    }


                    Button(onClick = { isClicked="medium"},
                        modifier = Modifier
                            .height(30.dp)
                            .width(120.dp)
                            .weight(0.3f)
                            .background(
                                color = if (isClicked == "medium") Color(0xFF220C02) else Color.Transparent,  // Fill background color
                                shape = RoundedCornerShape(20.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = Color(0xFF8A5742),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = if (isClicked=="medium") Color.White else Color(0xFF220C02)
                        ),
                        contentPadding = PaddingValues(0.dp)


                    ) {
                        Text(text = "Medium", fontSize = 16.sp)

                    }


                    Button(onClick = { isClicked ="large"},
                        modifier = Modifier
                            .height(30.dp)
                            .width(120.dp)
                            .weight(0.3f)
                            .background(
                                color = if (isClicked == "large") Color(0xFF220C02) else Color.Transparent,  // Fill background color
                                shape = RoundedCornerShape(20.dp)
                            )
                            .border(
                                width = 2.dp,
                                color = Color(0xFF8A5742),
                                shape = RoundedCornerShape(20.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor =  Color.Transparent,

                            contentColor = if (isClicked=="large") Color.White else Color(0xFF220C02)
                        ),
                        contentPadding = PaddingValues(0.dp)


                    ) {
                        Text(text = "Large", fontSize = 18.sp)

                    }

                }


                Spacer(modifier = Modifier.height(17.dp))

                Text(text = "Customize your coffee", fontWeight = FontWeight.Bold, fontSize =15.sp)
                Spacer(modifier = Modifier.height(20.dp))


                Row(
                    horizontalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Column(
                        modifier = Modifier.clickable { milk=!milk }
                            .height(90.dp)
                            .width(70.dp)
                            .background(
                                color = Color(0xFFE3D8D3)
                            )
                            .border(width = 2.dp, color = Color(0xFF392A25)),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null )
                        Text(text = "Milk")
                        Text(text = if (milk)"No" else "Yes", fontWeight = FontWeight.Bold)
                    }


                    Column(
                        modifier = Modifier.clickable { cream=!cream }
                            .height(90.dp)
                            .width(70.dp)
                            .background(
                                color = Color(0xFFE3D8D3)
                            )
                            .border(width = 2.dp, color = Color(0xFF392A25)),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null )
                        Text(text = "Cream")
                        Text(text = if (cream)"No" else "Yes", fontWeight = FontWeight.Bold)
                    }

                    Column(
                        modifier = Modifier.clickable { syrup=!syrup }
                            .height(90.dp)
                            .width(70.dp)
                            .background(
                                color = Color(0xFFE3D8D3)
                            )
                            .border(width = 2.dp, color = Color(0xFF392A25)),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Icon(imageVector = Icons.Default.Lock, contentDescription = null )
                        Text(text = "Choclate\n   syrup")
                        Text(text = if (syrup)"No" else "Yes", fontWeight = FontWeight.Bold)
                    }

                }






                Row(
                    modifier = Modifier.padding(top = 16.dp),

                    ) {

                    Column {
                        Text(text = "Total Price", color = Color(0xFF8B5742))
                        Text(text = "400", fontWeight = FontWeight.Bold, fontSize = 22.sp)
                    }

                    Button(onClick = { /*TODO*/ },
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 15.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF220C02)
                        )

                    ) {
                        Text(text = "Add to cart")

                    }

                }





            }
        }


    }

}