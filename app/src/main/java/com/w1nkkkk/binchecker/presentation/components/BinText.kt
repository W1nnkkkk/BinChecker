package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.w1nkkkk.binchecker.R

@Composable
fun BinText(text: String, modifier: Modifier = Modifier) {
    Text(text = text, textAlign = TextAlign.Center, fontSize = 16.sp, modifier = modifier)
}

@Composable
fun BoldBinText(text: String, modifier: Modifier = Modifier) {
    Text(
        text,
        modifier = modifier,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )
}