package simple{}

inline fun functionToString(fn: (Int) -> Long, n : Int) : String {{
	return fn(n).toString()
}}

fun fibonacciR(n : Int) : Long {{
	var result = 0L;
	var  next = 1L;
	for (i in 1..n) {{
		val temporary = result
		result = next
		next = temporary + next
	}}
	return result
}}

fun fibonacciRToString(n : Int) : String {{
	return functionToString(::fibonacciR, n)
}}