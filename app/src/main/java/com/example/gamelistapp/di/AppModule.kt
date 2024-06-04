package com.example.gamelistapp.di

import com.example.gamelistapp.data.ApiGames
import com.example.gamelistapp.repository.GameRepository
import com.example.gamelistapp.viewModel.GamesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideAPI(): ApiGames {
        return ApiGames()
    }

    @Singleton
    @Provides
    fun provideRepository(apiGames: ApiGames): GameRepository {
        return GameRepository(apiGames)
    }

    @Singleton
    @Provides
    fun provideViewModel(gameRepository: GameRepository): GamesViewModel {
        return GamesViewModel(gameRepository)
    }


    /*Esto es solo por si acaso necesitamos inyectar dependencias más tarde:

    @Singleton
    @Provides
    fun provideNavManager(): NavManager {
        return NavManager()
    }

    @Singleton
    @Provides
    fun provideAppState(): AppState {
        return AppState()
    }*/

}