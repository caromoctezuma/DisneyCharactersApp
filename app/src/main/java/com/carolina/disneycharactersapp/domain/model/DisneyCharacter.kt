package com.carolina.disneycharacters.domain.model

data class DisneyCharacter(
    val id: Int,
    val name: String,
    val imageUrl: String?,
    val isFavorite: Boolean = false
)