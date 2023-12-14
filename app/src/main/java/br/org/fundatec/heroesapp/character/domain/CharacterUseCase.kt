package br.org.fundatec.heroesapp.character.domain

import br.org.fundatec.heroesapp.character.data.remote.CharacterResponse
import br.org.fundatec.heroesapp.character.data.repository.CharacterRepository
import java.time.LocalDateTime

class CharacterUseCase {

    private val repository by lazy {
        CharacterRepository()
    }

    suspend fun createCharacter(
        name:String,
        description: String,
        age: Int,
        birthday: LocalDateTime?,
        tipoEmpresa: String,
        tipoPersonagem: String,
        image: String
    ): Boolean {
        return repository.createCharacter(
            name = name,
            description = description,
            age = age,
            birthday = birthday,
            tipoEmpresa = tipoEmpresa,
            tipoPersonagem = tipoPersonagem,
            image = image,
        )
    }

    suspend fun listCharacter(): List<CharacterResponse> {
        return repository.listCharacter();
    }

}