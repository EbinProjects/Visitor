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
fun PreVisitScreen(onNavigateToHome: NavHostController) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.LightGray)) {
        LazyColumn {
            items(previsitlist.alignYourBodyData.sortedBy { it.Name.toString() }) {
                ExitedCardView(i = it)
            }
        }
    }
}

object previsitlist {
    val alignYourBodyData = listOf(
        enterdListData(R.drawable.u, "Thommichan", "Bank Manager","22:22:22"),
        enterdListData(R.drawable.c, "Kadyadi Thambi","JCB Operator", "22:22:11"),
        enterdListData(R.drawable.d, "Kadayadi Baby", "Cutting Professional","22:22:11"),
        enterdListData(R.drawable.m, "Fukru Bahi", "Yoga Master","22:22:11"),
        enterdListData(R.drawable.n, "Pappachan","football coach", "22:22:11"),
        enterdListData(R.drawable.q, "Kunne Owthakutty", "Panchayath member","22:22:11")
    )
}