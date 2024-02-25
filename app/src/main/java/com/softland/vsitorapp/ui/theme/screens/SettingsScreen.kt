package com.softland.vsitorapp.ui.theme.screens



import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.softland.vsitorapp.ui.theme.Utilss.FileUtils


@Composable
fun SettingsScreen(onNavigateToHome: NavHostController) {
  Column(modifier = Modifier.padding(10.dp)) {
      Row(
          modifier = Modifier.fillMaxWidth().padding(start = 5.dp, end = 5.dp),
          horizontalArrangement = Arrangement.SpaceBetween
      ) {
          Text(text = "Mac ID :",
              color = Color.Black,
              fontSize = 20.sp,
              fontWeight = FontWeight.Bold)
          Spacer(modifier = Modifier.width(8.dp)) // Add some space between the Text elements
          FileUtils.get_android_id(LocalContext.current)?.let { Text(text = it, color = Color.Black,
              fontWeight = FontWeight.Bold,
              fontSize = 20.sp,) }
      }
  }

}