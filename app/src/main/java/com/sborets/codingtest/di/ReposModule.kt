@file:Suppress("unused")

package com.sborets.codingtest.di

import com.sborets.codingtest.data.StorageRepository
import com.sborets.codingtest.data.StorageRepositoryImpl
import com.sborets.codingtest.network.repo.images.ImagesRepository
import com.sborets.codingtest.network.repo.images.ImagesRepositoryImpl
import com.sborets.codingtest.ui.screens.list.ImageListItem
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ReposModule {
    @Binds
    fun bindsImagesRepo(imagesRepository: ImagesRepositoryImpl): ImagesRepository

    @Binds
    fun bindsImageStorageRepo(storageRepositoryImpl: StorageRepositoryImpl<ImageListItem>): StorageRepository<ImageListItem>

    @Binds
    fun bindsTagsStorageRepo(storageRepositoryImpl: StorageRepositoryImpl<String>): StorageRepository<String>
}