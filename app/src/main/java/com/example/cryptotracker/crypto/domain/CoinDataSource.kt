package com.example.cryptotracker.crypto.domain

import com.example.cryptotracker.core.domain.util.presentation.util.NetworkError
import com.example.cryptotracker.core.domain.util.presentation.util.Result

interface CoinDataSource {
    suspend fun getCoins():Result<List<Coin>, NetworkError>
}