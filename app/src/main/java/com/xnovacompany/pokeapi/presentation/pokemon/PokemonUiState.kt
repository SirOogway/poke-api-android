package com.xnovacompany.pokeapi.presentation.pokemon

import com.xnovacompany.pokeapi.domain.model.PokemonResponse

sealed class PokemonUiState {
    object Idle: PokemonUiState()
    object Loading: PokemonUiState()
    data class Success(val pokemon: PokemonResponse): PokemonUiState()
    data class Error(val message: String): PokemonUiState()
}