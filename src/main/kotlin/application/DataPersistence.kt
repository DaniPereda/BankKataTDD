package application

import domain.Account

interface DataPersistence {
    var data:MutableMap<String, Account>

    fun createOrUpdateAccount(account: Account)

    fun readAccount(accountName: String): Account
}