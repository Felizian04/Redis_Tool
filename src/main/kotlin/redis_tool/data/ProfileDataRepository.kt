package redis_tool.data

import redis_tool.model.ProfileDataModel
import org.springframework.data.repository.CrudRepository

interface ProfileDataRepository: CrudRepository<ProfileDataModel, String> {

}