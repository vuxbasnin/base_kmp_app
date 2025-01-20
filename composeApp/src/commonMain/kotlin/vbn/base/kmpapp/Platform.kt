package vbn.base.kmpapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform