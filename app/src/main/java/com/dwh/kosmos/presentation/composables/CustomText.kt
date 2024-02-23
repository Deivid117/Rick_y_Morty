package com.dwh.kosmos.presentation.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.sp

@Composable
fun CustomDetailsText(title: String, description: String) {
    Text(
        buildAnnotatedString {
            withStyle(SpanStyle(fontSize = 14.sp, fontWeight = FontWeight.Black)) {
                append(title)
            }
            withStyle(SpanStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal)) {
                append(description)
            }
        }
    )
}
