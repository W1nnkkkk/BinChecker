package com.w1nkkkk.binchecker.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.w1nkkkk.binchecker.R
import com.w1nkkkk.binchecker.domain.BinModel
import com.w1nkkkk.binchecker.domain.HistoryModel
import com.w1nkkkk.binchecker.presentation.components.ErrorDialog
import com.w1nkkkk.binchecker.presentation.screens.HistoryScreen
import com.w1nkkkk.binchecker.presentation.screens.MainScreen
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel
import com.w1nkkkk.binchecker.presentation.viewmodels.HistoryViewModel

@Composable
fun SetupNavGraph(navHostController: NavHostController, binViewModel: BinViewModel, historyViewModel: HistoryViewModel) {
    var bin by remember {
        mutableStateOf(BinModel())
    }
    var showDialog by remember {
        mutableStateOf(false)
    }
    var dialogText by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

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
            is BinViewModel.State.Success -> {
                bin = it.bin
                historyViewModel.insertBin(HistoryModel(
                    binNum = it.binNum,
                    binInfo = it.bin
                ))
            }
        }
    }

    NavHost(navController = navHostController, startDestination = Route.Main.route) {
        composable(Route.Main.route) {
            MainScreen(binModel = bin, binViewModel = binViewModel)
        }

        composable(Route.History.route) {
            HistoryScreen(historyViewModel)
        }

    }
}