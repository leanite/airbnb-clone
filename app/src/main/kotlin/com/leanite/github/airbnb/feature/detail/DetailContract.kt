package com.leanite.github.airbnb.feature.detail

import androidx.compose.runtime.Immutable
import com.leanite.github.airbnb.domain.model.Accommodation

@Immutable
data class DetailUiState(
    val id: Int = 0,
    val imageRes: Int = 0,
    val accommodation: Accommodation? = null,
)

@Immutable
sealed interface DetailAction {
    data object Load : DetailAction
    data object BackClicked : DetailAction
}

@Immutable
sealed interface DetailEvent {
    data object NavigateBack : DetailEvent
}
