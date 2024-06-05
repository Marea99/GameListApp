package com.example.gamelistapp.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gamelistapp.model.SingleGameModel
import com.example.gamelistapp.repository.GameRepository
import com.example.gamelistapp.state.GameAppState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class GamesViewModel @Inject constructor(private  val repository: GameRepository): ViewModel() {
    private val _allGames = MutableStateFlow<List<SingleGameModel>>(emptyList())
    val allGames = _allGames.asStateFlow()
    var gameState by mutableStateOf(GameAppState())
        private set

    fun getAllGames() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list = repository.getAllGames()
                _allGames.value = list!!
            }
        }
    }

    fun getGame(id: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list = repository.getGame(id)
                gameState = gameState.copy(
                    name = list?.name ?: "",
                    description_raw = list?.description_raw ?: "",
                    metacritic = list?.metacritic ?: 0,
                    released = list?.released ?: "",
                    background_image = list?.background_image ?: "",
                    website = list?.website ?: ""
                )
            }
        }
    }

    fun getGameByName(name: String){
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list = repository.getGameByName(name)
                gameState = gameState.copy(
                    name = list?.name ?: "",
                    description_raw = list?.description_raw ?: "",
                    metacritic = list?.metacritic ?: 0,
                    released = list?.released ?: "",
                    background_image = list?.background_image ?: "",
                    website = list?.website ?: ""
                )
            }
        }
    }
}