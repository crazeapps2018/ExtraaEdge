package com.meprogrammer.extraaedge.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum

@Dao
interface RocketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)  // or OnConflictStrategy.IGNORE
    suspend fun saveRockets(rockets :  List<RocketsListDatum>)

    @Query("SELECT * FROM rocketslistdatum")
    suspend fun getRockets(): List<RocketsListDatum>

    @Query("SELECT * FROM rocketslistdatum WHERE id=:id")
    suspend fun getRocketDetail(id: String): RocketsListDatum


}