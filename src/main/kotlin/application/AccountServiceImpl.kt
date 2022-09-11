package application

class AccountServiceImpl(var dataPersistence: DataPersistence, var writer:ResultWriter, var clockTransaction: ClockTransaction):AccountService {
    override fun deposit(name:String, amount: Int) {
        var account = dataPersistence.readAccount(name)

        account.addDeposit(amount, clockTransaction.now())

        dataPersistence.createOrUpdateAccount(account)

    }

    override fun withdraw(name:String, amount: Int) {
        var account = dataPersistence.readAccount(name)

        account.addWithdraw(amount, clockTransaction.now())

        dataPersistence.createOrUpdateAccount(account)
    }

    override fun printStatement(name:String) {
        var account = dataPersistence.readAccount(name)

        writer.printName(name)
        writer.printBalance(account.balance)
        writer.printTransactions(account.transactions)

    }
}