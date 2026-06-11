package com.carolina.disneycharacters.data.remote

import retrofit2.http.GET

interface DisneyApiService {

    @GET("character")
    suspend fun getCharacters(): DisneyCharactersResponseDto
}