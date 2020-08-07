package ru.repeus.chat.ui.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.repeus.chat.cache.AccountCacheImpl
import ru.repeus.chat.cache.SharedPrefsManager
import ru.repeus.chat.data.account.AccountRepositoryImpl
import ru.repeus.chat.domain.account.AccountRepository
import ru.repeus.chat.domain.account.Register
import ru.repeus.chat.remote.account.AccountRemoteImpl
import ru.repeus.chat.remote.core.NetworkHandler
import ru.repeus.chat.remote.core.Request
import ru.repeus.chat.remote.service.ServiceFactory
import ru.repeus.chat.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefs = this.getSharedPreferences(this.packageName, Context.MODE_PRIVATE)

        val accountCache = AccountCacheImpl(SharedPrefsManager(sharedPrefs))
        val accountRemote = AccountRemoteImpl(Request(NetworkHandler(this)), ServiceFactory.makeService(true))

        val accountRepository: AccountRepository = AccountRepositoryImpl(accountRemote, accountCache)

        accountCache.saveToken("12345")

        val register = Register(accountRepository)
        register(Register.Params("abcd@m.com", "abcd", "123")) {
            it.either({
                Toast.makeText(this, it.javaClass.simpleName, Toast.LENGTH_SHORT).show()
            }, {
                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_SHORT).show()
            })
        }
    }
}
