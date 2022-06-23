package com.codebaron.netflixclone.di

import com.codebaron.netflixclone.provider.EndPointsProvider
import com.codebaron.netflixclone.repository.RequestRepositories
import com.codebaron.netflixclone.repository.RequestRepositoriesImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RequestModule {

    @Provides
    @Singleton
    fun providerNewsRepository(provider: EndPointsProvider): RequestRepositories =
        RequestRepositoriesImplementation(provider)
}