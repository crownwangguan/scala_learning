package chapter2

import scala.annotation.tailrec

object Driver {

  def fib(n: Int): Int = {
    @tailrec
    def loop(n: Int, prev: Int, curr: Int): Int = n match {
      case 0 => prev
      case _ => loop(n - 1, curr, prev + curr)
    }
    loop(n, 0, 1)
  }

  def isSorted[A](as: Array[A], ordered: (A,A) => Boolean): Boolean = {
    @tailrec
    def iter(n: Int): Boolean = {
      if (n >= as.length - 1)
        true
      else if (!ordered(as(n), as(n+1)))
        false
      else
        iter(n+1)
    }
    iter(0)
  }

  // turn f(a, b) into f(a)(b)
  def curry[A,B,C](f: (A, B) => C): A => (B => C) = {
    a => (b => f(a, b))
  }

  // turn f(a)(b) into f(a,b)
  def uncurry[A,B,C](f: A => B => C): (A, B) => C = {
    (a, b) => f(a)(b)
  }

  def _f(a: Int, b: Int): Int = a + b
  def _g(a: Int)(b: Int): Int = a + b

  def main(args: Array[String]): Unit = {
    println(fib(10))
    println(isSorted(Array(1, 3, 5, 7), (x: Int, y: Int) => x < y))
    println(isSorted(Array("Scala", "Function"), (x: String, y: String) => x.length < y.length))
    println(curry(_f)(1)(1) == _f(1, 1))
    println(uncurry(_g)(1, 1) == _g(1)(1))
  }
}
