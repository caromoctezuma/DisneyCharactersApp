package com.carolina.disneycharacters.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carolina.disneycharacters.domain.model.DisneyCharacter
import com.carolina.disneycharacters.domain.usecase.GetDisneyCharactersUseCase
import com.carolina.disneycharacters.domain.usecase.AddFavoriteCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getDisneyCharactersUseCase: GetDisneyCharactersUseCase,
    private val addFavoriteCharacterUseCase: AddFavoriteCharacterUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState(isLoading = true))
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        getCharacters()
    }

    private fun getCharacters() {
        viewModelScope.launch {
            getDisneyCharactersUseCase()
                .onStart {
                    _uiState.value = HomeUiState(isLoading = true)
                }
                .catch {
                    _uiState.value = HomeUiState(
                        isLoading = false,
                        errorMessage = "No se pudieron cargar los datos"
                    )
                }
                .collect { characters ->
                    _uiState.value = HomeUiState(
                        isLoading = false,
                        characters = characters
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