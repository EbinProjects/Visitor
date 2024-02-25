package com.softland.vsitorapp.ui.theme.screens

import ExitedCardView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.softland.vsitorapp.R
import enterdListData


@Composable
fun RegularScreen(onNavigateToHome: NavHostController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.LightGray)) {
        LazyColumn {
            items(regularlist.alignYourBodyData.sortedBy { it.Name.toString() }) {
                ExitedCardView(i = it)
            }
        }
    }
}

object regularlist {
    val alignYourBodyData = listOf(
        enterdListData(R.drawable.u, "Nooru", "Bank Manager","22:22:22"),
        enterdListData(R.drawable.c, "Appukkuttan","JCB Operator", "22:22:11"),
        enterdListData(R.drawable.d, "Karuppayya", "Cutting Professional","22:22:11"),
        enterdListData(R.drawable.m, "MJ Soman", "Yoga Master","22:22:11"),
        enterdListData(R.drawable.n, "Valsan K.T","football coach", "22:22:11"),
        enterdListData(R.drawable.q, "Deepu Vishwanath", "Panchayath member","22:22:11")
    )
}