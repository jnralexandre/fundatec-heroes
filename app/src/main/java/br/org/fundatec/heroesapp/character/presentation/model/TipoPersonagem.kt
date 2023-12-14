package br.org.fundatec.heroesapp.character.presentation.model

enum class TipoPersonagem {

    HEROI, VILÃO;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> HEROI.name
                2 -> VILÃO.name
                else -> throw IllegalArgumentException("Posição inválida")
            }
        }
    }

}