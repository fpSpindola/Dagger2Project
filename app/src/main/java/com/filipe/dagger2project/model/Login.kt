package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class Login(
        @SerializedName("username")
        @Expose
        var username: String,

        @SerializedName("password")
        @Expose
        var password: String,

        @SerializedName("salt")
        @Expose
        var salt: String,

        @SerializedName("md5")
        @Expose
        var md5: String,

        @SerializedName("sha1")
        @Expose
        var sha1: String,

        @SerializedName("sha256")
        @Expose
        var sha256: String) {

    override fun toString(): String {
        return ToStringBuilder(this).append("username", username)
                .append("password", password)
                .append("salt", salt)
                .append("md5", md5)
                .append("sha1", sha1)
                .append("sha256", sha256)
                .toString()
    }
}