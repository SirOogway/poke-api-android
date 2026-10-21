package com.xnovacompany.pokeapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.xnovacompany.pokeapi.presentation.pokemon.PokemonScreen
import com.xnovacompany.pokeapi.presentation.pokemon.PokemonViewModel
import com.xnovacompany.pokeapi.ui.theme.PokeApiTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<PokemonViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PokeApiTheme {
                PokemonScreen(
                    modifier = Modifier.padding(top = 20.dp),
                    pokemonName = viewModel.pokemonName,
                    uiState = viewModel.uiState,
                    onNameChange = { viewModel.onNameChange(it) },
                    onSearchClick = { viewModel.searchPokemon() }
                )
                /*Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
        }
    }
}