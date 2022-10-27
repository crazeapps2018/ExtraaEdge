package com.meprogrammer.extraaedge.di

import android.content.Context
import androidx.room.Room
import com.meprogrammer.extraaedge.db.RocketDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun provideRocketDB(@ApplicationContext context:Context) : RocketDB {
        return Room.databaseBuilder(context, RocketDB::class.java,"RocketDB").build()
    }


}