package org.agcoding.govkmpwallet

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform