package ru.repeus.chat.data.account

import ru.repeus.chat.domain.type.Either
import ru.repeus.chat.domain.type.None
import ru.repeus.chat.domain.type.exception.Failure

interface AccountRemote {
    fun register(
        email: String,
        name: String,
        password: String,
        token: String,
        userDate: Long
    ): Either<Failure, None>
}