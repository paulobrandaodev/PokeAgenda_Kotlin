package com.example.pokedex.model

data class Pokemon(var id: Int, var name: String, var order: Int) {

    public fun getImagem(): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/${id}.png"
    }

}