package com.softland.vsitorapp.ui.theme.screens

import android.content.Context
import android.content.SharedPreferences
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Password
import androidx.compose.material.icons.filled.Person3
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.softland.vsitorapp.R
import com.softland.vsitorapp.ui.theme.Utilss.ConnectionState
import com.softland.vsitorapp.ui.theme.Utilss.ConstantsValue
import com.softland.vsitorapp.ui.theme.Utilss.connectivityState
import com.softland.vsitorapp.ui.theme.screens.Cust0mView.Screenes
import com.softland.vsitorapp.ui.theme.screens.Cust0mView.TextView
import com.softland.vsitorapp.viewmodel.AccessFlowNetWorkViewmodel
import kotlinx.coroutines.ExperimentalCoroutinesApi


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
fun LoginScreen(navController: NavHostController,viewModel: AccessFlowNetWorkViewmodel = hiltViewModel() ) {
    val context = LocalContext.current
    val state by connectivityState()
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    var tabIndex by remember { mutableIntStateOf(0) }
    if (sharedPreferences.getBoolean("UserLogin",false)){
        navController.navigate(Screenes.homeScreen.route)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFC53333))
    ) {
        Row(
            modifier = Modifier
                .defaultMinSize()
                .fillMaxHeight(.10f)
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = painterResource(id = R.drawable.union),
                contentDescription = "splash",
                modifier = Modifier
                    .size(25.dp)

            )
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Access Flow", modifier = Modifier
                    .padding(bottom = 3.dp)
                    .defaultMinSize(), color = Color.White,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            verticalArrangement = Arrangement.Top,
        ) {
            Row(modifier = Modifier.defaultMinSize()) {
                val tabData = listOf(
                    "Login",
                    "Sign Up",
                )
                TabRow(
                    selectedTabIndex = tabIndex,
                    modifier = Modifier.defaultMinSize(),
                    containerColor = Color.White,

                    ) {
                    tabData.forEachIndexed { index, text ->
                        Tab(selected = tabIndex == index, onClick = {
                            tabIndex = index
                        }, text = {
                            Text(text = text)
                        },
                            selectedContentColor =  Color(0xFFC53333),
                            unselectedContentColor = Color.Black
                        )
                    }
                }
            }
            if (tabIndex == 0) {
                LoginContent(navController,viewModel,state,sharedPreferences)
            } else {
                SignupIndex()
            }
        }
    }
}

@Composable
fun SignupIndex() {

}

@Composable
fun LoginContent(
    onNavigateToHome: NavHostController,
    viewModel: AccessFlowNetWorkViewmodel,
    state: ConnectionState,
    sharedPreferences: SharedPreferences
) {
    val context = LocalContext.current
    val email = remember { mutableStateOf(TextFieldValue()) }
    val password = remember { mutableStateOf(TextFieldValue()) }
    val emptyEmailError = remember { mutableStateOf(false) }
    val emptyPasswordError = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally,
    ) {
        Spacer(Modifier.size(8.dp))
        Text(
            text = "Welcome Back!",
            modifier = Modifier.fillMaxWidth(),
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(3.dp))
        Text(
            text = "Enter your credentials to continue",
            modifier = Modifier.fillMaxWidth(),
            color = Color.Gray,
            textAlign = TextAlign.Center, style = MaterialTheme.typography.titleMedium
        )
        Spacer(Modifier.size(10.dp))
        OutlinedTextField(
            value = email.value,
            onValueChange = {
                if (emptyEmailError.value) {
                    emptyEmailError.value = false
                }
                email.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            label = {
                Text(text = "Email")
            },
            isError = emptyEmailError.value,
            leadingIcon = {
                Icon(
                    modifier = Modifier.align(alignment = Alignment.Start ),
                    imageVector =  Icons.Default.Person3 ,
                    contentDescription = "password"
                )
            },

            )
        if (emptyEmailError.value) {
            run {
                Toast.makeText(context, "Email is Required!", Toast.LENGTH_LONG).show()
            }
        }

        val passwordVisibility = remember { mutableStateOf(true) }

        OutlinedTextField(
            value = password.value,
            onValueChange = {
                if (emptyPasswordError.value) {
                    emptyPasswordError.value = false
                }
                password.value = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                Icon(
                    modifier = Modifier.align(alignment = Alignment.Start ),
                    imageVector =  Icons.Default.Password ,
                    contentDescription = "password"
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility.value = !passwordVisibility.value
                }) {
                    Icon(
                        imageVector = if (passwordVisibility.value) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                        contentDescription = "visibility"
                    )
                }
            },
            visualTransformation = if (passwordVisibility.value) PasswordVisualTransformation() else VisualTransformation.None,
        )
        if (emptyPasswordError.value) {
            run {
                Toast.makeText(context, "Password is required!", Toast.LENGTH_LONG).show()
            }
        }

        Spacer(Modifier.size(15.dp))

        Button(
            onClick = {


                when {
                    email.value.text.isEmpty() -> {
                        emptyEmailError.value = true
                    }

                    password.value.text.isEmpty() -> {
                        emptyPasswordError.value = true
                    }

                    else -> {
                        if (state==ConnectionState.Available){
                            viewModel.collectEntryPersonsData(ConstantsValue.BASE_URL)
                            if (sharedPreferences.getBoolean("UserLogin",false)){
                                onNavigateToHome.popBackStack()
                                onNavigateToHome.navigate(Screenes.homeScreen.route)
                            }
                            Toast.makeText(context,"Api no work!Api Domain is not hosted publicly",Toast.LENGTH_SHORT).show()
                            sharedPreferences.edit().putBoolean("UserLogin",true).apply()
                            onNavigateToHome.popBackStack()
                            onNavigateToHome.navigate(Screenes.homeScreen.route)

                        }else{
                            Toast.makeText(context,"No Internet!",Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            },
            content = {
                Text(text = "Log In", color = Color.White)
            },
            modifier = Modifier
                .defaultMinSize()
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            colors = ButtonDefaults.buttonColors( Color(0xFFC53333))
        )

        Spacer(Modifier.size(4.dp))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Divider(
                Modifier.fillMaxWidth(0.45f),
                color = androidx.compose.ui.graphics.Color.Gray,
                thickness = 1.dp
            )
            Spacer(Modifier.size(8.dp))
            Text(
                text = "OR",
                color = Color.Gray,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.size(8.dp))
            Divider(
                Modifier.fillMaxWidth(),
                color = androidx.compose.ui.graphics.Color.Gray,
                thickness = 1.dp
            )
        }
        Text(
            text = "Forget your login details? Please Contact with Admin!",
            color = Color.Gray,
            modifier = Modifier,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(Modifier.size(24.dp))
            Column(verticalArrangement = Arrangement.Bottom) {
                TextView("MacID:00000000000",
                    Modifier
                        .align(alignment = Alignment.CenterHorizontally)
                        .fillMaxWidth(),TextAlign.Center,MaterialTheme.typography.bodyMedium,Color.Black)
                TextView(
                    stringResource(R.string.version),
                    Modifier.align(alignment = Alignment.CenterHorizontally),
                    TextAlign.Center,
                    MaterialTheme.typography.bodyMedium,
                    Color.Black
                )

            }

    }

}
