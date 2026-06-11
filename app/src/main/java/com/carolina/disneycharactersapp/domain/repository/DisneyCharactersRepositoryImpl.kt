package com.carolina.disneycharacters.data.repository

import com.carolina.disneycharacters.data.local.FavoriteCharacterDao
import com.carolina.disneycharacters.data.mapper.toDomain
import com.carolina.disneycharacters.data.mapper.toEntity
import com.carolina.disneycharacters.data.remote.DisneyApiService
import com.carolina.disneycharacters.domain.model.DisneyCharacter
import com.carolina.disneycharacters.domain.repository.DisneyCharactersRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DisneyCharactersRepositoryImpl @Inject constructor(
    private val apiService: DisneyApiService,
    private val favoriteCharacterDao: FavoriteCharacterDao
) : DisneyCharactersRepository {

    override fun getCharacters(): Flow<List<DisneyCharacter>> = flow {
        val favoriteIds = favoriteCharacterDao.getFavoriteCharacterIdsOnce()

        val characters = apiService.getCharacters()
            .data
            .map { characterDto ->
                val character = characterDto.toDomain()

                character.copy(
                    isFavorite = favoriteIds.contains(character.id)
                )
            }

        emit(characters)
    }

    override fun getFavoriteCharacters(): Flow<List<DisneyCharacter>> {
        return favoriteCharacterDao.getFavoriteCharacters().map { favorites ->
            favorites.map { it.toDomain() }
        }
    }

    override suspend fun addFavorite(character: DisneyCharacter) {
        if (character.isFavorite) {
            favoriteCharacterDao.deleteFavoriteCharacter(character.toEntity())
        } else {
            favoriteCharacterDao.saveFavoriteCharacter(character.toEntity())
        }
    }
}