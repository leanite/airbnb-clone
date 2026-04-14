package com.leanite.github.airbnb.feature.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import com.leanite.github.airbnb.core.result.AppResult
import com.leanite.github.airbnb.domain.usecase.GetAccommodationByIdUseCase
import com.leanite.github.airbnb.navigation.DetailRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getAccommodationByIdUseCase: GetAccommodationByIdUseCase,
) : ViewModel() {

    private val route = savedStateHandle.toRoute<DetailRoute>()

    private val _uiState = MutableStateFlow(
        DetailUiState(
            id = route.id,
            imageRes = route.imageRes,
        )
    )
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    private val _events = Channel<DetailEvent>(Channel.BUFFERED)
    val events: Flow<DetailEvent> = _events.receiveAsFlow()

    fun onAction(action: DetailAction) {
        when (action) {
            DetailAction.Load -> loadAccommodation()
            DetailAction.BackClicked -> onBackClicked()
        }
    }

    private fun loadAccommodation() {
        viewModelScope.launch {
            val result = getAccommodationByIdUseCase(route.id)
            if (result is AppResult.Success) {
                _uiState.update { it.copy(accommodation = result.data) }
            }
        }
    }

    private fun onBackClicked() {
        viewModelScope.launch {
            _events.send(DetailEvent.NavigateBack)
        }
    }
}
