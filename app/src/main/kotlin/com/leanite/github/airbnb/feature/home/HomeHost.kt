package com.leanite.github.airbnb.feature.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.leanite.github.airbnb.domain.model.Accommodation

@Composable
fun HomeHost(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigateToDetail: (Accommodation) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    HomeInputEffects(onAction = viewModel::onAction)

    HomeEventEffects(
        events = viewModel.events,
        onNavigateToDetail = onNavigateToDetail,
    )

    HomeScreen(
        uiState = uiState,
        onAction = viewModel::onAction,
    )
}
