package com.softland.vsitorapp.ui.theme.screens


import ExitedCardView
import ListCardView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.softland.vsitorapp.R
import enterdListData


@Preview
@Composable
fun Home(/*onNavigateToHome: NavHostController*/) {
   Column(modifier = Modifier) {
       var tabIndex by remember { mutableIntStateOf(0) }

       val tabs = listOf("Entered", "Exited")

       Column(modifier = Modifier.fillMaxWidth()) {
           TabRow(selectedTabIndex = tabIndex) {
               tabs.forEachIndexed { index, title ->
                   Tab(text = { Text(title) },
                       selected = tabIndex == index,
                       onClick = { tabIndex = index },
                       selectedContentColor = MaterialTheme.colorScheme.onSurface,
                       unselectedContentColor = MaterialTheme.colorScheme.onBackground
                   )
               }
           }
           when (tabIndex) {
               0 -> EntertedList(listDataItems.alignYourBodyData)
               1 -> ExitedLists(listDataItems.alignYourBodyData)
           }
       }
   }
}
@Composable
fun EntertedList(enterdListData: List<enterdListData>) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .background(Color.LightGray)) {
        LazyColumn {
            items(enterdListData) {
                ListCardView(i = it)
            }
        }
    }
}
    @Composable
    fun ExitedLists(alignYourExited: List<enterdListData>) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.LightGray)) {
            LazyColumn {
                items(alignYourExited.sortedBy { it.Name.toString() }) {
                    ExitedCardView(i = it)
                }
            }
        }

    }

    object listDataItems {
        val alignYourBodyData = listOf(
            enterdListData(R.drawable.u, "Eagle Vasu", "Bank Manager","22:22:22"),
            enterdListData(R.drawable.c, "Haidharmarakkar","JCB Operator", "22:22:11"),
            enterdListData(R.drawable.d, "Varkkikunju", "Cutting Professional","22:22:11"),
            enterdListData(R.drawable.m, "Johan honai", "Yoga Master","22:22:11"),
            enterdListData(R.drawable.n, "Pappapappappa","football coach", "22:22:11"),
            enterdListData(R.drawable.q, "Manimala Vakkachan", "Panchayath member","22:22:11")
        )
    }


