package com.example.gamelistapp.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
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
    private val _allGames = MutableStateFlow(emptyList<SingleGameModel>().toMutableList())
    //private val _allGames = MutableStateFlow<List<SingleGameModel>>(emptyList<SingleGameModel>())
    val allGames = _allGames.asStateFlow()
    var gameState by mutableStateOf(GameAppState())
        private set

    private val _idGame = MutableStateFlow(0)
    val idGame = _idGame

    fun setIdGame(id: Int) {
        _idGame.value = id
    }

    private var nextPage = ""

    fun getAllGames() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                val list = repository.getAllGames()?.results
                _allGames.value = (list as MutableList<SingleGameModel>?)!!
                //_allGames.value = list!!
                nextPage = repository.getAllGames()?.next.toString()
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

    fun getMoreGames() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                Log.i("NEXT_PAGE", nextPage)
                val list = repository.getNextPage(nextPage)?.results
                Log.i("RESULTS", list.toString())
                list?.forEach {  item ->
                    _allGames.value.add(item)
                }
                //_allGames.value.addAll(list!!)
                //_allGames.value = list!!
                nextPage = repository.getAllGames()?.next.toString()
            }
        }
    }
}