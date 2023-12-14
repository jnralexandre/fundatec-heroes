package br.org.fundatec.heroesapp.character.presentation.model

enum class TipoEmpresa {

    MARVEL, DC;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> MARVEL.name
                2 -> DC.name
                else -> throw IllegalArgumentException("Posição inválida")
            }
        }
    }
}