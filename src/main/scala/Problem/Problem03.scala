package Problem

import Util.EratosthenesSieve

/**
 * The prime factors of 13195 are 5, 7, 13 and 29.
 *
 * What is the largest prime factor of the number 600851475143 ?
 */
class Problem03 extends Problem {
  override def run(): String = {
    val original = 600851475143L
    val limit = Math.sqrt(original).toLong

    val sieve = new EratosthenesSieve(limit)

    val testValues = Range.Long.apply(3, limit, 2).reverse

    for (i:Long <- testValues) {
      val divided = original / i
      if (original % divided == 0 && sieve.isPrime(i)) {
        return "Largest Prime is: " + i
      }
    }

    "Something has gone wrong, no prime was found"
  }

}
