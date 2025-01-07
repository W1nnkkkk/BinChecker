package com.w1nkkkk.binchecker.presentation.components

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.w1nkkkk.binchecker.presentation.navigation.Route

@Composable
fun BottomBinAppBar(navController: NavController) {
    val isDarkTheme = isSystemInDarkTheme()
    val context = LocalContext.current
    val listItems = listOf(
        Route.Main,
        Route.History
    )

    NavigationBar(
        modifier = Modifier.background(Color.Gray)
    ) {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination?.route
        listItems.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = { navController.navigate(item.route) },
                icon = {
                    Icon(
                        painter = painterResource(id = item.iconId),
                        contentDescription = context.getString(item.title),
                        tint = if (currentRoute == item.route) MaterialTheme.colorScheme.primary
                        else if (isDarkTheme) Color.White
                        else Color.Black
                    )
                },
                label = {
                    Text(
                        text = context.getString(item.title),
                        color = if (currentRoute == item.route) MaterialTheme.colorScheme.primary
                        else if (isDarkTheme) Color.White
                        else Color.Black,
                        fontSize = 10.sp
                    )
                }
            )
        }
    }
}