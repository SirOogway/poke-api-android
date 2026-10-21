package com.xnovacompany.pokeapi.data.repository

import com.xnovacompany.pokeapi.domain.model.PokemonResponse
import com.xnovacompany.pokeapi.data.network.RetrofitClient
import com.xnovacompany.pokeapi.domain.repository.PokemonRepository

class PokemonRepositoryImpl() : PokemonRepository{
    private val api = RetrofitClient.instance

    override suspend fun fetchPokemon(name:String): Result<PokemonResponse> {
        return try {
            val response = api.getPokemonInfo(name.lowercase())
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
