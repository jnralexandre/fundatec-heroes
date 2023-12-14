package br.org.fundatec.heroesapp.character.data.remote

data class CharacterResponse (
    val id: Int,
    val name:String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: String?
)