package infra.dataBase

import domain.Account
import application.DataPersistence

class FakeDataBase() : DataPersistence {
    override var data: MutableMap<String, Account> = mutableMapOf()

    override fun createOrUpdateAccount(account: Account) {
        if(accountExists(account))
            updateAccountInDataBase(account)
        else
            createAccountInDataBase(account)
    }

    private fun createAccountInDataBase(account: Account) {
        data[account.name] = account
    }

    private fun updateAccountInDataBase(account: Account) {
        data.replace(account.name, account)
    }

    private fun accountExists(account: Account) = data.containsKey(account.name)

    override fun readAccount(accountName: String): Account {
        return data.getOrDefault(accountName, Account(accountName))
    }



}