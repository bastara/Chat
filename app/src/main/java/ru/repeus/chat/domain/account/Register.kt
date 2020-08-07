package ru.repeus.chat.domain.account

import ru.repeus.chat.domain.type.None
import ru.repeus.chat.domain.type.Either
import ru.repeus.chat.domain.type.exception.Failure
import ru.repeus.chat.domain.interactor.UseCase
import javax.inject.Inject

class Register @Inject constructor(
    private val repository: AccountRepository
) : UseCase<None, Register.Params>() {

    override suspend fun run(params: Params): Either<Failure, None> {
        return repository.register(params.email, params.name, params.password)
    }

    data class Params(val email: String, val name: String, val password: String)
}

