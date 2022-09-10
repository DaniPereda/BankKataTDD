package domain

import java.sql.SQLData
import java.time.LocalDateTime
import java.util.Date

class Transaction(
    var amount:Int = 0,
    var date: LocalDateTime = LocalDateTime.now()
) {

   private fun addTransaction(transaction:Transaction){

   }
    private fun retrieveAll(name:String):List<Transaction>{
        return listOf(Transaction())
    }
}