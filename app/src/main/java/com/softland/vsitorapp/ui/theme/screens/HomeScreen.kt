package com.softland.vsitorapp.ui.theme.screens

import AddVisitor
import DepartMentDetails
import DetailsEntry
import GetFiledtetails
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ContactPhone
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.NotificationsActive
import androidx.compose.material.icons.filled.People
import androidx.compose.material.icons.filled.RemoveCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ContactPhone
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.People
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.softland.vsitorapp.R
import com.softland.vsitorapp.ui.theme.DataModel.BottomNavigationModel
import com.softland.vsitorapp.ui.theme.screens.Cust0mView.Screenes
import com.softland.vsitorapp.ui.theme.screens.widgets_view.CardWithIcon

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")


@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    var expandSearch by remember { mutableStateOf(true) }
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val bottomLists = listOf(
        BottomNavigationModel(
            title = "Home",
            selectedIcons = Icons.Filled.Home,
            unselectedIcons = Icons.Outlined.Home
        ), BottomNavigationModel(
            title = "PreVisit",
            selectedIcons = Icons.Filled.ContactPhone,
            unselectedIcons = Icons.Outlined.ContactPhone
        ),
        BottomNavigationModel(
            title = "Regular",
            selectedIcons = Icons.Filled.People,
            unselectedIcons = Icons.Outlined.People
        ),
        BottomNavigationModel(
            title = "Settings",
            selectedIcons = Icons.Filled.Settings,
            unselectedIcons = Icons.Outlined.Settings
        )
    )
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.onTertiary
    ) {
        Scaffold(bottomBar = {
            NavigationBar {

                bottomLists.forEachIndexed { index, bottomNavigationModel ->
                    NavigationBarItem(selected = currentRoute == bottomNavigationModel.title,
                        onClick = {
                            expandSearch = bottomNavigationModel.title != "Settings"
                            selectedIndex = index
                            navController.popBackStack()
                            navController.navigate(bottomNavigationModel.title)


                        }, label = {
                               Text(text =bottomNavigationModel.title)
                    }
                        , icon = {
                        Icon(
                            imageVector = if(selectedIndex==index) bottomNavigationModel.selectedIcons else bottomNavigationModel.unselectedIcons,
                            contentDescription = bottomNavigationModel.title
                        )
                    })
                }
            }
        },
            topBar = {
                ExpandableSearchView(expandSearch)

            },
          floatingActionButton = {
             if (expandSearch) FloatingActionButton(modifier = Modifier
                  .size(50.dp),onClick = {
                  expandSearch=false
                  navController.navigate(Screenes.addVisitor.route)
              },
                  shape = CircleShape,
                  containerColor = Color(0xFFC53333) ) {
                    FlottingButton( )
              }
          },
            floatingActionButtonPosition = FabPosition.End,

        ){
            NavHost(
                modifier = Modifier.padding(it),
                navController = navController,
                startDestination = Screenes.home.route
            ) {
                composable(route= Screenes.home.route) {
                    Home(/*onNavigateToHome = navControlle*/)
                }
                composable(route= Screenes.preVisitScreen.route) {
                    PreVisitScreen(onNavigateToHome = navController)
                }
                composable(route= Screenes.regularScreen.route) {
                    RegularScreen(onNavigateToHome = navController)
                }
                composable(route= Screenes.settingsScreen.route) {
                    SettingsScreen(onNavigateToHome = navController)
                }
                composable(route= Screenes.addVisitor.route) {
                    AddVisitor(onNavigateToHome = navController)
                }
                composable(route= Screenes.departments.route) {
                   DepartMentDetails(onNavigateToHome = navController)
                }
                composable(route= Screenes.details.route) {
                    DetailsEntry(onNavigateToHome = navController)
                }
                composable(route= Screenes.filedetails.route) {
                    GetFiledtetails(onNavigateToHome = navController)
                }
            }

        }

    }
}



@Composable
fun FlottingButton() {
    Card(modifier = Modifier.clip(CircleShape),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Icon(modifier = Modifier
            .size(50.dp)
            .background(Color(0xFFC53333)),
            imageVector = Icons.Filled.Add,
            tint = Color.White,
            contentDescription = "splash")
    }
}

@Composable
fun ExpandableSearchView(expandSearch: Boolean) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .defaultMinSize(),
        shape = RoundedCornerShape(bottomEnd = 10.dp, bottomStart = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor =   Color(0xFFC53333)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Spacer(modifier = Modifier.padding(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize()
                .padding(8.dp)
        ) {
            Card(modifier = Modifier
                .defaultMinSize()
                .defaultMinSize(),
                shape = RoundedCornerShape(50.dp),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 10.dp
                )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.user),
                    contentDescription = "splash",
                    modifier = Modifier.size(40.dp))
            }

            Spacer(modifier = Modifier.padding(5.dp))
            Column() {
                Text(
                    text = "Access Flow", modifier = Modifier
                        .padding(bottom = 3.dp)
                        .defaultMinSize(), color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Normal,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "Abbbbbbbbbbbbbbb", modifier = Modifier
                        .padding(bottom = 3.dp)
                        .defaultMinSize(), color = Color.White,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Italic,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.bodyMedium
                )

            }
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(end = 5.dp), Alignment.CenterEnd) {
                CardWithIcon(vectorResource = Icons.Filled.NotificationsActive)

            }

        }
        Spacer(modifier = Modifier.padding(5.dp))
        if (expandSearch)SearchExpandableView()
        Spacer(modifier = Modifier.padding(10.dp))

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchExpandableView() {
    var searchText by remember { mutableStateOf("") }
    Box(modifier = Modifier.fillMaxWidth(), Alignment.Center) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(Color(0XFF101921))
        ) {
            val containerColor = MaterialTheme.colorScheme.onTertiary
            TextField(modifier = Modifier.fillMaxWidth(),
                value = searchText,
                onValueChange ={searchText=it} ,
                leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "", tint =  Color(0xFFC53333)) },
                trailingIcon = {
                    if (searchText.isNotEmpty()) {
                        Icon(imageVector = Icons.Default.RemoveCircle, contentDescription = "",tint =  Color(0xFFC53333),modifier = Modifier
                            .padding(end = 5.dp)
                            .offset(x = 10.dp)
                            .clickable {
                                searchText = ""
                            })
                        }
                },
                colors = TextFieldDefaults.colors(
                    disabledTextColor = Color.Transparent,
                    focusedContainerColor = containerColor,
                    unfocusedContainerColor = containerColor,
                    disabledContainerColor = containerColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    focusedLabelColor = Color.Black,
                ),
                placeholder = { Text(text = "Search...") }
            )
        }

    }

}
