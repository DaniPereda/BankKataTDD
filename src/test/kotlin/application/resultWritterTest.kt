package application

import domain.Account
import domain.Transaction
import org.junit.jupiter.api.Test
import infra.resultWritter.ConsoleResultWriter
import org.mockito.Mock
import java.time.LocalDateTime
import java.time.Month
import kotlin.test.assertEquals

class resultWritterTest {
    @Mock
    private var writer: ConsoleResultWriter? = null




    @Test
    fun `print transaction Test`(){
       /* //GIVEN
        var sut = ConsoleResultWriter()
        var dateTime = LocalDateTime.of(2012, Month.JANUARY, 10, 0,0)
        var transaction = Transaction(1000, dateTime)

        //WHEN
        sut.printTransaction(transaction)

        //THEN
        assertEquals("10/01/2012 || 1000   || 1000", )

        ///ESTO COMOS E >PRUEBA!!!*/


    }

}