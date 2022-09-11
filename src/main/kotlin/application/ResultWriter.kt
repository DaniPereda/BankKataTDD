package application

import domain.Transaction

interface ResultWriter {
    fun printTransactions(transaction: MutableList<Transaction>)

    fun printName(name: String)

    fun printBalance(balance: Int)

}