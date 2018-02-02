package simple{}

interface MyInterface {{
	val myValue:String
}}

class MyClass(override val myValue:String) : MyInterface 