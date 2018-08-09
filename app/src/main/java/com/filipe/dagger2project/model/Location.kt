package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class Location(
        @SerializedName("street")
        @Expose
        var street: String,

        @SerializedName("city")
        @Expose
        var city: String,

        @SerializedName("state")
        @Expose
        var state: String,

        @SerializedName("postcode")
        @Expose
        var postcode: String) {

    override fun toString(): String {
        return ToStringBuilder(this).append("street", street)
                .append("city", city)
                .append("state", state)
                .append("postcode", postcode)
                .toString()
    }
}