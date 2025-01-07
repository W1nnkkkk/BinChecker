package com.w1nkkkk.binchecker.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.w1nkkkk.binchecker.R
import com.w1nkkkk.binchecker.domain.HistoryModel

@Composable
fun HistoryCardTop(historyModel : HistoryModel, expanded : Boolean) {
    val context = LocalContext.current
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(historyModel.binNum.toString(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start,
        )
        if (expanded) {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_up),
                "up")
        } else {
            Icon(
                painter = painterResource(R.drawable.ic_arrow_down),
                "down")
        }
        Spacer(modifier = Modifier.padding(horizontal = 5.dp))
        Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
            Row {
                Text(
                    context.getString(R.string.card_scheme) + ": ${historyModel.binInfo.scheme}",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}