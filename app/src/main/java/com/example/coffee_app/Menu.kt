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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun menu(navController: NavHostController) {

    val cursive = FontFamily(Font(R.font.baliana, FontWeight.Bold))
    var textfield by remember { mutableStateOf("") }
    var isClicked by remember {
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
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "CupfulCanvas", fontSize = 35.sp, fontFamily = cursive,
                color = Color(0xFF392A25),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Good Morning", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(
                value = textfield, onValueChange = { textfield = it },
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .height(35.dp)
                    .fillMaxWidth()
            )

            Text(text = "Categories", fontWeight = FontWeight.Bold, fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp), textAlign = TextAlign.Start
            )




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
                    Text(text = "Cold", fontSize = 15.sp)

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
                    Text(text = "Hot", fontSize = 18.sp)

                }

            }


            Spacer(modifier = Modifier.height(30.dp))



            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(lists){ itezm->

                    list(item = itezm,navController)
                }

            }





        }
    }
}




data class sqlist(val img:Int,val text:String,val price:String)

val lists=  listOf(
    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),

    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),

    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),

    sqlist(R.drawable.cold_coffee,"Frappuciono","250"),
    sqlist(R.drawable.cold_coffee,"Frappuciono","250")

)


@Composable
fun list(item:sqlist,navController: NavHostController) {

    Row(
        modifier = Modifier.fillMaxWidth().clickable { navController.navigate(screen.coffeedetail.route) },
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {

        Column(
            modifier = Modifier
                .height(200.dp).clickable { navController.navigate(screen.coffeedetail.route) }
                .width(160.dp)
                .background(
                    Color(0xFFE3D8D3),
                    shape = RoundedCornerShape(15.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(15.dp)
                )
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.img), contentDescription = null,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(110.dp)
                    .width(140.dp).clickable { navController.navigate(screen.coffeedetail.route) }
            )



            Text(
                text = item.text,
                color = Color(0xFF220C02),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp)
            )


            Spacer(modifier = Modifier.padding(5.dp))

            Row(

                modifier = Modifier
                    .fillMaxWidth().clickable { navController.navigate(screen.coffeedetail.route) }
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.price, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = null,
                    Modifier.size(30.dp)
                )
            }

        }






        Column(
            modifier = Modifier
                .height(200.dp)
                .width(160.dp)
                .background(
                    Color(0xFFE3D8D3),
                    shape = RoundedCornerShape(10.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.Black,
                    shape = RoundedCornerShape(15.dp)
                )
            ,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = item.img), contentDescription = null,
                modifier = Modifier
                    .background(
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(110.dp)
                    .width(140.dp)
            )

            Text(
                text = item.text,
                color = Color(0xFF220C02),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, top = 5.dp)
            )


            Spacer(modifier = Modifier.padding(5.dp))

            Row(

                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = item.price, fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = null,
                    Modifier.size(30.dp)
                )
            }

        }
    }
}


