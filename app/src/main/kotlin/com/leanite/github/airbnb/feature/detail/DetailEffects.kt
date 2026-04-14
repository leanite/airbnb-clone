package com.leanite.github.airbnb.feature.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailInputEffects(
    onAction: (DetailAction) -> Unit,
) {
    LaunchedEffect(Unit) {
        onAction(DetailAction.Load)
    }
}

@Composable
fun DetailEventEffects(
    events: Flow<DetailEvent>,
    onNavigateBack: () -> Unit,
) {
    LaunchedEffect(events) {
        events.collectLatest { event ->
            when (event) {
                DetailEvent.NavigateBack -> onNavigateBack()
            }
        }
    }
}
