package com.example.cryptotracker.crypto.presentation.coin_list

import com.example.cryptotracker.core.domain.util.presentation.util.NetworkError
import org.koin.core.logger.MESSAGE

sealed interface CoinListEvent {

    data class Error (val error: NetworkError) :CoinListEvent

}