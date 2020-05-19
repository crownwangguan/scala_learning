# Chapter 6

## Purely functional state
Function like `scala.util.Random` cannot be easily reproduced. 
Thus, not referential transparency.

Resolved by making the state updates `explicit`.
Don’t update the state as a side effect, but simply return the new state along with the value that we’re generating.

Rather than returning only the generated random number and updating some internal state by mutating it in place,
we return the random number and the **new state**, leaving the old state unmodified.

When we call `rng.nextInt`, it will always return `16159453` and a new `RNG`, whose `nextInt` will always return `-1281479697`.

``` 
class Foo {
    private var s: FooState = ... 
    def bar: Bar
    def baz: Int
}
```

Suppose bar and baz each mutate s in some way. We can mechanically translate this to
the purely functional API by making explicit the transition from one state to the next:

``` 
trait Foo {
    def bar: (Bar, Foo) 
    def baz: (Int, Foo)
}
```
Whenever we use this pattern, we make the caller responsible for passing the computed next state through the rest of the program.

## Combinators
`RNG => (A, RNG)` for some type A. 
Functions of this type are called state actions or state transitions because they transform RNG states from one to the next. 
These state actions can be combined using **combinators**.

