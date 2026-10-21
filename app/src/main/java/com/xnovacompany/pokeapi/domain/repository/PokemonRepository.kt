package com.xnovacompany.pokeapi.domain.repository

import com.xnovacompany.pokeapi.domain.model.PokemonResponse

interface PokemonRepository {
    suspend fun fetchPokemon(name: String): Result<PokemonResponse>
}