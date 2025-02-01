package com.example.cryptotracker.crypto.data.networking

import com.example.cryptotracker.core.domain.util.data.networking.constructUrl
import com.example.cryptotracker.core.domain.util.data.networking.safeCall
import com.example.cryptotracker.core.domain.util.presentation.util.NetworkError
import com.example.cryptotracker.core.domain.util.presentation.util.Result
import com.example.cryptotracker.core.domain.util.presentation.util.map
import com.example.cryptotracker.crypto.data.networking.dto.CoinResponseDto
import com.example.cryptotracker.crypto.domain.CoinDataSource
import com.example.cryptotracker.crypto.mappers.toCoin
import com.example.cryptotracker.crypto.domain.Coin
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(private val httpClient: HttpClient) : CoinDataSource {
    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { result -> result.toCoin() }
        }
    }


}