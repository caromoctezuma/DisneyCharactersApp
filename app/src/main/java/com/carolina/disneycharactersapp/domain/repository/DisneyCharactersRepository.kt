package com.carolina.disneycharacters.domain.repository

import com.carolina.disneycharacters.domain.model.DisneyCharacter
import kotlinx.coroutines.flow.Flow

interface DisneyCharactersRepository {

    fun getCharacters(): Flow<List<DisneyCharacter>>

    fun getFavoriteCharacters(): Flow<List<DisneyCharacter>>

    suspend fun addFavorite(character: DisneyCharacter)
}