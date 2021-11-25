package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.model.Pokemon
import com.example.pokedex.network.PokemonAPI
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private var pokemonRetornado: Pokemon? =null
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btPesquisar.setOnClickListener {
            consultarPokemon(binding.busca.text.toString())
        }

        Glide.with(getApplicationContext()).load("https://media3.giphy.com/media/gHc8UzazY7b0hPfZLJ/giphy.gif")
            .into(binding.imagemPokemon)
    }

    fun consultarPokemon(pokemon:String){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                pokemonRetornado = PokemonAPI.retrofitService.getPokemon(pokemon)
            }catch (e:Exception){
                e.printStackTrace()
            }
            withContext(Dispatchers.Main){
                Log.i("teste-consulta-pokemon",pokemonRetornado.toString())
                atualizarTela(pokemonRetornado!!)
            }
        }
    }

    fun atualizarTela(pokemon:Pokemon){
        binding.inputId.text = pokemon.id.toString()
        binding.inputName.text  =pokemon.name
        Picasso.get().load(pokemon.getImagem()).into(binding.imagemPokemon)
    }

}

