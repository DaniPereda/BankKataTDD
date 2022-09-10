package application

interface AccountService {

        fun deposit(name:String, amount:Int)
        fun withdraw(name:String, amount:Int)
        fun printStatement(name:String)

}