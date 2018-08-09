package com.filipe.dagger2project.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.apache.commons.lang3.builder.ToStringBuilder

data class Result (

    @SerializedName("gender")
    @Expose
    val gender: String,

    @SerializedName("name")
    @Expose
    val name: Name,

    @SerializedName("location")
    @Expose
    val location: Location,

    @SerializedName("email")
    @Expose
    val email: String,

    @SerializedName("login")
    @Expose
    val login: Login,

    @SerializedName("dob")
    @Expose
    val dob: String,

    @SerializedName("registered")
    @Expose
    val registered: String,

    @SerializedName("phone")
    @Expose
    val phone: String,

    @SerializedName("cell")
    @Expose
    val cell: String,

    @SerializedName("id")
    @Expose
    val id: Id,

    @SerializedName("picture")
    @Expose
    val picture: Picture,

    @SerializedName("nat")
    @Expose
    val nat: String) {

    override fun toString(): String {
        return ToStringBuilder(this).append("gender", gender)
                .append("name", name)
                .append("location", location)
                .append("email", email)
                .append("login", login)
                .append("dob", dob)
                .append("registered", registered)
                .append("phone", phone)
                .append("cell", cell)
                .append("id", id)
                .append("picture", picture)
                .append("nat", nat)
                .toString()
    }
}