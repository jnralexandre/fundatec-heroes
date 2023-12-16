package br.org.fundatec.heroesapp.character.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CharacterRequest (
    val name:String,
    val description: String,
    val age: Int,
    val birthday: String?,
    val image: String,
    val universeType: String,
    val characterType: String

)