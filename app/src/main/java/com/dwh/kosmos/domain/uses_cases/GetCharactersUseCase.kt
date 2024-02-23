package com.dwh.kosmos.domain.uses_cases

import com.dwh.kosmos.domain.model.ApiResModel
import com.dwh.kosmos.domain.repository.CharactersRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(
    private val charactersRepository: CharactersRepository
) {
    suspend operator fun invoke(): Flow<ApiResModel?> {
        return charactersRepository.getCharacters()
    }
}