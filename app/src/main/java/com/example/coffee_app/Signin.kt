package com.example.coffee_app


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@Composable
fun SignIn(navController: NavController){

    var textfield by remember {
        mutableStateOf("")
    }
    var textfield2 by remember {
        mutableStateOf("")
    }

    Box(    modifier = Modifier.fillMaxSize()
    ) {
        Image(painter = painterResource(id = R.drawable.bgimage), contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF392A25))

        )


        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(painter = painterResource(id = R.drawable.topbg) , contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Sign In",
                color = Color(0xFF392A25),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .fillMaxWidth()  // This ensures the Text takes up the full width of the screen
                    .padding(start = 66.dp),  // Optionally add padding to the left for spacing
                textAlign = TextAlign.Start  // Align the text to the start (left)
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(value = textfield , onValueChange = {textfield=it},
                label = { Text(text = "Enter Email")},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Email, contentDescription = null,
                        tint = Color(0xFF392A25)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,  // Transparent when focused
                    unfocusedContainerColor = Color.Transparent,  // Transparent when not focused

                    focusedIndicatorColor = Color(0xFF392A25),  // Remove the underline when focused
                    unfocusedIndicatorColor = Color(0xFF392A25)  // Remove the underline when not focused
                )

            )

            TextField(value = textfield2 , onValueChange = {textfield2=it},
                label = { Text(text = "Enter Password")},
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Lock, contentDescription = null,
                        tint = Color(0xFF392A25)
                    )
                },
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,  // Transparent when focused
                    unfocusedContainerColor = Color.Transparent,  // Transparent when not focused

                    focusedIndicatorColor = Color(0xFF392A25),  // Remove the underline when focused
                    unfocusedIndicatorColor = Color(0xFF392A25)  // Remove the underline when not focused
                )
            )
            Spacer(modifier = Modifier.height(10.dp))

            Text(text = "Forgot Password", color = Color(0xFF8B5742),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 66.dp),
                textAlign = TextAlign.Start)

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {  navController.navigate(screen.home.route)  },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF392A25) // Set the button color here
                ),
                modifier = Modifier
                    .width(170.dp)
                    .height(50.dp)
                    .shadow(
                        elevation = 18.dp,

                        )
            ) {
                Text(text = "Sign In")
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = buildAnnotatedString {
                withStyle(style = SpanStyle(Color(0xFF8B5742))) { append("Don't have an account?") }
                withStyle(style = SpanStyle(Color(0xFF392A25), fontWeight = FontWeight.Bold)){append("Sign Up")}
            },modifier=Modifier.clickable { navController.navigate(screen.SignUp.route) })

            Spacer(modifier = Modifier.height(20.dp))

            Row(

                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 45.dp, end = 45.dp, top = 5.dp)

            ) {
                Box(modifier = Modifier
                    .height(2.dp)
                    .weight(2f)
                    .background(Color(0xFF8B5742))
                )
                Text(text = "Or",Modifier.weight(0.5f), textAlign = TextAlign.Center)

                Box(modifier = Modifier
                    .height(2.dp)
                    .weight(2f)
                    .background(Color(0xFF8B5742))
                )
            }
            Spacer(modifier = Modifier.height(5.dp))


            Row {
                Image(painter = painterResource(id = R.drawable.fb), contentDescription = null,
                    colorFilter = ColorFilter.tint(Color(0xFF392A25)),
                    modifier = Modifier.size(40.dp))


                Spacer(modifier = Modifier.width(20.dp))

                Image(painter = painterResource(id = R.drawable.telegram), contentDescription = null,
                    colorFilter = ColorFilter.tint(Color(0xFF392A25)),
                    modifier = Modifier.size(40.dp))
            }


        }

    }


}