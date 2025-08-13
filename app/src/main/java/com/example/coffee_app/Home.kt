package com.example.coffee_app


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
fun home(navController: NavHostController) {

    val cursive = FontFamily( Font(R.font.baliana, FontWeight.Bold)  )
    var textfield by remember { mutableStateOf("") }



    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.bgimage), contentDescription = null,
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
            Text(text = "CupfulCanvas", fontSize = 35.sp, fontFamily = cursive,
                color = Color(0xFF392A25),
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween

            ) {
                Text(text = "Good Morning", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                IconButton(onClick = { navController.navigate(screen.notification.route) }) {
                    Icon(imageVector = Icons.Default.Notifications, contentDescription = null)


                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            OutlinedTextField(value = textfield , onValueChange = {textfield=it},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null )
                },
                shape = RoundedCornerShape(30.dp),
                modifier = Modifier
                    .height(35.dp)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(20.dp))

            Image(painter = painterResource(id = R.drawable.coffeepss), contentDescription = null )

            Text(text = "Daily Specials", fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )

            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(top = 20.dp, bottom = 20.dp, end = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(coffeeitem   ){
                        item->
                    lazyrow(item = item,navController)
                }

            }



            Text(text = "Daily Specials", fontWeight = FontWeight.Bold, fontSize = 18.sp, textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            )
            
            Spacer(modifier = Modifier.height(15.dp))


            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(list){
                        items->
                    lazycolumn(columnlist = items,navController)
                }

            }



        }

    }


}

data class coffeeRow(val image:Int,val text:String,val price:String)

val coffeeitem = listOf(

    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),

    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250"),
    coffeeRow(R.drawable.cold_coffee,"Iced Latte","250")

)


@Composable
fun lazyrow(item:coffeeRow,navController: NavHostController) {

    Column(
        modifier = Modifier
            .height(120.dp)
            .width(80.dp)
            .clickable { navController.navigate(screen.coffeedetail.route) }
            .background(
                Color(0xFFE3D8D3),
                shape = RoundedCornerShape(10.dp)
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = item.image), contentDescription = null ,
            modifier = Modifier
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(10.dp)
                )
                .height(50.dp)
                .width(60.dp)
        )

        Text(text = item.text, color =  Color(0xFF220C02), fontSize = 15.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp)
        )


        Spacer(modifier = Modifier.padding(5.dp))

        Row (

            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 5.dp, end = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(text = item.price)
            Icon(imageVector = Icons.Default.AddCircle, contentDescription = null )
        }

    }

}


data class columnlist(val text1:String,val text2: String,val price: String)

val list = listOf(
    columnlist("COLD BREW","Large,Almond Milk","250"),
    columnlist("COLD BREW","Large,Almond Milk","250"),

    columnlist("COLD BREW","Large,Almond Milk","250"),
    columnlist("COLD BREW","Large,Almond Milk","250"),

    columnlist("COLD BREW","Large,Almond Milk","250"),
    columnlist("COLD BREW","Large,Almond Milk","250"),

    columnlist("COLD BREW","Large,Almond Milk","250"),
    columnlist("COLD BREW","Large,Almond Milk","250"),

    )

@Composable
fun lazycolumn(columnlist: columnlist,navController: NavHostController){

    Row(
        modifier = Modifier
            .height(80.dp)
            .clickable { navController.navigate(screen.coffeedetail.route) }
            .fillMaxWidth()
            .background(Color(0xFFE3D8D3), shape = RoundedCornerShape(15.dp)),
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
            Text(text = columnlist.text1, color = Color(0xFF220C02), fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text(text = columnlist.text2, color = Color(0xFF6A5750), fontSize = 15.sp,)
            Text(text = columnlist.price, color = Color(0xFF392A25), fontWeight = FontWeight.Black)

        }


        Box(
            modifier = Modifier.size(50.dp)
        ){
            Image(painter = painterResource(id = R.drawable.blob), contentDescription = null )
            Icon(imageVector = Icons.Default.Add, contentDescription = null,
                tint = Color.White,
                modifier = Modifier.align(Alignment.Center)
            )
        }

    }


}



