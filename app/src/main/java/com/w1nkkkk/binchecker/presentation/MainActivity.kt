package com.w1nkkkk.binchecker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.w1nkkkk.binchecker.domain.ConnectivityReceiver
import com.w1nkkkk.binchecker.presentation.components.BottomBinAppBar
import com.w1nkkkk.binchecker.presentation.navigation.SetupNavGraph
import com.w1nkkkk.binchecker.presentation.theme.BinCheckerTheme
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel
import com.w1nkkkk.binchecker.presentation.viewmodels.HistoryViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var binViewModel: BinViewModel

    @Inject
    lateinit var historyViewModel: HistoryViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ConnectivityReceiver.checkInternetConnection(this@MainActivity)
        setContent {
            BinCheckerTheme {
                val navController = rememberNavController()
                Scaffold(
                    bottomBar = { BottomBinAppBar(navController) }
                ) { containerPadding ->
                    Box(modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = containerPadding.calculateBottomPadding())
                    ) {
                        SetupNavGraph(navController, binViewModel, historyViewModel)
                    }
                }
            }
        }
    }
}

