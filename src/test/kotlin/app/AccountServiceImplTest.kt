package app

import org.junit.jupiter.api.Test
import domain.Account
import domain.Transaction
import application.AccountServiceImpl
import application.ClockTransaction
import application.DataPersistence
import application.ResultWriter
import java.time.LocalDateTime
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever
import kotlin.test.assertFailsWith


internal class AccountServiceImplTest {

   /*@InjectMocks
   private var sut: AccountServiceImpl? = null

   @Mock
   private var dataBase = FakeDataBase()

   @Captor
   private var captor: ArgumentCaptor<Account>? = null*/

   private val mockDataBase = mock<DataPersistence>()
   private val mockWriter = mock<ResultWriter>()
   private val mockClock = mock<ClockTransaction>()


   @Test
   fun `deposit in a new Account test`() {
      //GIVEN
      whenever(mockClock.now()).thenReturn(LocalDateTime.now())
      var resultDateTime = mockClock.now()

      var accountToRead = Account("myTest")

      whenever(mockDataBase.readAccount("myTest")).thenReturn(accountToRead)

      var sut = AccountServiceImpl(mockDataBase, mockWriter, mockClock )
      sut.deposit("myTest", 100)

      var resultAccount = Account("myTest", 100, mutableListOf(Transaction(100,100, resultDateTime)))

      verify(mockDataBase).createOrUpdateAccount(resultAccount)

   }

   @Test
   fun `withdraw with enough balance`() {
      //GIVEN
      whenever(mockClock.now()).thenReturn(LocalDateTime.now())
      var resultDateTime = mockClock.now()

      val accountToRead = Account("myTest", 1000, mutableListOf(Transaction(1000, 1000, resultDateTime)))

      whenever(mockDataBase.readAccount("myTest")).thenReturn(accountToRead)

      var sut = AccountServiceImpl(mockDataBase, mockWriter, mockClock )

      var resultAccount = Account("myTest", 100, mutableListOf(Transaction(1000, 1000, resultDateTime), Transaction(-900, 100, resultDateTime)))

      sut.withdraw("myTest", 900)

      verify(mockDataBase).createOrUpdateAccount(resultAccount)

   }

   @Test
   fun `withdraw with not enough balance`() {
      //GIVEN
      whenever(mockClock.now()).thenReturn(LocalDateTime.now())
      var resultDateTime = mockClock.now()

      val accountToRead = Account("myTest")
      accountToRead.balance = 1000
      accountToRead.transactions = mutableListOf(Transaction(1000, 1000, resultDateTime))

      whenever(mockDataBase.readAccount("myTest")).thenThrow(ArithmeticException("Not enough money"))

      var sut = AccountServiceImpl(mockDataBase, mockWriter, mockClock )

      assertFailsWith<ArithmeticException>(
         message = "Not enough money",
         block = {
            sut.withdraw("myTest", 9000)
         }
      )

   }

   @Test
   fun `print name Account`(){
      //GIVEN
      whenever(mockClock.now()).thenReturn(LocalDateTime.now())
      var resultDateTime = mockClock.now()

      val accountToRead = Account("myTest")
      whenever(mockDataBase.readAccount("myTest")).thenReturn(accountToRead)

      var sut = AccountServiceImpl(mockDataBase, mockWriter, mockClock )
      sut.printStatement("myTest")

      verify(mockWriter).printName("myTest")
   }

   @Test
   fun `print transactions Account`(){
      //GIVEN
      whenever(mockClock.now()).thenReturn(LocalDateTime.now())
      var resultDateTime = mockClock.now()

      val accountToRead = Account("myTest")
      accountToRead.transactions = mutableListOf(Transaction(100,100,resultDateTime), Transaction(50,150, resultDateTime))
      whenever(mockDataBase.readAccount("myTest")).thenReturn(accountToRead)

      var sut = AccountServiceImpl(mockDataBase, mockWriter, mockClock )
      sut.printStatement("myTest")

      verify(mockWriter).printTransactions(accountToRead.transactions)
   }

   @Test
   fun `print balance Account`(){
      //GIVEN
      whenever(mockClock.now()).thenReturn(LocalDateTime.now())
      var resultDateTime = mockClock.now()

      val accountToRead = Account("myTest")
      accountToRead.balance = 450
      whenever(mockDataBase.readAccount("myTest")).thenReturn(accountToRead)

      var sut = AccountServiceImpl(mockDataBase, mockWriter, mockClock )
      sut.printStatement("myTest")

      verify(mockWriter).printBalance(450)
   }



}