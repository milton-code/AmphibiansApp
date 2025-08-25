package com.proyecto.amphibiansapp.network

import retrofit2.http.GET

interface AmphibiansApiService {
    @GET ("amphibians")
    suspend fun getAmphibians(): List<Amphibian>
}