package br.org.fundatec.heroesapp.character.presentation.model

enum class TipoPersonagem {

    HERO, VILLAIN;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> HERO.name
                2 -> VILLAIN.name
                else -> throw IllegalArgumentException("Posição inválida")
            }
        }
    }

}