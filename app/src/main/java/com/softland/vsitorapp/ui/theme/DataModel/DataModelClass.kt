package com.softland.vsitorapp.ui.theme.DataModel

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationModel(
    val title:String,
    val selectedIcons:ImageVector,
    val unselectedIcons:ImageVector
)