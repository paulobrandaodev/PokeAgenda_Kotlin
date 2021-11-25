package com.example.pokedex.network

import com.example.pokedex.model.Pokemon
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


private const val BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


interface PokemonService{

    @GET("{pokemon}")
    suspend fun getPokemon(@Path("pokemon") pokemon:String) : Pokemon
}

object  PokemonAPI{
    val retrofitService: PokemonService by lazy {
        retrofit.create(PokemonService::class.java)
    }
}