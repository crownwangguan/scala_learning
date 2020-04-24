package chapter1

class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = Coffee(5, "Black Coffee")
    (cup, Charge(cc, cup.price))
  }
}
