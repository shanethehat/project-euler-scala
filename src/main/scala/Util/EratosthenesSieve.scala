package Util

/**
 * Find primes up to max
 */
class EratosthenesSieve(max:Long) {
  var multiplier:Long = 3
  var primes = List[Long](2)

  private def primeCheck(subject:Long):Boolean = {
    val root = Math.sqrt(subject.toDouble)
    for (n <- primes) {
      if (subject % n == 0) {
        return false
      }
      if (n >root) {
        return true
      }
    }
    true
  }

  while (multiplier <= max) {
    if (primeCheck(multiplier)) {
      primes = primes :+ multiplier
    }
    multiplier += 2
  }

  def isPrime(value:Long) = {
    primes.contains(value)
  }

  def getLargest = {
    primes.last
  }
}
