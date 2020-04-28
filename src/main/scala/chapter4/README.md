# Chapter 4 

## Referential Transparent
Any RT expression may be substituted with the value it refers to, and this substitution should preserve program meaning.

For example,
```
def failingFn(i: Int): Int = {
    val y: Int = throw new Exception("fail!") 
    try {
        val x = 42 + 5
        x+y 
    }
    catch { 
        case e: Exception => 43 
    } 
}
```
This example will return exception: ```java.lang.Exception: fail!```

However, if substitute y, the exception will be caught.
```
def failingFn2(i: Int): Int = { 
    try {
        val x = 42 + 5
        x + ((throw new Exception("fail!")): Int) 
    }
    catch { 
        case e: Exception => 43 
    } 
}
```

## Option Data
Option has two cases: it can be defined, in which case it will be a Some, or it can be undefined, in which case it will be None.

**Lifting functions** turns a function f of type `A => B` into a function of type `Option[A] => Option[B]`

