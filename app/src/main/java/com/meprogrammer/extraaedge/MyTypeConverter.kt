package com.meprogrammer.extraaedge

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.meprogrammer.extraaedge.models.rocketsList.RocketsListDatum
import java.util.*


class MyTypeConverter {
    var gson = Gson()

    //For Payload list
    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<RocketsListDatum.PayloadWeight?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<RocketsListDatum.PayloadWeight?>?>() {}.type
        return gson.fromJson<List<RocketsListDatum.PayloadWeight?>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<RocketsListDatum.PayloadWeight?>?): String? {
        return gson.toJson(someObjects)
    }

    //For Flicker list
    @TypeConverter
    fun stringToFlickerList(data: String?): List<String?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType = object : TypeToken<List<String>?>() {}.type
        return gson.fromJson<List<String>>(data, listType)
    }

    @TypeConverter
    fun flickerListToString(someObjects: List<String>?): String? {
        return gson.toJson(someObjects)
    }

    //For Height
    @TypeConverter
    fun heightToString(app: RocketsListDatum.Height): String = Gson().toJson(app)

    @TypeConverter
    fun stringToHeight(string: String): RocketsListDatum.Height = Gson().fromJson(string, RocketsListDatum.Height::class.java)

    //For diameter
    @TypeConverter
    fun diameterToString(app: RocketsListDatum.Diameter): String = Gson().toJson(app)

    @TypeConverter
    fun stringTodiameter(string: String): RocketsListDatum.Diameter = Gson().fromJson(string, RocketsListDatum.Diameter::class.java)

    //For Mass
    @TypeConverter
    fun massToString(app: RocketsListDatum.Mass): String = Gson().toJson(app)

    @TypeConverter
    fun stringToMass(string: String): RocketsListDatum.Mass = Gson().fromJson(string, RocketsListDatum.Mass::class.java)

    //For FirstStage
    @TypeConverter
    fun firstStorageToString(app: RocketsListDatum.FirstStage): String = Gson().toJson(app)

    @TypeConverter
    fun stringToFirstStorage(string: String): RocketsListDatum.FirstStage = Gson().fromJson(string, RocketsListDatum.FirstStage::class.java)

    //For SecondStage
    @TypeConverter
    fun secondStorageToString(app: RocketsListDatum.SecondStage): String = Gson().toJson(app)

    @TypeConverter
    fun stringToFirstStage(string: String): RocketsListDatum.SecondStage = Gson().fromJson(string, RocketsListDatum.SecondStage::class.java)


    //For Engines
    @TypeConverter
    fun enginesToString(app: RocketsListDatum.Engines): String = Gson().toJson(app)

    @TypeConverter
    fun stringToEngines(string: String): RocketsListDatum.Engines = Gson().fromJson(string, RocketsListDatum.Engines::class.java)

    //For landingLegs
    @TypeConverter
    fun landingLegsToString(app: RocketsListDatum.LandingLegs): String = Gson().toJson(app)

    @TypeConverter
    fun stringTolandingLegs(string: String): RocketsListDatum.LandingLegs = Gson().fromJson(string, RocketsListDatum.LandingLegs::class.java)




}