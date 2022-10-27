package com.meprogrammer.extraaedge.models.rocketsList

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import javax.annotation.Nonnull

@Entity
class RocketsListDatum {

    @SerializedName("height")
    @Expose
    var height: Height? = null

    @SerializedName("diameter")
    @Expose
    var diameter: Diameter? = null

    @SerializedName("mass")
    @Expose
    var mass: Mass? = null

    @SerializedName("first_stage")
    @Expose
    var firstStage: FirstStage? = null

    @SerializedName("second_stage")
    @Expose
    var secondStage: SecondStage? = null

    @SerializedName("engines")
    @Expose
    var engines: Engines? = null

    @SerializedName("landing_legs")
    @Expose
    var landingLegs: LandingLegs? = null

    @SerializedName("payload_weights")
    @Expose
    var payloadWeights: List<PayloadWeight>? = null

    @SerializedName("flickr_images")
    @Expose
    var flickrImages: List<String>? = null

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("type")
    @Expose
    var type: String? = null

    @SerializedName("active")
    @Expose
    var active: Boolean? = null

    @SerializedName("stages")
    @Expose
    var stages: Int? = null

    @SerializedName("boosters")
    @Expose
    var boosters: Int? = null

    @SerializedName("cost_per_launch")
    @Expose
    var costPerLaunch: Int? = null

    @SerializedName("success_rate_pct")
    @Expose
    var successRatePct: Int? = null

    @SerializedName("first_flight")
    @Expose
    var firstFlight: String? = null

    @SerializedName("country")
    @Expose
    var country: String? = null

    @SerializedName("company")
    @Expose
    var company: String? = null

    @SerializedName("wikipedia")
    @Expose
    var wikipedia: String? = null

    @SerializedName("description")
    @Expose
    var description: String? = null

    @PrimaryKey
    @SerializedName("id")
    @Expose
    @Nonnull
    var id: String = ""

    inner class Mass {
        @SerializedName("kg")
        @Expose
        var kg: Int? = null

        @SerializedName("lb")
        @Expose
        var lb: Int? = null
    }

    inner class Height {
        @SerializedName("meters")
        @Expose
        var meters: Double? = null

        @SerializedName("feet")
        @Expose
        var feet: Double? = null
    }

    inner class Diameter {
        @SerializedName("meters")
        @Expose
        var meters: Double? = null

        @SerializedName("feet")
        @Expose
        var feet: Double? = null

    }

    inner class Engines {
        @SerializedName("isp")
        @Expose
        var isp: Isp? = null

        @SerializedName("thrust_sea_level")
        @Expose
        var thrustSeaLevel: ThrustSeaLevel__1? = null

        @SerializedName("thrust_vacuum")
        @Expose
        var thrustVacuum: ThrustVacuum__1? = null

        @SerializedName("number")
        @Expose
        var number: Int? = null

        @SerializedName("type")
        @Expose
        var type: String? = null

        @SerializedName("version")
        @Expose
        var version: String? = null

        @SerializedName("layout")
        @Expose
        var layout: Any? = null

        @SerializedName("engine_loss_max")
        @Expose
        var engineLossMax: Any? = null

        @SerializedName("propellant_1")
        @Expose
        var propellant1: String? = null

        @SerializedName("propellant_2")
        @Expose
        var propellant2: String? = null

        @SerializedName("thrust_to_weight")
        @Expose
        var thrustToWeight: Double? = null
    }


    inner class FirstStage {
        @SerializedName("thrust_sea_level")
        @Expose
        var thrustSeaLevel: ThrustSeaLevel? = null

        @SerializedName("thrust_vacuum")
        @Expose
        var thrustVacuum: ThrustVacuum? = null

        @SerializedName("reusable")
        @Expose
        var reusable: Boolean? = null

        @SerializedName("engines")
        @Expose
        var engines: Int? = null

        @SerializedName("fuel_amount_tons")
        @Expose
        var fuelAmountTons: Double? = null

        @SerializedName("burn_time_sec")
        @Expose
        var burnTimeSec: Any? = null
    }

    inner class LandingLegs {

        @SerializedName("number")
        @Expose
        var number: Int? = null

        @SerializedName("material")
        @Expose
        var material: String? = null

    }

    inner class PayloadWeight {


        @SerializedName("id")
        @Expose
        var id: String? = null

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("kg")
        @Expose
        var kg: Int? = null

        @SerializedName("lb")
        @Expose
        var lb: Int? = null
    }

    inner class SecondStage {
        @SerializedName("thrust")
        @Expose
        var thrust: Thrust? = null

        @SerializedName("payloads")
        @Expose
        var payloads: Payloads? = null

        @SerializedName("reusable")
        @Expose
        var reusable: Boolean? = null

        @SerializedName("engines")
        @Expose
        var engines: Int? = null

        @SerializedName("fuel_amount_tons")
        @Expose
        var fuelAmountTons: Double? = null

        @SerializedName("burn_time_sec")
        @Expose
        var burnTimeSec: Any? = null

    }

    inner class Isp {
        @SerializedName("sea_level")
        @Expose
        var seaLevel: Int? = null

        @SerializedName("vacuum")
        @Expose
        var vacuum: Int? = null
    }

    inner class Payloads {
        @SerializedName("composite_fairing")
        @Expose
        var compositeFairing: CompositeFairing? = null

        @SerializedName("option_1")
        @Expose
        var option1: String? = null
    }

    inner class CompositeFairing {

        @SerializedName("height")
        @Expose
        var height: Height__1? = null

        @SerializedName("diameter")
        @Expose
        var diameter: Diameter__1? = null

    }

    inner class Height__1 {
        @SerializedName("meters")
        @Expose
        var meters: Any? = null

        @SerializedName("feet")
        @Expose
        var feet: Any? = null
    }

    inner class Diameter__1 {
        @SerializedName("meters")
        @Expose
        var meters: Any? = null

        @SerializedName("feet")
        @Expose
        var feet: Any? = null
    }

    inner class Thrust {

        @SerializedName("kN")
        @Expose
        var kN: Int? = null

        @SerializedName("lbf")
        @Expose
        var lbf: Int? = null

    }

    inner class ThrustSeaLevel {
        @SerializedName("kN")
        @Expose
        var kN: Int? = null

        @SerializedName("lbf")
        @Expose
        var lbf: Int? = null
    }

    inner class ThrustSeaLevel__1 {
        @SerializedName("kN")
        @Expose
        var kN: Int? = null

        @SerializedName("lbf")
        @Expose
        var lbf: Int? = null

    }

    inner class ThrustVacuum {
        @SerializedName("kN")
        @Expose
        var kN: Int? = null

        @SerializedName("lbf")
        @Expose
        var lbf: Int? = null
    }

    inner class ThrustVacuum__1 {
        @SerializedName("kN")
        @Expose
        var kN: Int? = null

        @SerializedName("lbf")
        @Expose
        var lbf: Int? = null
    }


}