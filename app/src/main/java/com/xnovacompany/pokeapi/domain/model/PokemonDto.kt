package com.xnovacompany.pokeapi.domain.model

data class PokemonResponse(
    val id: Int,
    val name: String,
    val sprites: PokemonSprites?
)

data class PokemonSprites(
    val front_default: String?
)