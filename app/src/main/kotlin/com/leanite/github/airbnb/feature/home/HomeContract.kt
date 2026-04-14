package com.leanite.github.airbnb.feature.home

import androidx.compose.runtime.Immutable
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.domain.model.Place
import com.leanite.github.airbnb.domain.model.Trip
import com.leanite.github.airbnb.ui.model.BottomNavItem
import com.leanite.github.airbnb.ui.model.Tab
import com.leanite.github.airbnb.ui.model.allBottomNavItems

@Immutable
data class HomeUiState(
    val contentState: HomeContentState = HomeContentState.Idle,
    val selectedTabIndex: Int = 0,
    val tabs: List<Tab> = listOf(Tab.Houses, Tab.Experiences, Tab.Services),
    val selectedBottomNavIndex: Int = 0,
    val bottomNavItems: List<BottomNavItem> = allBottomNavItems,
    val accommodations: List<Accommodation> = emptyList(),
    val neighborhoodAccommodations: List<Accommodation> = emptyList(),
    val places: List<Place> = emptyList(),
    val currentTrip: Trip? = null,
)

@Immutable
enum class HomeContentState {
    Idle, Loading, Success, Error
}

@Immutable
sealed interface HomeAction {
    data object Load : HomeAction
    data class TabSelected(val index: Int) : HomeAction
    data class AccommodationClicked(val accommodation: Accommodation) : HomeAction
    data class BottomNavSelected(val index: Int) : HomeAction
}

@Immutable
sealed interface HomeEvent {
    data class NavigateToDetail(val accommodation: Accommodation) : HomeEvent
}
