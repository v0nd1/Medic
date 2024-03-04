package com.huggydugy.medic.di

import android.app.Application
import com.huggydugy.medic.data.manger.LocalUserMangerImpl
import com.huggydugy.medic.domain.manger.LocalUserManger
import com.huggydugy.medic.domain.usecases.AppEntryUseCases
import com.huggydugy.medic.domain.usecases.ReadAppEntry
import com.huggydugy.medic.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

}