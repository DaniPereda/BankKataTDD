package infra.dataBase

import domain.Account
import application.DataPersistence

class FakeDataBase() : DataPersistence {
    override var data: MutableMap<String, Account> = mutableMapOf()

    override fun createOrUpdateAccount(account: Account) {
        data = mutableMapOf()

    }

    override fun readAccount(accountName: String): Account {

        return Account("")
    }

    private fun createAccount(account: Account){
        data = mutableMapOf()
    }

    private fun UpdateAccount(account: Account){
        data = mutableMapOf()
    }


}