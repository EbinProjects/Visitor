package com.softland.vsitorapp.ui.theme.screens.widgets_view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.softland.vsitorapp.R

/**
 * Created by Prakash on 04/09/23.
 */


@Composable
fun CardWithIcon(vectorResource: ImageVector) {
    Card(
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(
            containerColor = Color(0x75ABD7DF),
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        )
    ) {
        Box(
            modifier = Modifier
                .background(Color.White) // Set your desired background color here
                .padding(8.dp) // Optional: Add padding to the icon if needed
                .clip(RoundedCornerShape(4.dp)), // Apply the shape
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = rememberVectorPainter(
                    image = vectorResource
                ),
                contentDescription = "menu",
                tint = Color.Black // Optional: You can also set a tint color for the icon
            )
        }
    }



}