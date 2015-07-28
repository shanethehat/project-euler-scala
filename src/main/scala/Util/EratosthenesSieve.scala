package Util

/**
 * Find primes up to max
 */
class EratosthenesSieve(largestPrime:Long = Int.MaxValue, maximumPrimes:Int = Int.MaxValue) {
  private var multiplier:Long = 3
  private var primes = List[Long](2)

  private def primeCheck(subject:Long):Boolean = {
    val root = Math.sqrt(subject.toDouble)

    def checkPrime(subject:Long, count:Int):Boolean = {
      val prime = primes(count)
      if (subject % prime == 0) {
        false
      } else if (prime > root) {
        true
      } else {
        checkPrime(subject, count + 1)
      }
    }

    checkPrime(subject, 0)
  }

  val stopper = if (largestPrime < Int.MaxValue) {
    () => {
      multiplier <= largestPrime
    }
  } else {
    () => {
      primes.size < maximumPrimes
    }
  }

  while (stopper()) {
    if (primeCheck(multiplier)) {
      primes = primes :+ multiplier
    }
    multiplier += 2
  }

  def isPrime(value:Long):Boolean = {
    primes.contains(value)
  }

  def getLargest:Long = {
    primes.last
  }
}
