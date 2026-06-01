package data

import model.ProfileDataModel
import org.springframework.data.repository.CrudRepository

interface ProfileDataRepository: CrudRepository<ProfileDataModel, String> {

}