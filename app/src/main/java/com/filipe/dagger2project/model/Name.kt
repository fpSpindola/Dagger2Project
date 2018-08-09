package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class Name(
        @SerializedName("title")
        @Expose
        var title: String,

        @SerializedName("first")
        @Expose
        var first: String,

        @SerializedName("last")
        @Expose
        var last: String) {

    override fun toString(): String {
        return ToStringBuilder(this)
                .append("title", title)
                .append("first", first)
                .append("last", last)
                .toString()
    }
}