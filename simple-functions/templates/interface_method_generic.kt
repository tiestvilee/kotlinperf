package simple{}

interface MyInterface<T> {{
	fun doIt(input:T) : T
}}

class MyClass() : MyInterface<String> {{
	override fun doIt(input:String) : String {{
		return "hello"
	}}
}}