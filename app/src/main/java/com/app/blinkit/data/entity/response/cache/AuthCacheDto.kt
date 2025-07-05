package com.app.blinkit.data.entity.response.cache

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.app.blinkit.core.Constants
import com.app.blinkit.domain.model.AuthModel

@Entity(tableName = Constants.authTableName)
class AuthCacheDto(
    @PrimaryKey(autoGenerate = false)
    val id: Int = 1,
    val kind:String?,
    val localId:String?,
    val email:String?,
    val displayName:String?,
    val idToken:String?,
    val registered:Boolean?,
    val refreshToken:String?,
    val expiresIn:String?,
) {
    fun toModel(): AuthModel{
        return AuthModel(
            kind = kind,
            localId = localId,
            email = email,
            displayName= displayName,
            idToken = idToken,
            registered = registered,
            refreshToken = refreshToken,
            expiresIn = expiresIn,
        )
    }
}