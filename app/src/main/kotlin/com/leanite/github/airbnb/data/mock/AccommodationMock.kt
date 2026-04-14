package com.leanite.github.airbnb.data.mock

import com.leanite.github.airbnb.R
import com.leanite.github.airbnb.domain.model.Accommodation

val allAccommodations = listOf(
    Accommodation(id = 1, type = "Apartamento", place = "Leblon", price = 3000, beds = 2, rating = 4.95,
        imageRes = R.drawable.apartment_leblon, shortDescription = "Apartamento de alto padrão no Leblon",
        isSuperHost = true, neighborhood = "Rio de Janeiro, Brasil", hostName = "Carlos", hostMonths = 12, reviews = 45, guests = 4, rooms = 2, bathrooms = 1),
    Accommodation(id = 2, type = "Apartamento", place = "Copacabana", price = 2500, beds = 4, rating = 5.0,
        imageRes = R.drawable.apartment_copacabana,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Amelia", hostMonths = 3, reviews = 25, guests = 2, rooms = 1, bathrooms = 1),
    Accommodation(id = 3, type = "Casa", place = "Lapa", price = 1800, beds = 1, rating = 4.68,
        imageRes = R.drawable.apartment_lapa,
        isSuperHost = true, neighborhood = "Rio de Janeiro, Brasil", hostName = "Roberto", hostMonths = 24, reviews = 78, guests = 3, rooms = 1, bathrooms = 1),
    Accommodation(id = 4, type = "Apartamento", place = "Barra da Tijuca", price = 2200, beds = 3, rating = 4.79,
        imageRes = R.drawable.apartment_barra,
        isSuperHost = true, neighborhood = "Rio de Janeiro, Brasil", hostName = "Fernanda", hostMonths = 8, reviews = 32, guests = 6, rooms = 3, bathrooms = 2),
    Accommodation(id = 5, type = "Casa", place = "Maracanã", price = 1650, beds = 3, rating = 4.98,
        imageRes = R.drawable.apartment_maracana,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Lucas", hostMonths = 6, reviews = 15, guests = 4, rooms = 2, bathrooms = 1),
)

val neighborhoodAccommodations = listOf(
    Accommodation(id = 11, type = "Apartamento", place = "Leblon", price = 3000, beds = 2, rating = 4.95,
        imageRes = R.drawable.subplace_leblon, shortDescription = "Apartamento de alto padrão no Leblon", isSuperHost = true,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Ana", hostMonths = 5, reviews = 20, guests = 3, rooms = 1, bathrooms = 1),
    Accommodation(id = 21, type = "Apartamento", place = "Copacabana", price = 2500, beds = 4, rating = 5.0,
        imageRes = R.drawable.subplace_copacabana,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Pedro", hostMonths = 18, reviews = 60, guests = 4, rooms = 2, bathrooms = 1),
    Accommodation(id = 31, type = "Casa", place = "Botafogo", price = 1800, beds = 1, rating = 4.88,
        imageRes = R.drawable.subplace_botafogo,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Julia", hostMonths = 10, reviews = 35, guests = 2, rooms = 1, bathrooms = 1),
    Accommodation(id = 41, type = "Apartamento", place = "Barra da Tijuca", price = 2200, beds = 3, rating = 4.79,
        imageRes = R.drawable.subplace_barra,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Marcos", hostMonths = 14, reviews = 42, guests = 5, rooms = 2, bathrooms = 2),
    Accommodation(id = 51, type = "Casa", place = "Maracanã", price = 1650, beds = 3, rating = 4.98,
        imageRes = R.drawable.subplace_maracana,
        neighborhood = "Rio de Janeiro, Brasil", hostName = "Beatriz", hostMonths = 7, reviews = 28, guests = 4, rooms = 2, bathrooms = 1),
)
