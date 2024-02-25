package com.softland.vsitorapp.ui.theme.screens.Cust0mView

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign

@Composable
fun TextView(
    s: String,
    centerHorizontally: Modifier,
    align: TextAlign,
    textsStyle: TextStyle,
    coloring: Color
) {
    Text(
        text = s,
        color = coloring,
        modifier =  centerHorizontally,
        textAlign = align,
        style = textsStyle,
        )
}