package br.com.fundatec.heroesapp.home.domain

import java.io.Serializable

data class CharacterModel(
    val id: Int,
    val name: String,
    val image: String,
    val description: String,
    val date: String,
    val age: Int,
) : Serializable