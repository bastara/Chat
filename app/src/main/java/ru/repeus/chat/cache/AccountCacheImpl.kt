package ru.repeus.chat.cache

import ru.repeus.chat.data.account.AccountCache
import ru.repeus.chat.domain.type.Either
import ru.repeus.chat.domain.type.None
import ru.repeus.chat.domain.type.exception.Failure
import javax.inject.Inject

class AccountCacheImpl @Inject constructor(private val prefsManager: SharedPrefsManager) : AccountCache {

    override fun saveToken(token: String): Either<Failure, None> {
        return prefsManager.saveToken(token)
    }

    override fun getToken(): Either<Failure, String> {
        return prefsManager.getToken()
    }
}