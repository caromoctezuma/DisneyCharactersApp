package com.carolina.disneycharacters.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolina.disneycharacters.domain.model.DisneyCharacter
import com.carolina.disneycharacters.domain.usecase.GetFavoriteCharactersUseCase
import com.carolina.disneycharacters.domain.usecase.AddFavoriteCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val getFavoriteCharactersUseCase: GetFavoriteCharactersUseCase,
    private val addFavoriteCharacterUseCase: AddFavoriteCharacterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(FavoritesUiState())
    val uiState: StateFlow<FavoritesUiState> = _uiState

    init {
        getFavorites()
    }

    private fun getFavorites() {
        viewModelScope.launch {
            getFavoriteCharactersUseCase().collect { favorites ->
                _uiState.value = FavoritesUiState(
                    favoriteCharacters = favorites
                )
            }
        }
    }

    fun onFavoriteClick(character: DisneyCharacter) {
        viewModelScope.launch {
            addFavoriteCharacterUseCase(character)
        }
    }
}