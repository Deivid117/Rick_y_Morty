package com.dwh.kosmos.presentation.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.dwh.kosmos.R
import com.dwh.kosmos.domain.model.CharactersResModel

@Composable
fun CharacterDetails(
    character: CharactersResModel
) {
    Column() {
        CustomDetailsText(title = stringResource(R.string.character_status), description = character.status ?: "N/A")

        CustomDetailsText(title = stringResource(R.string.character_species), description =  character.species ?: "N/A" )

        CustomDetailsText(title = stringResource(R.string.character_type), description = if(character.type?.isNotEmpty() == true) character.type ?: "N/A" else "N/A")

        CustomDetailsText(title = stringResource(R.string.character_gender), description =character.gender ?: "N/A")

        CustomDetailsText(title = stringResource(R.string.character_origin), description = character.origin?.name ?: "N/A")

        CustomDetailsText(title = stringResource(R.string.character_location), description = character.location?.name ?: "N/A")
    }
}

