package com.carolina.disneycharacters.data.mapper

import com.carolina.disneycharacters.data.local.FavoriteCharacterEntity
import com.carolina.disneycharacters.domain.model.DisneyCharacter

fun DisneyCharacter.toEntity(): FavoriteCharacterEntity {
    return FavoriteCharacterEntity(
        id = id,
        name = name,
        imageUrl = imageUrl
    )
}

fun FavoriteCharacterEntity.toDomain(): DisneyCharacter {
    return DisneyCharacter(
        id = id,
        name = name,
        imageUrl = imageUrl,
        isFavorite = true
    )
}