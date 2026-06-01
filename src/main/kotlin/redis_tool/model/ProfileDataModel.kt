package redis_tool.model

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import java.time.Instant
import kotlin.collections.mutableListOf

@RedisHash("profileData")
data class ProfileDataModel(
	@Id val email: String,
	val password: String,
	val name: String,
	val street: String,
	val houseNumber: String,
	val zipCode: String,
	val city: String,
	val lastLogins: MutableList<Instant> = mutableListOf()
)
