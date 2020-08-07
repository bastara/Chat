package ru.repeus.chat.data.account

import ru.repeus.chat.domain.type.Either
import ru.repeus.chat.domain.type.None
import ru.repeus.chat.domain.type.exception.Failure

interface AccountCache {
    fun getToken(): Either<Failure, String>
    fun saveToken(token: String): Either<Failure, None>
}