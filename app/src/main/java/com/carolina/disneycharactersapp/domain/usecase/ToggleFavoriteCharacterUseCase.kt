package com.carolina.disneycharacters.domain.usecase

import com.carolina.disneycharacters.domain.model.DisneyCharacter
import com.carolina.disneycharacters.domain.repository.DisneyCharactersRepository
import javax.inject.Inject

class AddFavoriteCharacterUseCase @Inject constructor(
    private val repository: DisneyCharactersRepository
) {
    suspend operator fun invoke(character: DisneyCharacter) {
        repository.addFavorite(character)
    }
}