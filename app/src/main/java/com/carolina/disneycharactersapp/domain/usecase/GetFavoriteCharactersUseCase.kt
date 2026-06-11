package com.carolina.disneycharacters.domain.usecase

import com.carolina.disneycharacters.domain.repository.DisneyCharactersRepository
import javax.inject.Inject

class GetFavoriteCharactersUseCase @Inject constructor(
    private val repository: DisneyCharactersRepository
) {
    operator fun invoke() = repository.getFavoriteCharacters()
}