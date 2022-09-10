package app

import infra.dataBase.FakeDataBase
import infra.resultWritter.ConsoleResultWriter
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.*
import domain.Account
import domain.Transaction
import application.AccountServiceImpl
import application.DataPersistence
import org.mockito.Mockito.`when`
import java.time.LocalDateTime
import kotlin.test.assertEquals


class AccountServiceImplTest {

   /*@InjectMocks
   private var sut: AccountServiceImpl? = null

   @Mock
   private var dataBase = FakeDataBase()

   @Captor
   private var captor: ArgumentCaptor<Account>? = null*/


   private var sut: AccountServiceImpl? = null
   private var dataBase: DataPersistence? = null
   private var captor: ArgumentCaptor<Account>? = null

   @BeforeEach
   fun setUp() {
      dataBase = Mockito.mock(FakeDataBase::class.java)
      sut = AccountServiceImpl(dataBase!!)
   }



   @Test
   fun `deposit() in a new Account test`() {
      //GIVEN
      sut = AccountServiceImpl(dataBase!!)
      var testAccount = Account("myTest")
      `when`(dataBase!!.readAccount("myTest")).thenReturn(testAccount)


      //WHEN
      sut!!.deposit("myTest", 100)
      var resultAccount = Account("myTest")
      resultAccount.balance = 100
      resultAccount.transactions = mutableListOf(Transaction(100, LocalDateTime.now()))

      //THEN
      Mockito.verify(dataBase!!.createOrUpdateAccount(captor!!.capture()))
      assertEquals(resultAccount, captor!!.value)
   }

   @Test
   fun `deposit() in a used Account test`(){

   }

   @Test
   fun `withdraw() more than our Balance test`(){

   }

   @Test
   fun `withdraw() with enough balance test`(){

   }


}