package domain

import java.sql.SQLData
import java.time.LocalDateTime
import java.util.Date

data class Transaction(
    var amount:Int = 0,
    var balanceAtMoment:Int = 0,
    var date: LocalDateTime = LocalDateTime.now()
) {

}

