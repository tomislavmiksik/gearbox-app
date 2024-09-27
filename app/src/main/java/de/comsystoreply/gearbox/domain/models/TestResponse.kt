package de.comsystoreply.gearbox.domain.models

import com.google.gson.annotations.SerializedName

data class TestResponse(
    @SerializedName("message")
    var message: String? = null
)
