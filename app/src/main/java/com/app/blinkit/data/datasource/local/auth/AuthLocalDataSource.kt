import androidx.compose.runtime.collectAsState
import com.app.blinkit.data.datasource.local.auth.AuthDao
import com.app.blinkit.data.entity.response.cache.AuthCacheDto
import com.app.blinkit.domain.model.AuthModel
import kotlinx.coroutines.flow.first

class AuthLocalDataSource(private val authDao: AuthDao){
    suspend fun insert(authData: AuthCacheDto): AuthModel{
        try {
            authDao.insert(authData = authData)
            return authDao.get().first().first().toModel()
        }catch (ex: Exception){
            throw ex
        }
    }

    suspend fun read(): AuthModel{
        try {
                return authDao.get().first().first().toModel()
            }catch (ex: Exception){
                throw ex
            }
        }

    suspend fun update(authData: AuthCacheDto): AuthModel{
        try {
            authDao.update(authData = authData)
            return authDao.get().first().first().toModel()
        }catch(ex: Exception){
            throw ex
        }
    }

    suspend fun delete(authData: AuthCacheDto): AuthModel{
        try{
            authDao.delete(authData = authData)
            return authDao.get().first().first().toModel()
        }catch(ex: Exception){
            throw ex
        }
    }
}