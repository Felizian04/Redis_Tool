package redis_tool.controller.dto

import java.time.Instant

data class LoginEntryRequest(
    val email: String,
    val login: Instant
)

