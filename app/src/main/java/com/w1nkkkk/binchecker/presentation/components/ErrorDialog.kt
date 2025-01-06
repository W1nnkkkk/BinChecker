package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.sp

@Composable
fun ErrorDialog(message: String, title: String, onClickOk : () -> Unit, onDismiss : () -> Unit) {
    AlertDialog(
        onDismissRequest = { onClickOk() },
        title = { Text(title) },
        text = { Text(message) },
        confirmButton = {
            Button({ onClickOk() }) {
                Text("OK", fontSize = 22.sp)
            }
        }
    )
}