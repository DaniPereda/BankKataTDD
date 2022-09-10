package application

class AccountServiceImpl(var dataPersistence: DataPersistence):AccountService {
    override fun deposit(name:String, amount: Int) {
        var account = dataPersistence.readAccount(name)

        account.addDeposit(amount)

        dataPersistence.createOrUpdateAccount(account)

    }

    override fun withdraw(name:String, amount: Int) {
        var account = dataPersistence.readAccount(name)
    }

    override fun printStatement(name:String) {
        var account = dataPersistence.readAccount(name)
    }
}