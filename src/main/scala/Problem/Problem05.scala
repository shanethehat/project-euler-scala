package Problem

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
class Problem05 extends Problem {
  private val startingPoint = 2522
  private val maxDivisor = 20

  override def run(): String = {
    val solution = findNumber(startingPoint)
    "The smallest number to divide by all the integers from 1 to 20 is: " + solution
  }

  private def findNumber(number:Int):Int = {

    def dividesBy(subject:Int, divisor:Int, limit:Int):Boolean = {
      if (divisor > limit) {
        true
      } else {
        if (subject % divisor == 0) dividesBy(subject, divisor + 1, limit) else false
      }
    }

    if (dividesBy(number, 2, maxDivisor)) {
      number
    } else {
      findNumber(number + 2)
    }
  }
}
