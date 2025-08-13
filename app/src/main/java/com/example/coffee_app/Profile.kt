package com.example.coffee_app


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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController


@Composable
fun profile(navController: NavHostController) {

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
        Image(

            painter = painterResource(id = R.drawable.halfbg), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(370.dp)
                .fillMaxWidth()

        )


        Column {


            ConstraintLayout(
                modifier = Modifier
                    .height(362.dp)
                    .fillMaxWidth()
            ) {
                val (text, row, ppbg, name) = createRefs()




                Text(text = "CupfulCanvas", fontSize = 38.sp, fontFamily = cursive,
                    color = Color(0xFFE3C9AD),
                    modifier = Modifier.constrainAs(text) {
                        top.linkTo(parent.top, margin = 10.dp)
                        end.linkTo(parent.end)
                        start.linkTo(parent.start)
                    }

                )
                Row(
                    modifier = Modifier
                        .padding(20.dp)
                        .fillMaxWidth()
                        .constrainAs(row) {
                            top.linkTo(text.bottom)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        },
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Profile", color = Color(0xFFE3C9AD), fontSize = 20.sp)
                    Icon(
                        imageVector = Icons.Default.DateRange, contentDescription = null,
                        tint = Color(0xFFE3C9AD)
                    )
                }


                Image(
                    painter = painterResource(id = R.drawable.profilepicture),
                    contentDescription = null,

                    modifier = Modifier
                        .clip(CircleShape)
                        .size(130.dp)
                        .background(Color(0xFFE3C9AD))
                        .padding(5.dp)
                        .constrainAs(ppbg) {

                            start.linkTo(parent.start, margin = 20.dp)
                            bottom.linkTo(parent.bottom)
                            top.linkTo(parent.top)


                        },

                    )

                Column(
                    modifier = Modifier.constrainAs(name) {
                        start.linkTo(ppbg.end)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                        top.linkTo(parent.top)
                    }
                ) {

                    Text(
                        text = "Mayank Tiwari", color = Color.White, fontSize = 27.sp,
                        modifier = Modifier
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.height(25.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.coinicon),
                            contentDescription = null,
                            tint = Color.Yellow
                        )
                        Text(text = "  98 Coins", color = Color.White, fontSize = 15.sp)

                    }

                }

            }



        Spacer(modifier = Modifier.height(20.dp))

            Text(text = "Account", fontSize = 20.sp, color = Color(0xFF392A25),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp))

            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .background(
                        color = Color(0xFFE3D8D3),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .height(140.dp)
                    .width(350.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                    Text(text = "Account Details", fontSize =15.sp, modifier = Modifier.padding(start = 10.dp)
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .padding(top = 4.dp) // Adjust this padding based on the text size
                        .width(50.dp)
                        .background(Color.Black, RoundedCornerShape(1.dp))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(painter = painterResource(id = R.drawable.cardoption), contentDescription = null, modifier = Modifier.size(22.dp))
                    Text(text = "Payment Details", fontSize =15.sp,modifier = Modifier.padding(start = 10.dp)
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .padding(top = 4.dp)
                        .width(50.dp)
                        .background(Color.Black, RoundedCornerShape(1.dp))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null)
                    Text(text = "Notification Setting", fontSize =15.sp,modifier = Modifier.padding(start = 10.dp)
                    )

                }


            }



            Text(text = "Orders", fontSize = 20.sp, color = Color(0xFF392A25),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp))





            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .background(
                        color = Color(0xFFE3D8D3),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .height(90.dp)
                    .width(350.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center

            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 4.dp)
                ) {
                    Icon(painter = painterResource(id = R.drawable.order), contentDescription = null)
                    Text(text = "Order History", fontSize =15.sp, modifier = Modifier.padding(start = 10.dp)
                    )

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(5.dp)
                        .padding(top = 4.dp)
                        .width(50.dp)
                        .background(Color.Black, RoundedCornerShape(1.dp))
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Icon(painter = painterResource(id = R.drawable.reward), contentDescription = null,modifier = Modifier.size(30.dp))
                    Text(text = "Rewards and Loyalty", fontSize =15.sp,modifier = Modifier.padding(start = 10.dp)
                    )

                }



            }






        }





    }

}