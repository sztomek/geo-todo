package hu.sztomek.geotodo.domain.mvp.common

sealed class UiState {
    abstract val uiModel: UiModel

    data class IdleUiState(override val uiModel: UiModel): UiState()
    data class LoadingUiState(override val uiModel: UiModel): UiState()
    data class ErrorUiState(override val uiModel: UiModel, val error: UiError): UiState()

}