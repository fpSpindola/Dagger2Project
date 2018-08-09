package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class Picture(
        @SerializedName("large")
        @Expose
        var large: String,

        @SerializedName("medium")
        @Expose
        var medium: String,

        @SerializedName("thumbnail")
        @Expose
        var thumbnail: String) {

    override fun toString(): String {
        return ToStringBuilder(this).append("large", large)
                .append("medium", medium)
                .append("thumbnail", thumbnail)
                .toString()
    }
}