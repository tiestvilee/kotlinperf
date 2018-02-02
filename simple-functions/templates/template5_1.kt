package simple{}

fun fibonacciR(n : Int) : Long {{
    return if (n < 2)
        1
    else
        fibonacciR(n - 1) + fibonacciR(n - 2)
}}
