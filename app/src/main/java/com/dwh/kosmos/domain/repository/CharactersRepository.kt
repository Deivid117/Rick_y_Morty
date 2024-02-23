package com.dwh.kosmos.domain.repository

import com.dwh.kosmos.domain.model.ApiResModel
import kotlinx.coroutines.flow.Flow

interface CharactersRepository {

    suspend fun getCharacters(): Flow<ApiResModel?>
}