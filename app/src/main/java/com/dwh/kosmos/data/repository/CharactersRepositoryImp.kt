package com.dwh.kosmos.data.repository

import android.util.Log
import com.dwh.kosmos.data.api.ApiService
import com.dwh.kosmos.domain.model.ApiResModel
import com.dwh.kosmos.domain.model.toDomain
import com.dwh.kosmos.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class CharactersRepositoryImp @Inject constructor(
    private val apiService: ApiService
): CharactersRepository {

    override suspend fun getCharacters(): Flow<ApiResModel?> {
        val response = apiService.getCharacters(1)

        if(response.isSuccessful) {
            val body = response.body()?.toDomain()
            return flowOf(body)
        } else {
            throw Exception("Ocurrió un error al llamar a la api")
        }
    }

}