package infra.resultWritter

import domain.Transaction

class ConsoleResultWriter : application.ResultWriter {
    /*   override fun showTransactions(account: Account) {
           printName(account.name)
           printBalance(account.balance)

           var transactionReverse = account.transactions.asReversed()
           println("Date       || Amount || Balance")

           var balanceTemp = 0
           for(transaction in transactionReverse)
           {
               balanceTemp += transaction.amount
               printTransaction(transaction, balanceTemp)
           }
       }*/

    override fun printTransaction(transaction: Transaction, balanceTemp: Int) {
        println("${printDate(transaction)} || ${transaction.amount}   || $balanceTemp")
    }

    private fun printDate(transaction: Transaction) =
        "${formatNumber(transaction.date.dayOfMonth)}/${formatNumber(transaction.date.monthValue)}/${transaction.date.year}"

    private fun formatNumber(day: Int): String {
        var dayStr = day.toString()
        return if (dayStr.length == 1)
            "0$dayStr"
        else
            dayStr
    }

    override fun printName(name: String) {
        println("Name = $name")
    }

    override fun printBalance(balance: Int) {
        println("Balance = $balance")
    }

}