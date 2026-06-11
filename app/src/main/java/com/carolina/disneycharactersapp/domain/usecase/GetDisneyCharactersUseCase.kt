package com.carolina.disneycharacters.domain.usecase

import com.carolina.disneycharacters.domain.repository.DisneyCharactersRepository
import javax.inject.Inject

class GetDisneyCharactersUseCase @Inject constructor(
    private val repository: DisneyCharactersRepository
) {
    operator fun invoke() = repository.getCharacters()
}