package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class Id(
        @SerializedName("name")
        @Expose
        var name: String,

        @SerializedName("value")
        @Expose
        var value: String) {
    override fun toString(): String {
        return ToStringBuilder(this).append("name", name)
                .append("value", value)
                .toString()
    }
}