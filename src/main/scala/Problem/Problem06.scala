package Problem

/**
 * The sum of the squares of the first ten natural numbers is:
 * 1^^2 + 2^^2 + ... + 10^^2 = 385
 *
 * The square of the sum of the first ten natural numbers is:
 * (1 + 2 + ... + 10)^^2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
 */
class Problem06 extends Problem{
  override def run(): String = {
    val numbers = 1 to 100
    val sumOfSquares = {
      var sum = 0
      for (n <- numbers) {
        sum += n * n
      }
      sum
    }
    val squareOfSums = {
      val sum = numbers.sum
      sum * sum
    }

    "The sum square difference is: " + (squareOfSums - sumOfSquares)
  }
}
