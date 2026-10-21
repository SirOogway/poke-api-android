package com.xnovacompany.pokeapi.data.network

import com.xnovacompany.pokeapi.domain.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface PokeApiService {
    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(@Path("name") name: String): PokemonResponse
}