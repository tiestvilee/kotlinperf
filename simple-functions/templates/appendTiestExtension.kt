package simple{}

fun String.append() : String {{
  return this + "tiest"
}}

fun doIt() : String {{
  return "hello".append()
}}


