package domain

import application.DataPersistence
import java.time.LocalDateTime

class Account (var name:String = "") {
    var balance = 0
    var transactions = mutableListOf<Transaction>()

    fun addDeposit(amount:Int){
        addAmount(amount)
        addTransaction(amount)

    }

    private fun addTransaction(amount: Int) {
        this.transactions.add(Transaction(amount, LocalDateTime.now()))
    }

    private fun addAmount(amount: Int) {
        this.balance += amount
    }


}


