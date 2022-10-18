import kotlin.math.sqrt
import kotlin.math.pow

fun main() {

    val fraction1 = Fraction(6, 13)
    val fraction2 = Fraction(12, 26)

    println (fraction1.add (fraction2))
}

class Point(private val x: Double, private val y: Double) {
    override fun toString(): String {

        return "x=$x, y=$y"
    }

    private val negativeX =-x
    private val negativeY =-y


    fun sym(): String {

        return "x=$negativeX, y=$negativeY"
    }
    override fun equals(other: Any?): Boolean {

        return this.toString() == other.toString()
    }
    fun len(obj: Point): Double {

        val z: Double = this.x - obj.x
        val t: Double = this.y- obj. y
        return sqrt(z.pow(2.0) + t.pow(2.0))

    }

    override fun hashCode(): Int {
        var result = x.hashCode()
        result = 31 * result + y.hashCode()
        result = 31 * result + negativeX.hashCode()
        result = 31 * result + negativeY.hashCode()
        return result
    }
}

class Fraction(private var numerator: Int, private var denominator: Int) {

    private fun cut():String {

        var numerator2 = numerator
        var denominator2 = denominator

        for (n in 2..numerator2) {

            while (numerator2%n==0 && denominator2%n==0) {
                numerator2 /= n
                denominator2 /= n
            }
        }
        return "$numerator2 / $denominator2"
    }

    fun mul(frc:Fraction):String {

        val a = numerator*frc.numerator
        val b = denominator*frc.denominator
        return "$a / $b"
    }

    fun add(frc:Fraction):String {

        var a1 = numerator
        var a2 = frc.numerator
        var b1 = denominator
        var b2 = frc.denominator
        val c = denominator

        if (denominator!=frc.denominator) {

            a1*=b2
            a2*=c
            b1*=b2
            b2*=c
        }
        val d = a1+a2
        val f = Fraction(d, b2)

        return f.cut()
    }

}
