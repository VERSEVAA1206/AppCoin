package com.example.appcoin.Model
import kotlinx.serialization.Serializable

@Serializable
data class AssetsResponse (
    val data: List<Asset>
)