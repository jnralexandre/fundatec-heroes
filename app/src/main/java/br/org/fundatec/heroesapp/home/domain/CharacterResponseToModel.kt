package br.org.fundatec.heroesapp.home.domain

import br.com.fundatec.heroesapp.home.domain.CharacterModel
import br.org.fundatec.heroesapp.character.data.remote.CharacterResponse

fun List<CharacterResponse>.toModel(): List<CharacterModel> {
    return map { character ->
        CharacterModel(
            id = character.id,
            name = character.name,
            image = character.image,
            description = character.description,
            date = character.birthday.orEmpty(),
            age = character.age
        )
    }
}