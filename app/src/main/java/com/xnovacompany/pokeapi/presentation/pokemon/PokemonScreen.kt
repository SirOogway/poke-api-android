package com.xnovacompany.pokeapi.presentation.pokemon

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.xnovacompany.pokeapi.domain.model.PokemonResponse

@Composable
fun PokemonScreen(
    pokemonName: String,
    uiState: PokemonUiState,
    onNameChange: (String) -> Unit,
    onSearchClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = pokemonName,
            onValueChange = onNameChange,
            label = { Text("Nombre del Pokémon") },
            placeholder = { Text("Ditto...") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = onSearchClick,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Buscar")
        }

        Spacer(modifier = Modifier.height(20.dp))

        when (uiState) {
            is PokemonUiState.Loading -> CircularProgressIndicator()
            is PokemonUiState.Success -> PokemonDetailCard(uiState.pokemon)
            is PokemonUiState.Idle -> Text("Escribe un nombre para empezar")
            is PokemonUiState.Error -> Text(uiState.message, color = Color.Red)
        }
    }
}

@Composable
fun PokemonDetailCard(pokemon: PokemonResponse) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = pokemon.sprites?.front_default,
                contentDescription = "Imagen de ${pokemon.name}",
                modifier = Modifier.size(150.dp)
            )
            Text(
                text = "ID: #${pokemon.id}",
                style = MaterialTheme.typography.labelMedium
            )
            Text(
                text = pokemon.name.uppercase(),
                style = MaterialTheme.typography.headlineMedium
            )
        }
    }
}