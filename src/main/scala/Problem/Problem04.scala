package Problem

/**
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 */
class Problem04 extends Problem {
  override def run(): String = {
    var palindromes:List[Int] = List[Int]()
    for (a <- 100 to 999) {
      for (b <- a to 999) {
        val product = a * b
        if (isPalindrome(product))
         palindromes = palindromes :+ product
      }
    }
    palindromes = palindromes.sorted
    "The largest palindrome is: " + palindromes.last
  }

  private def isPalindrome(value:Int):Boolean = {
    val asString = value.toString
    asString == asString.reverse
  }
}
