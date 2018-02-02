package simple{}

interface MyInterface {{
	val myValue:String

	fun haha() : String = myValue
}}

class MyClass(override val myValue:String) : MyInterface 