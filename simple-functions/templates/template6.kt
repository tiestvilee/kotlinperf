package simple{}

import java.math.BigInteger

fun fibonacciR(n : Int) : BigInteger {{
    if (n < 2)
        return BigInteger.ONE
    else
        return fibonacciR(n - 1) + fibonacciR(n - 2)
}}
