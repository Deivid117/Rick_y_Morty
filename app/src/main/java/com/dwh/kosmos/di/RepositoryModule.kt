package com.dwh.kosmos.di

import com.dwh.kosmos.data.repository.CharactersRepositoryImp
import com.dwh.kosmos.domain.repository.CharactersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsCharactersRepository(charactersRepositoryImp: CharactersRepositoryImp): CharactersRepository

}