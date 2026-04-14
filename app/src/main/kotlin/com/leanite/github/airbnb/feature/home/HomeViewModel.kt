package com.leanite.github.airbnb.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leanite.github.airbnb.core.result.AppResult
import com.leanite.github.airbnb.domain.model.Accommodation
import com.leanite.github.airbnb.domain.usecase.GetHomeDataUseCase
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
class HomeViewModel @Inject constructor(
    private val getHomeDataUseCase: GetHomeDataUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _events = Channel<HomeEvent>(Channel.BUFFERED)
    val events: Flow<HomeEvent> = _events.receiveAsFlow()

    fun onAction(action: HomeAction) {
        when (action) {
            HomeAction.Load -> loadData()
            is HomeAction.TabSelected -> onTabSelected(action.index)
            is HomeAction.AccommodationClicked -> onAccommodationClicked(action.accommodation)
            is HomeAction.BottomNavSelected -> onBottomNavSelected(action.index)
        }
    }

    private fun loadData() {
        val state = _uiState.value.contentState
        if (state == HomeContentState.Loading || state == HomeContentState.Success) return

        viewModelScope.launch {
            _uiState.update { it.copy(contentState = HomeContentState.Loading) }

            when (val result = getHomeDataUseCase()) {
                is AppResult.Success -> _uiState.update {
                    it.copy(
                        contentState = HomeContentState.Success,
                        accommodations = result.data.accommodations,
                        neighborhoodAccommodations = result.data.neighborhoodAccommodations,
                        places = result.data.places,
                        currentTrip = result.data.currentTrip,
                    )
                }
                is AppResult.Error -> _uiState.update {
                    it.copy(contentState = HomeContentState.Error)
                }
            }
        }
    }

    private fun onBottomNavSelected(index: Int) {
        _uiState.update { it.copy(selectedBottomNavIndex = index) }
    }

    private fun onTabSelected(index: Int) {
        _uiState.update { it.copy(selectedTabIndex = index) }
    }

    private fun onAccommodationClicked(accommodation: Accommodation) {
        viewModelScope.launch {
            _events.send(HomeEvent.NavigateToDetail(accommodation))
        }
    }
}
