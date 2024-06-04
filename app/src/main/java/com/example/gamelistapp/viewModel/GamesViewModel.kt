package com.example.gamelistapp.viewModel

import androidx.lifecycle.ViewModel
import com.example.gamelistapp.repository.GameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(
    private val gameRepository: GameRepository): ViewModel() {

}