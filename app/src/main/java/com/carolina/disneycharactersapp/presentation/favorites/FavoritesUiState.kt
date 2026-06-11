package com.carolina.disneycharacters.presentation.favorites

import com.carolina.disneycharacters.domain.model.DisneyCharacter

data class FavoritesUiState(
    val favoriteCharacters: List<DisneyCharacter> = emptyList()
)