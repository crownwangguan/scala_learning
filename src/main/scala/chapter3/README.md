# Chapter 3

Functional data structures are by definition immutable

## Sealed trait & Variance
```sealed trait List[+A]```

A **trait** is an abstract interface that may optionally contain implementations of some methods.

Adding **sealed** in front means that all implementations of the trait must be declared in this file.

In the declaration trait ```List[+A]```, the ```+``` in front of the type parameter A is a variance annotation that signals that A is a covariant or “positive” parameter of List. This means that, for instance, ```List[Dog]``` is considered a subtype of ```List[Animal]```, assuming ```Dog``` is a subtype of ```Animal```.

## Pattern Matching
Pattern matching works a bit like a fancy switch statement that may descend into the structure of the expression it examines and extract subexpressions of that structure.

```
def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }
```


### Companion objects
This is just an object with the same name as the data type where we put various convenience functions for creating or working with values of the data type.

## Data Sharing
We say that functional data structures are persistent, meaning that existing references are never changed by operations on the data structure.

```
def append[A](a1: List[A], a2: List[A]): List[A] = a1 match {
    case Nil => a2
    case Cons(h,t) => Cons(h, append(t, a2)) 
}
```
Note that this definition only copies values until the first list is exhausted, so its runtime and memory usage are determined only by the length of a1. 
The remaining list then just points to a2.