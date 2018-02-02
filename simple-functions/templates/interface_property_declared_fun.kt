package simple{}

interface MyInterface {{
	val myValue:String
	fun haha() : String
}}

class MyClass(override val myValue:String) : MyInterface {{
	override fun haha() : String = myValue
}}