package redis_tool.controller

import org.springframework.transaction.annotation.Transactional
import redis_tool.controller.dto.LoginEntryRequest
import redis_tool.data.ProfileDataRepository
import redis_tool.model.ProfileDataModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import redis_tool.logic.ProfileEntryManager

@RestController
@RequestMapping(path = ["/redis"])
class RedisController(
    private val profileDataRepository: ProfileDataRepository,
    private val profileEntryManager: ProfileEntryManager
) {

    @PostMapping()
    fun createProfileData(@RequestBody profileData: ProfileDataModel): ProfileDataModel {
        return profileDataRepository.save(profileData)
    }

    @PostMapping("/login")
    @Transactional
    fun addLoginEntryForProfile(@RequestBody request: LoginEntryRequest): ProfileDataModel? {
        val givenEntry = profileDataRepository.findById(request.email).orElse(null)
        if (givenEntry != null) {
            profileEntryManager.addLoginToProfileEntry(givenEntry, request.login)
            return profileDataRepository.save(givenEntry)
        }

        return null
    }

    @GetMapping()
    fun getAllProfileDataEntries() : Iterable<ProfileDataModel> {
        return profileDataRepository.findAll()
    }

}