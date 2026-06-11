package com.carolina.disneycharacters.presentation.home

import com.carolina.disneycharacters.domain.model.DisneyCharacter

data class HomeUiState(
    val isLoading: Boolean = false,
    val characters: List<DisneyCharacter> = emptyList(),
    val errorMessage: String? = null
)