package com.leanite.github.airbnb.feature.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailHost(
    viewModel: DetailViewModel = hiltViewModel(),
    onNavigateBack: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    DetailInputEffects(onAction = viewModel::onAction)

    DetailEventEffects(
        events = viewModel.events,
        onNavigateBack = onNavigateBack,
    )

    DetailScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
    )
}
