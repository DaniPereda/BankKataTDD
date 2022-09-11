package application

import java.time.LocalDate
import java.time.LocalDateTime

interface ClockTransaction {
    fun now():LocalDateTime
}