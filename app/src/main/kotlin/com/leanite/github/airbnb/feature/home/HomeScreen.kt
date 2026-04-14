package com.leanite.github.airbnb.feature.home

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.leanite.github.airbnb.ui.component.BottomNavigationBar
import com.leanite.github.airbnb.ui.component.ContentShadow
import com.leanite.github.airbnb.ui.component.SearchBar
import com.leanite.github.airbnb.ui.component.SearchPlaceBanner
import com.leanite.github.airbnb.ui.component.TabBarShadow
import com.leanite.github.airbnb.ui.item.PlaceItem
import com.leanite.github.airbnb.ui.section.HeaderSection
import com.leanite.github.airbnb.ui.section.LastSeenSection
import com.leanite.github.airbnb.ui.section.RecommendationSection
import com.leanite.github.airbnb.ui.section.TabSection
import com.leanite.github.airbnb.ui.theme.GradientBackgroundLightGray
import androidx.compose.ui.tooling.preview.Preview
import com.leanite.github.airbnb.data.mock.allAccommodations
import com.leanite.github.airbnb.data.mock.allPlaces
import com.leanite.github.airbnb.data.mock.neighborhoodAccommodations
import com.leanite.github.airbnb.data.mock.rioTrip
import kotlinx.collections.immutable.toImmutableList

@Composable
fun HomeScreen(
    uiState: HomeUiState,
    onAction: (HomeAction) -> Unit,
) {
    val listState = rememberLazyListState()

    val collapseThresholdPx = with(LocalDensity.current) { 60.dp.toPx() }
    val collapseProgress by rememberCollapseProgress(listState, collapseThresholdPx)

    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            BottomNavigationBar(
                items = uiState.bottomNavItems.toImmutableList(),
                selectedIndex = uiState.selectedBottomNavIndex,
                onItemSelected = { onAction(HomeAction.BottomNavSelected(it)) },
            )
        },
    ) { innerPaddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colorStops = arrayOf(
                            0.00f to GradientBackgroundLightGray,
                            0.30f to Color.White
                        )
                    )
                )
                .padding(top = innerPaddings.calculateTopPadding())
        ) {
            SearchBar(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 12.dp)
            )
            TabBarShadow(
                tabBar = {
                    TabSection(
                        tabs = uiState.tabs.toImmutableList(),
                        selectedIndex = uiState.selectedTabIndex,
                        onTabSelected = { index ->
                            onAction(HomeAction.TabSelected(index))
                        },
                        collapseProgress = collapseProgress,
                        modifier = Modifier.padding(top = 16.dp)
                    )
                },
                shadowHeight = 4.dp,
                shadowAlpha = 0.08f
            )
            LazyColumn(
                state = listState,
                contentPadding = PaddingValues(top = 16.dp),
            ) {
                if (uiState.currentTrip != null) {
                    item {
                        ContentShadow(
                            modifier = Modifier.padding(6.dp),
                            content = {
                                SearchPlaceBanner(
                                    trip = uiState.currentTrip,
                                    accommodations = uiState.accommodations.toImmutableList(),
                                )
                            },
                            shadowPadding = PaddingValues(8.dp)
                        )
                    }
                }
                item {
                    Spacer(Modifier.height(22.dp))
                    HeaderSection(
                        title = "Vistos recentemente",
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                }
                item {
                    LastSeenSection(
                        accommodations = uiState.neighborhoodAccommodations.toImmutableList(),
                        onAccommodationClick = { onAction(HomeAction.AccommodationClicked(it)) },
                        modifier = Modifier.padding(vertical = 12.dp),
                    )
                }
                item {
                    HeaderSection(
                        title = "Acomodações em Rio de Janeiro com cancelamento gratuito",
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 16.dp)
                    )
                }
                item {
                    RecommendationSection(
                        accommodations = uiState.accommodations.toImmutableList(),
                        onAccommodationClick = { onAction(HomeAction.AccommodationClicked(it)) },
                        modifier = Modifier.padding(vertical = 16.dp),
                    )
                }
                item {
                    HeaderSection(
                        title = "Visite outros lugares",
                        modifier = Modifier.padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 16.dp)
                    )
                }
                items(uiState.places) { place ->
                    PlaceItem(
                        place = place,
                        modifier = Modifier.padding(horizontal = 24.dp)
                    )
                    Spacer(Modifier.height(16.dp))
                }
            }
        }
    }
}

@Composable
fun rememberCollapseProgress(listState: LazyListState, collapseThresholdPx: Float): State<Float> {
    val rawProgress by remember {
        derivedStateOf {
            if (listState.firstVisibleItemIndex > 0) 1f
            else (listState.firstVisibleItemScrollOffset / collapseThresholdPx).coerceIn(0f, 1f)
        }
    }

    val isScrolling = listState.isScrollInProgress

    var snapTarget by remember { mutableFloatStateOf(0f) }

    LaunchedEffect(isScrolling) {
        if (!isScrolling) {
            snapTarget = if (rawProgress > 0.5f) 1f else 0f
        }
    }

    val animatedProgress by animateFloatAsState(
        targetValue = if (isScrolling) rawProgress else snapTarget,
        animationSpec = tween(200, easing = FastOutSlowInEasing),
        label = "collapseProgress"
    )

    return rememberUpdatedState(animatedProgress)
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        uiState = HomeUiState(
            accommodations = allAccommodations,
            neighborhoodAccommodations = neighborhoodAccommodations,
            places = allPlaces,
            currentTrip = rioTrip,
        ),
        onAction = {},
    )
}
