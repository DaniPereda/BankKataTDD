package domain

import java.time.LocalDateTime

data class Account (var name:String = "",
               var balance:Int = 0,
               var transactions:MutableList<Transaction> = mutableListOf()) {


    fun addDeposit(amount:Int, dateTime: LocalDateTime){
        addAmount(amount)
        addTransaction(amount, dateTime)

    }

    fun addWithdraw(amount:Int, dateTime: LocalDateTime){
        if(notEnoughBalance(amount))
            throw ArithmeticException("Not enough money")
        else {
            subtractAmount(amount)
            addWithdrawTransaction(amount, dateTime)
        }
    }

    private fun addWithdrawTransaction(amount: Int, date:LocalDateTime) {
        addTransaction(amount * -1, date)
    }

    private fun subtractAmount(amount: Int) {
        addAmount(amount * -1)
    }

    private fun notEnoughBalance(amount: Int) = this.balance < amount

    private fun addTransaction(amount: Int, date:LocalDateTime) {
        this.transactions.add(Transaction(amount, this.balance, date))
    }

    private fun addAmount(amount: Int) {
        this.balance += amount
    }


}


