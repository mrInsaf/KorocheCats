package com.example.korochecats.ui.viewModel

import com.example.korochecats.data.model.CatImageResponse

data class CatsUiState(
    var catImageList: List<CatImageResponse> = emptyList()
)
