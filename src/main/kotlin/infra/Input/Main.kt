import application.AccountServiceImpl
import domain.Transaction
import infra.clock.ClockTransactionImpl
import infra.dataBase.FakeDataBase
import infra.resultWritter.ConsoleResultWriter
import java.time.LocalDateTime
import java.time.Month

fun main(args: Array<String>) {


    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.


    var db = FakeDataBase()
    var writter = ConsoleResultWriter()
    var clockTransaction = ClockTransactionImpl()
    var accountService = AccountServiceImpl(db, writter, clockTransaction)
    accountService.deposit("Dani", 100)
    accountService.deposit("Dani", 100)
    accountService.withdraw("Dani", 200)
    accountService.deposit("Dani", 100)

    accountService.printStatement("Dani")

}