package Problem

import Util.EratosthenesSieve

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
class Problem03 extends Problem {
  private val original = 600851475143L
  private val limit = Math.sqrt(original).toLong
  private val sieve = new EratosthenesSieve(limit)

  override def run(): String = {
    val start = if (limit % 2 == 0) limit + 1 else limit
    "Largest Prime is: " + findPrimeDescending(start)
  }

  private def findPrimeDescending(subject:Long):Long = {
    if (subject < 1) {
      throw new Exception("Prime subject " + subject + " is out of bounds")
    }

    val divided = original / subject

    if (original % divided == 0 && sieve.isPrime(subject)) {
      subject
    } else {
      findPrimeDescending(subject - 2)
    }
  }
}
