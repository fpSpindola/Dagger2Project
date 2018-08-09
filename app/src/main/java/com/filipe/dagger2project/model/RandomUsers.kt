package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class RandomUsers (

    @SerializedName("results")
    @Expose
    var results: List<Result>,

    @SerializedName("info")
    @Expose
    var info: Info) {

    override fun toString(): String {
        return ToStringBuilder(this).append("results", results)
                .append("info", info)
                .toString()
    }
}