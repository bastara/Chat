package ru.repeus.chat.domain.account

import ru.repeus.chat.domain.type.None
import ru.repeus.chat.domain.interactor.UseCase
import javax.inject.Inject

class UpdateToken @Inject constructor(
    private val accountRepository: AccountRepository
) : UseCase<None, UpdateToken.Params>() {

    override suspend fun run(params: Params) = accountRepository.updateAccountToken(params.token)

    data class Params(val token: String)
}