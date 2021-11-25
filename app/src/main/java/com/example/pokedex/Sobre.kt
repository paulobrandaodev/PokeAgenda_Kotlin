package com.example.pokedex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.pokedex.databinding.ActivitySobreBinding

class Sobre : AppCompatActivity() {

    private lateinit var binding: ActivitySobreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySobreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Glide.with(getApplicationContext()).load("https://alanmorel.pythonanywhere.com/static/images/logo.png")
            .into(binding.logoApp)
    }
}