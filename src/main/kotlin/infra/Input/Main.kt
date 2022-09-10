import domain.Transaction
import infra.resultWritter.ConsoleResultWriter
import java.time.LocalDateTime
import java.time.Month

fun main(args: Array<String>) {


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    var sut = ConsoleResultWriter()
    var dateTime = LocalDateTime.of(2012, Month.JANUARY, 10, 0,0)
    var transaction = Transaction(1000, dateTime)

    //WHEN
    sut.printTransaction(transaction, 55)
}