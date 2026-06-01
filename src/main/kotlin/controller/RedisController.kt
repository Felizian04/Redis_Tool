package controller

import data.ProfileDataRepository
import model.ProfileDataModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/redis"])
class RedisController(
    private val profileDataRepository: ProfileDataRepository
) {

    @PostMapping()
    fun createProfileData(@RequestBody profileData: ProfileDataModel): ProfileDataModel {
        return profileDataRepository.save(profileData)
    }

    @GetMapping()
    fun getAllProfileDataEntries() : Iterable<ProfileDataModel> {
        return profileDataRepository.findAll()
    }

}