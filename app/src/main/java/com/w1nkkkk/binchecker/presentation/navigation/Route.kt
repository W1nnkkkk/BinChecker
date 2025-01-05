package com.w1nkkkk.binchecker.presentation.navigation

import com.w1nkkkk.binchecker.R

sealed class Route(val title: Int, val iconId: Int, val route: String) {
    data object Main : Route(R.string.bin, R.drawable.ic_card, "main")
    data object History : Route(R.string.history, R.drawable.ic_history, "history")
}