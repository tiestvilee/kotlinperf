package simple{}
import java.math.BigInteger
val Int.bigint: BigInteger get() = BigInteger.valueOf(this.toLong())
val Long.bigint: BigInteger get() = BigInteger.valueOf(this)
class BigIntegerRange(override val start: BigInteger, val end: BigInteger, val increment: BigInteger):
ClosedRange<BigInteger>, Iterable<BigInteger> {{
    init {{
        if (increment == BigInteger.ZERO) throw IllegalArgumentException("Increment must not be zero")
    }}
    override fun iterator(): Iterator<BigInteger> = object: Iterator<BigInteger> {{
        private var next: BigInteger = start
        private var hasNext: Boolean = if (increment > BigInteger.ZERO) start <= end else start >= end
        private val finalElement = calculateFinalElement()
        override fun next(): BigInteger {{
            val value = next
            if (next == finalElement) {{ hasNext = false }}
            else {{ next += increment }}
            return value
        }}
        override fun hasNext(): Boolean = hasNext
        private fun diffMod(a: BigInteger, b: BigInteger, m: BigInteger) = ((a.mod(m)) - (b.mod(m))).mod(m)
        private fun calculateFinalElement(): BigInteger =
        if (increment > BigInteger.ZERO) end - diffMod(end, start, increment) else end + diffMod(start, end, -increment)
    }}
    infix fun step(step: BigInteger) = BigIntegerRange(start, end, if (increment > BigInteger.ZERO) step else -step)
    infix fun step(step: Number) = step(step.toLong().bigint)

    override fun contains(value: BigInteger): Boolean = start <= value && value <= end
    override val endInclusive: BigInteger = BigInteger.ZERO
}}
infix fun BigInteger.rangeTo(that: BigInteger) = BigIntegerRange(this, that, BigInteger.ONE)
infix fun BigInteger.downTo(that: BigInteger) = BigIntegerRange(this, that, -1.bigint)
val zero = BigInteger.ZERO
val one = BigInteger.ONE
val two = 2.bigint
fun validate(n:BigInteger):Unit {{
    if (n < zero) {{ throw IllegalArgumentException() }}
}}
fun iterative(n:BigInteger):BigInteger {{
    validate(n)
    var result = zero;
    var  next = one;
    for (i in one rangeTo n) {{
        val temporary = result
        result = next
        next = temporary + next
    }}
    return result
}}
fun iterative(n:Int):BigInteger = iterative(n.bigint)
fun iterative(n:Long):BigInteger = iterative(n.bigint)
fun naïveRecursive(n:BigInteger):BigInteger {{
    validate(n)
    return when (n) {{
        zero -> zero
        one -> one
        else -> naïveRecursive(n - one) + naïveRecursive(n - two)
    }}
}}
fun naïveRecursive(n:Int):BigInteger = naïveRecursive(n.bigint)
fun naïveRecursive(n:Long):BigInteger = naïveRecursive(n.bigint)
fun tailRecursive(n:BigInteger):BigInteger {{
    validate(n)
    tailrec fun iterate(i:BigInteger, current:BigInteger=zero, next:BigInteger=one):BigInteger {{
        return if (i == zero) current else iterate(i - one, next, current + next)
    }}
    return iterate(n)
}}
fun tailRecursive(n:Int):BigInteger = tailRecursive(n.bigint)
fun tailRecursive(n:Long):BigInteger = tailRecursive(n.bigint)
fun sequence(n:Int):BigInteger {{
    validate(n.bigint)
    fun fs(): Sequence<Pair<BigInteger, BigInteger>> {{
        return generateSequence(Pair(zero, one), {{e -> Pair(e.second, e.first + e.second)}})
    }}
    return fs().take(n+1).last().first
}}
fun foldive(n:BigInteger):BigInteger {{
    validate(n)
    return (one rangeTo n).fold(Pair(zero, one), {{t, _ -> Pair(t.second, t.first + t.second)}}).first
}}
fun foldive(n:Int):BigInteger = foldive(n.bigint)
fun foldive(n:Long):BigInteger = foldive(n.bigint)