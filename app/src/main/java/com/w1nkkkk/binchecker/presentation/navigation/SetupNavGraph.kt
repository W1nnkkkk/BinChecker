package com.w1nkkkk.binchecker.presentation.navigation

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.w1nkkkk.binchecker.R
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.presentation.components.ErrorDialog
import com.w1nkkkk.binchecker.presentation.screens.MainScreen
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel

@Composable
fun SetupNavGraph(navHostController: NavHostController, binViewModel: BinViewModel, context: Context) {
    var bin by remember {
        mutableStateOf(BinModel())
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    var dialogText by remember {
        mutableStateOf("")
    }

    if (showDialog) {
        val ok = { showDialog = false }
        ErrorDialog(
            dialogText,
            context.getString(R.string.error_dialog_title),
            onClickOk = ok,
            onDismiss = ok
        )
    }

    binViewModel.bin.observe(context as LifecycleOwner) {
        when (it) {
            is BinViewModel.State.Error -> {
                showDialog = true
                dialogText = it.error.localizedMessage ?: ""
            }
            is BinViewModel.State.Success -> { bin = it.bin }
        }
    }

    NavHost(navController = navHostController, startDestination = Route.Main.route) {
        composable(Route.Main.route) {
            MainScreen(binModel = bin, binViewModel = binViewModel)
        }

        composable(Route.History.route) {

        }

    }
}