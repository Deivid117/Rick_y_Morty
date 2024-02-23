package com.dwh.kosmos.presentation.ui

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.dwh.kosmos.R
import com.dwh.kosmos.domain.model.CharactersResModel
import com.dwh.kosmos.presentation.composables.*
import com.dwh.kosmos.presentation.viewmodel.CharactersViewModel
import com.dwh.kosmos.presentation.viewmodel.UIState

@Composable
fun CharactersScreen(
    navController: NavController,
    viewModel: CharactersViewModel = hiltViewModel()
) {
    LaunchedEffect(viewModel) {
        viewModel.getCharacters()
    }

    CustomScaffold() {
        Surface(
            Modifier
                .fillMaxSize()
                .padding(10.dp)
        ) {
            CharactersValidationResponse(viewModel)
        }
    }
}

@Composable
fun CharactersValidationResponse(viewModel: CharactersViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    when (uiState) {
        is UIState.Error -> {
            val erroMsg = (uiState as UIState.Error).errorMessage
            Log.e("CharactersError", erroMsg)
            EmptyDataMessage(stringResource(R.string.error_msg))
        }
        UIState.Loading -> {
            CustomLoadingScreen()
        }
        is UIState.Success -> {
            val data = (uiState as UIState.Success).data
            CharactersContent(data?.results)
        }
    }
}

@Composable
fun CharactersContent(results: ArrayList<CharactersResModel>?) {
    val characters: ArrayList<CharactersResModel> = results ?: ArrayList()

    if (characters.isNotEmpty()) {
        LazyVerticalGrid(
            modifier = Modifier.fillMaxWidth(),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            items(characters) { character ->
                CharacterItem(character)
            }
        }
    } else {
        EmptyDataMessage(title = stringResource(R.string.empty_data))
    }
}

@Composable
private fun CharacterItem(character: CharactersResModel) {
    var showDetails by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.tertiary),
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = character.name ?: "N/A",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleLarge.copy()
            )

            CustomImage(Modifier.size(90.dp), url = character.image ?: "")

            CustomButton(
                onClick = {
                    showDetails = !showDetails
                },
                showDetails = showDetails
            )

            if (showDetails) {
                CharacterDetails(character)
            }
        }
    }
}
