package com.carolina.disneycharacters.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteCharacterDao {

    @Query("SELECT * FROM favorite_characters")
    fun getFavoriteCharacters(): Flow<List<FavoriteCharacterEntity>>

    @Query("SELECT id FROM favorite_characters")
    fun getFavoriteCharacterIds(): Flow<List<Int>>

    @Query("SELECT id FROM favorite_characters")
    suspend fun getFavoriteCharacterIdsOnce(): List<Int>

    @Upsert
    suspend fun saveFavoriteCharacter(character: FavoriteCharacterEntity)

    @Delete
    suspend fun deleteFavoriteCharacter(character: FavoriteCharacterEntity)
}