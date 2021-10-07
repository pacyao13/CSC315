
import kotlin.random.Random

fun main() {
    val customers = generateLine(10) // generate a line of customers
    val register = CashRegister()             // summon a cash register
    register.helpCustomers(customers)         // staffs the cash register to help the customers
}

class CashRegister {
    // Cash register is responsible for parsing through the line of customers.
    // It calculates the wait time for each customer.
    fun helpCustomers(customerLine: MutableList<Customer>) {
        for (c in customerLine){
            var wt = 0.0
            for (i in 0..c.position){
                wt += customerLine[i].registerTime
            }
            println("Customer ${c.position} is at the register for ${c.registerTime}")
            println("Customer ${c.position} is in the line for $wt")
        }
    }
}

// this class only creates the instance of a customer when called.
class Customer(var position: Int, var registerTime: Double)

// This function generates a random number between 1 and ten, say, seconds.
// It will become a property of each customer.
fun generateWaitTime(): Double {
    return (Random.nextInt(1, 10).toDouble())
}

// Think of this function like a flyer that summons customers to the store.
// It returns a line (Mutable List) of customers.
fun generateLine(lineLength: Int): MutableList<Customer> {
    //will generate list of customers with preset times that it takes to
    //interact with the cashier.
    val lineArray = mutableListOf<Customer>()
    for (i in 0..lineLength) {
        val newCustomer = Customer(i, generateWaitTime())
        lineArray.add(newCustomer)
    }
    return lineArray
}
