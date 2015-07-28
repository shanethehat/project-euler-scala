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
    val output = if (args.length == 0) {
      usage
    } else {
      runProblem(args)
    }

    println(output)
  }

  private def runProblem(args: Array[String]) = {
    val className = "Problem.Problem" + args(0)
    var output = ""

    try {
      val startTime = System.currentTimeMillis()
      val problem:Problem = Class.forName(className).newInstance.asInstanceOf[Problem]
      val result: String = problem.run()
      val stopTime = System.currentTimeMillis()

      output += "Elapsed time: " + (stopTime - startTime) + "ms\n"
      output += result + sys.props("line.separator")

    } catch {
      case classException:ClassNotFoundException =>
        output += className + " does not exist" + sys.props("line.separator")
      case typeException:NoClassDefFoundError =>
        output += className + " is not a valid Problem class"
      case e:Exception =>
        output += "An unexpected error has occurred: " + e.getMessage
    }

    output
  }
}

