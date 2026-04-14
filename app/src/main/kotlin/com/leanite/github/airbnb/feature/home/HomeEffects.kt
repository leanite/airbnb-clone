package com.leanite.github.airbnb.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.leanite.github.airbnb.domain.model.Accommodation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun HomeInputEffects(
    onAction: (HomeAction) -> Unit,
) {
    LaunchedEffect(Unit) {
        onAction(HomeAction.Load)
    }
}

@Composable
fun HomeEventEffects(
    events: Flow<HomeEvent>,
    onNavigateToDetail: (Accommodation) -> Unit,
) {
    LaunchedEffect(events) {
        events.collectLatest { event ->
            when (event) {
                is HomeEvent.NavigateToDetail -> onNavigateToDetail(event.accommodation)
            }
        }
    }
}
