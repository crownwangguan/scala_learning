package chapter1

object Driver {
  def main(args: Array[String]): Unit = {
    val newCafe = new Cafe()
    val cc = CreditCard(12345, "Guan")
    val bill = newCafe.buyCoffee(cc)
    println(s"Hello, ${cc.cardHolder} orders: ${bill._1.name} and cost: ${bill._2.amount}")
  }
}
