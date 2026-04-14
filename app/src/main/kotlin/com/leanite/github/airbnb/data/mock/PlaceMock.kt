package com.leanite.github.airbnb.data.mock

import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.domain.model.Place

val allPlaces = listOf(
    Place(name = "Florianópolis", iconRes = R.drawable.place_florianopolis,
        description = "Os hóspedes interessados em Rio de Janeiro também buscaram este destino"),
    Place(name = "Rio de Janeiro", iconRes = R.drawable.place_rio_de_janeiro,
        description = "Porque sua lista de favoritos tem acomodações em Rio de Janeiro"),
    Place(name = "São Paulo", iconRes = R.drawable.place_sao_paulo,
        description = "Que tal curtir a selva de pedra?"),
    Place(name = "Bahia", iconRes = R.drawable.place_bahia,
        description = "Por atrações como Mercado Modelo"),
    Place(name = "Brasília", iconRes = R.drawable.place_brasilia,
        description = "Destino popular"),
    Place(name = "Recife", iconRes = R.drawable.place_recife,
        description = "Populares entre viajantes perto de você"),
)
