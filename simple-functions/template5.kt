package simple{}

fun fibonacciR(n : Int) : Long {{
    if (n < 2)
        return 1
    else
        return fibonacciR(n - 1) + fibonacciR(n - 2)
}}
