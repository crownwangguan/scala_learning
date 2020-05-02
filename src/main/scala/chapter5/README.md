# Chapter 5

## Strictness and laziness

A strict function always evaluates its arguments.

A value of type `() => A` is a function that accepts zero arguments and returns an A. 
In general, the unevaluated form of an expression is called a __thunk__, and we can force the thunk to evaluate the expression and get a result. 
We do so by invoking the function, passing an empty argument list, as in onTrue() or onFalse()

```
def if2[A](cond: Boolean, onTrue: => A, onFalse: => A): A =
    if (cond) onTrue else onFalse
```

Cache the value explicitly if we wish to only evaluate the result once, by using the lazy keyword:
```
def maybeTwice2(b: Boolean, i: => Int) = { 
    lazy val j = i
    if (b) j+j else 0
}

val x = maybeTwice2(true, { println("hi"); 1+41 })
```

Laziness lets us separate the description of an expression from the evaluation of that expression. 
This gives us a powerful ability—we may choose to describe a “larger” expression than we need, and 
then evaluate only a portion of it.

```
def exists(p: A => Boolean): Boolean = this match { 
    case Cons(h, t) => p(h()) || t().exists(p)
    case _ => false
}
```
Note that `||` is non-strict in its second argument. 
If `p(h())` returns true, then exists terminates the traversal early.
