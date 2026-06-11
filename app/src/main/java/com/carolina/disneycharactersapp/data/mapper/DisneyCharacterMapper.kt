package com.carolina.disneycharacters.data.mapper

import com.carolina.disneycharacters.data.remote.DisneyCharacterDto
import com.carolina.disneycharacters.domain.model.DisneyCharacter

fun DisneyCharacterDto.toDomain(): DisneyCharacter {
    return DisneyCharacter(
        id = _id,
        name = name,
        imageUrl = imageUrl,
        isFavorite = false
    )
}