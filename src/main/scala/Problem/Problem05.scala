package Problem

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
class Problem05 extends Problem {
  override def run(): String = {
    "The smallest number to divide by all the integers from 1 to 20 is: " + findNumber(2522)
  }

  private def findNumber(number:Int):Int = {
    if (dividesByEverything(number)) {
      return number
    }
    findNumber(number + 2)
  }

  private def dividesByEverything(number:Int):Boolean = {
    for (d <- 1 to 20) {
      if (number % d != 0)
        return false
    }
    true
  }
}
