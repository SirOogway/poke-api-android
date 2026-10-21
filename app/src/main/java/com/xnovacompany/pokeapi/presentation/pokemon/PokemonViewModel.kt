package com.xnovacompany.pokeapi.presentation.pokemon

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnovacompany.pokeapi.data.repository.PokemonRepositoryImpl
import kotlinx.coroutines.launch

class PokemonViewModel: ViewModel() {
    private val repository = PokemonRepositoryImpl()

    var uiState by mutableStateOf<PokemonUiState>(PokemonUiState.Idle)
        private set

    var pokemonName by mutableStateOf("")

    fun onNameChange(newName: String) {
        pokemonName = newName
    }

    fun searchPokemon() {
        if (pokemonName.isBlank()) return

        uiState = PokemonUiState.Loading

        viewModelScope.launch {
            repository.fetchPokemon(pokemonName).fold(
                onSuccess = { pokemonData ->
                    uiState = PokemonUiState.Success(pokemonData)
                },
                onFailure = {
                    uiState = PokemonUiState.Error("No se encontró el Pokémon")
                }
            )
        }
    }
}