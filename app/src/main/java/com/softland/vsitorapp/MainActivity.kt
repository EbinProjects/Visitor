package com.softland.vsitorapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Layers
import androidx.compose.material.icons.filled.Person3
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.softland.vsitorapp.ui.theme.SecondMainActivity
import com.softland.vsitorapp.ui.theme.ui.theme.VSITORAPPTheme
import com.softland.vsitorapp.viewmodel.AccessFlowNetWorkViewmodel
import dagger.hilt.android.lifecycle.HiltViewModel

import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VSITORAPPTheme {
                Surface(modifier = Modifier.background(color =  Color(0xFFC53333))) {

                }
                SplashScreen()
            }
        }
    }
}
@Preview
@Composable
fun SplashScreen() {
    val context = LocalContext.current
    val alpha = remember {
      Animatable(0f)
    }
    LaunchedEffect(key1 = true){
        alpha.animateTo(1f, animationSpec = tween(2000))
        delay(500)
        val intent = Intent(context, SecondMainActivity::class.java)
        context.startActivity(intent)


    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFC53333)),
        contentAlignment = Alignment.Center){
Column(modifier =  Modifier) {
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .size(35.dp)
                .alpha(alpha.value),
            imageVector =  Icons.Default.Layers ,
            tint = Color.White,
            contentDescription = "splash"
        )
        Spacer(modifier = Modifier.padding(5.dp))
        val visible by remember { mutableStateOf(true) }
        Text(text = "Access Flow",modifier = Modifier
            .padding(bottom = 3.dp)
            .defaultMinSize(), color = Color.White,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.headlineLarge)
    }
    Text(text = "Access Made Simple, Flow Redefined",modifier = Modifier
        .padding(bottom = 3.dp)
        .fillMaxWidth()
        .alpha(alpha.value), color = Color.White,
        fontStyle = FontStyle.Italic,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleSmall)
}

    }
    
}



