package com.proyecto.amphibiansapp.data

import com.proyecto.amphibiansapp.network.Amphibians
import com.proyecto.amphibiansapp.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibians>
}

class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
): AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibians> = amphibiansApiService.getAmphibians()
}