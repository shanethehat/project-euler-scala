package Problem

import Util.EratosthenesSieve

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 *
 * What is the 10 001st prime number?
 */
class Problem07 extends Problem {
  private val targetPrime = 10001

  override def run(): String = {
    val sieve = new EratosthenesSieve(maximumPrimes = targetPrime)
    "The 10001st prime is: " + sieve.getLargest
  }
}
