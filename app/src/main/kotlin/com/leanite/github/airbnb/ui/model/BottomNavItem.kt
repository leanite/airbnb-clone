package com.leanite.github.airbnb.ui.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.leanite.github.airbnb.R

sealed class BottomNavItem(
    val id: Int,
    val iconRes: Int,
    val iconSelectedRes: Int,
    val label: String,
) {
    data object Explore : BottomNavItem(
        id = 0,
        iconRes = R.drawable.icon_bottom_search, iconSelectedRes = R.drawable.icon_bottom_search_fill,
        label = "Explorar"
    )
    data object Favorites : BottomNavItem(
        id = 1,
        iconRes = R.drawable.icon_bottom_heart, iconSelectedRes = R.drawable.icon_bottom_heart_fill,
        label = "Favoritos"
    )
    data object Trips : BottomNavItem(
        id = 2,
        iconRes = R.drawable.icon_bottom_airb, iconSelectedRes = R.drawable.icon_bottom_airb_fill,
        label = "Viagens"
    )
    data object Messages : BottomNavItem(
        id = 3,
        iconRes = R.drawable.icon_bottom_message, iconSelectedRes = R.drawable.icon_bottom_message_fill,
        label = "Mensagens"
    )
    data object Profile : BottomNavItem(
        id = 4,
        iconRes = R.drawable.icon_bottom_profile, iconSelectedRes = R.drawable.icon_bottom_profile_fill,
        label = "Perfil"
    )
}

val allBottomNavItems = listOf(
    BottomNavItem.Explore,
    BottomNavItem.Favorites,
    BottomNavItem.Trips,
    BottomNavItem.Messages,
    BottomNavItem.Profile,
)
