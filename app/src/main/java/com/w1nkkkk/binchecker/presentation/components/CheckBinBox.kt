package com.w1nkkkk.binchecker.presentation.components

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.w1nkkkk.binchecker.R
import com.w1nkkkk.binchecker.presentation.viewmodels.BinViewModel

const val maxBinLength = 6

@Composable
fun CheckBinBox(binViewModel: BinViewModel) {
    var text by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column {
        OutlinedTextField(
            value = text,
            modifier = Modifier.fillMaxWidth().padding(start = 5.dp, end = 5.dp),
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
            onValueChange = { it ->
                text = it.take(maxBinLength)
            },
            textStyle = TextStyle(textAlign = TextAlign.Center, fontSize = 28.sp),
        )

        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Button(
                onClick = {
                    try {
                        val data = text.toInt()
                        binViewModel.getBin(data)
                        text = ""
                    } catch (ex: Exception) {
                        Toast.makeText(context, ex.localizedMessage, Toast.LENGTH_SHORT).show()
                    }
                },
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(10.dp)
            ) { Text(context.getString(R.string.check_bin_button), fontSize = 28.sp) }
        }
    }
}