package com.dwh.kosmos.presentation.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dwh.kosmos.R

@Preview(showBackground = true)
@Composable
fun CustomButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    showDetails: Boolean = false,
) {
    val textStyle = MaterialTheme.typography.labelMedium
    val roundedCornerShape = RoundedCornerShape(10.dp)

    Button(
        modifier = modifier.padding(0.dp),
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),
        border = BorderStroke(2.dp, Color.White),
        shape = roundedCornerShape,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 13.dp,
            pressedElevation = 8.dp
        )
    ) {
        Text(
            text = if (!showDetails) stringResource(R.string.btn_see_details) else stringResource(R.string.btn_hide_details),
            style = textStyle,
            textAlign = TextAlign.Center
        )
    }
}