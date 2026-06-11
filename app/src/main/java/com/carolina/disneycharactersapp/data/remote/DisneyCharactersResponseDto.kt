package com.carolina.disneycharacters.data.remote

data class DisneyCharactersResponseDto(
    val data: List<DisneyCharacterDto>
)

data class DisneyCharacterDto(
    val _id: Int,
    val name: String,
    val imageUrl: String?
)