package infra.clock

import application.ClockTransaction
import java.time.LocalDateTime

class ClockTransactionImpl:ClockTransaction {
    override fun now(): LocalDateTime {
        return LocalDateTime.now()
    }

}