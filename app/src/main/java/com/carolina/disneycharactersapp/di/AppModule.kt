package com.carolina.disneycharacters.di

import android.content.Context
import androidx.room.Room
import com.carolina.disneycharacters.data.local.DisneyCharactersDatabase
import com.carolina.disneycharacters.data.local.FavoriteCharacterDao
import com.carolina.disneycharacters.data.remote.DisneyApiService
import com.carolina.disneycharacters.data.repository.DisneyCharactersRepositoryImpl
import com.carolina.disneycharacters.domain.repository.DisneyCharactersRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDisneyCharactersRepository(
        impl: DisneyCharactersRepositoryImpl
    ): DisneyCharactersRepository
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://api.disneyapi.dev/"

    @Provides
    @Singleton
    fun provideDisneyApiService(): DisneyApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DisneyApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): DisneyCharactersDatabase {
        return Room.databaseBuilder(
            context,
            DisneyCharactersDatabase::class.java,
            "disney_characters_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFavoriteCharacterDao(
        database: DisneyCharactersDatabase
    ): FavoriteCharacterDao {
        return database.favoriteCharacterDao()
    }
}