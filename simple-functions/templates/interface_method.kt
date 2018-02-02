package simple{}

interface MyInterface {{
	fun doIt(input:String) : String
}}

class MyClass() : MyInterface {{
	override fun doIt(input:String) : String {{
		return "hello"
	}}
}}