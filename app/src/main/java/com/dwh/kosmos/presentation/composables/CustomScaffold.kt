package com.dwh.kosmos.presentation.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dwh.kosmos.R

@Composable
fun CustomScaffold(
    title: String = stringResource(R.string.topbar_title),
    content: @Composable() () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBarComposable(
                title = title,
            )
        },
        content = { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                content()
            }
        }
    )
}