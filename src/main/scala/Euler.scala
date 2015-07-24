import Problem.Problem

/**
 * Project Eular problem runner.
 */

object Euler {
  val usage =
    """
      | euler problem-number
      |
      |     problem-number must contain leading zeros to map to the targeted class name.
    """.stripMargin

  def main(args:Array[String]): Unit = {
    if (args.length == 0) {
      println(usage)
      return
    }

    val className = "Problem.Problem" + args(0)

    try {
      val problem:Problem = Class.forName(className).newInstance.asInstanceOf[Problem]

      val startTime = System.currentTimeMillis()
      val result: String = problem.run
      val stopTime = System.currentTimeMillis()

      println("Elapsed time: " + (stopTime - startTime) + "ms")
      println(result)

    } catch {
      case classException:ClassNotFoundException =>
        println(className + " does not exist")
      case typeException:NoClassDefFoundError =>
        println(className + " is not a valid Problem class")
      case e:Exception =>
        println("An unexpected error has occurred: " + e.getMessage)
    }
  }
}

