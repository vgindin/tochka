package tochka

// https://stackoverflow.com/questions/13912597/validate-email-one-liner-in-scala
object EmailValidator {

  private val emailRegex = """^[a-zA-Z0-9\.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$""".r

  def check(e: String): Boolean = e match{
    case null                                           => false
    case e if e.trim.isEmpty                            => false
    case e if emailRegex.findFirstMatchIn(e).isDefined  => true
    case _                                              => false
  }

  def main(args: Array[String]): Unit = {
    val inputStr = scala.io.StdIn.readLine()
    println(check(inputStr))
  }

  assert(check("test@gmail.com"))
  assert(!check("t es t@gmailcom"))
  assert(!check("b ob @tes tmai l.com"))
  assert(check("test@gmail.com"))
  assert(!check("t es t@gmailcom"))
  assert(!check("b ob @tes tmai l.com"))

  assert(check("test@gma.i.l.c.o.m"))
  assert(check("test@gmailcom"))
  assert(check("test@gma.i.l.c.o.m"))
  assert(check("test@gmailcom"))
}
