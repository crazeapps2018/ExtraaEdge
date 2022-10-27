package com.meprogrammer.extraaedge.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.meprogrammer.extraaedge.MyTypeConverter
import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum

@Database(entities = [RocketsListDatum::class], version = 1)
@TypeConverters(MyTypeConverter::class)
abstract class RocketDB : RoomDatabase() {

    abstract fun getRocketDao() : RocketDao

}