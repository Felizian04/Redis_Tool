package redis_tool.logic

import org.springframework.stereotype.Service
import redis_tool.model.ProfileDataModel
import java.time.Instant

@Service
class ProfileEntryManager {
    fun addLoginToProfileEntry(profileEntry: ProfileDataModel, login: Instant) {
        profileEntry.lastLogins.add(login)
    }
}