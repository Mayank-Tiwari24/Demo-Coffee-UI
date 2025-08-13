package com.example.coffee_app

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCancellationBehavior
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieAnimatable
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay


@Composable
fun BottomBarApp(){

    val navController = rememberNavController()
    val bottombarscreens = listOf("home","menu","cart","profile")
    val currentroute = navController.currentBackStackEntryAsState()?.value?.destination?.route
    Scaffold(
        bottomBar = {
            if (currentroute in bottombarscreens){
                BottomNavigation(navController = navController)
            }
        }

    ) {
        innerpadding->
        NavigationHost(navController=navController,modifier=Modifier.padding(innerpadding))

    }



}

@Composable
fun BottomNavigation(navController: NavHostController) {
    val currentroute = navController.currentBackStackEntryAsState()?.value?.destination?.route



    NavigationBar(
     modifier = Modifier
         .height(60.dp)
         .border(color = Color(0xFF392A25), width = 1.dp),
 containerColor = Color(0xFFE3C9AD)
     )
  {

     NavigationBarItem(
         icon = { Icon(painter = painterResource(id = R.drawable.home), contentDescription = "Home", modifier = Modifier.size(25.dp)) },
         label = { Text("Home") },
         selected = currentroute== screen.home.route,
         onClick = { navController.navigate(screen.home.route) }
     )


     NavigationBarItem(
         icon = { Icon(painter = painterResource(id = R.drawable.menu), contentDescription = "menu", modifier = Modifier.size(25.dp)) },
         label = { Text("menu") },
         selected = currentroute== screen.menu.route,
         onClick = { navController.navigate(screen.menu.route) }
     )


     NavigationBarItem(
         icon = { Icon(painter = painterResource(id = R.drawable.cart), contentDescription = "cart", modifier = Modifier.size(25.dp)) },
         label = { Text("cart") },
         selected = currentroute== screen.cart.route,
         onClick = { navController.navigate(screen.cart.route) }
     )

     NavigationBarItem(
         icon = { Icon(painter = painterResource(id = R.drawable.profile), contentDescription = "profile", modifier = Modifier.size(25.dp)) },
         label = { Text("profile") },
         selected = currentroute== screen.profile.route,
         onClick = { navController.navigate(screen.profile.route) },

     )
 }

}


@Composable
fun NavigationHost(navController:NavHostController,modifier: Modifier){


    NavHost(navController = navController, startDestination = screen.Splash.route ) {

        composable(screen.SignIn.route){
            SignIn(navController)

        }
        composable(screen.SignUp.route){
            SignUp(navController)

        }

        composable(screen.thanku.route){
            thankyou(navController)

        }

        composable(screen.menu.route){
            menu(navController)

        }
        composable(screen.cart.route){
            cart(navController)

        }

        composable(screen.coffeedetail.route){
            coffeedetail(navController)

        }
        composable(screen.loginpage.route){
            Login(navController)

        }
        composable(screen.payment.route){
            payment(navController)

        }



        composable(screen.home.route){
            home(navController)

        }


        composable(screen.profile.route){
            profile(navController)

        }
        composable(screen.Splash.route){
            SplashScreen(navController)

        }

        composable(screen.notification.route){
            notification(navController)

        }


    }

}

sealed class screen(val route:String){


    object SignIn: screen("SignIn")
    object SignUp: screen("SignUp")
    object thanku: screen("thanku")
    object menu: screen("menu")
    object cart: screen("cart")
    object coffeedetail: screen("details")
    object loginpage: screen("loginpage")
    object payment: screen("paymentdone")
    object home: screen("home")
    object profile: screen("profile")
    object Splash: screen("Splash")
    object notification: screen("notification")








}

@Composable
fun SplashScreen(navController: NavHostController) {
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(R.raw.coffeeanim)
    )

    val lottieAnimatable = rememberLottieAnimatable()

    LaunchedEffect(composition) {
        lottieAnimatable.animate(
            composition = composition,
            initialProgress = 0f
        )
        // Navigate to main screen after animation
        delay(400)
        navController.navigate(screen.loginpage.route) {
            popUpTo(screen.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE3C9AD)),
        contentAlignment = Alignment.Center
    ) {
        LottieAnimation(
            composition = composition,
            progress = lottieAnimatable.progress,
            modifier = Modifier.size(250.dp)
        )
    }
}