package application

import domain.Account
import domain.Transaction

interface ResultWriter {
    fun printTransaction(transaction: Transaction, balanceTemp: Int)

    fun printName(name: String)

    fun printBalance(balance: Int)

}