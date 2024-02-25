package com.softland.vsitorapp.ui.theme

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.softland.vsitorapp.ui.theme.screens.Cust0mView.Screenes
import com.softland.vsitorapp.ui.theme.screens.HomeScreen
import com.softland.vsitorapp.ui.theme.screens.LoginScreen
import com.softland.vsitorapp.ui.theme.ui.theme.VSITORAPPTheme
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
@AndroidEntryPoint
class SecondMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VSITORAPPTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    MyAppNavHost(navController = navController)
                }
            }
        }
    }

}


@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = "login"
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = Screenes.loginScreen.route
    ) {
        composable(route = Screenes.loginScreen.route) {
            LoginScreen (navController = navController)
        }
        composable(route= Screenes.homeScreen.route) {
            HomeScreen()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    VSITORAPPTheme {

    }
}