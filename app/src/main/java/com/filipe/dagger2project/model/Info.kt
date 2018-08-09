package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

class Info(
        @SerializedName("seed")
        @Expose
        var seed: String,

        @SerializedName("results")
        @Expose
        var results: Int,

        @SerializedName("page")
        @Expose
        var page: String,

        @SerializedName("version")
        @Expose
        var version: String) {

    override fun toString(): String {
        return ToStringBuilder(this).append("seed", seed)
                .append("results", results)
                .append("page", page)
                .append("version", version)
                .toString()
    }
}