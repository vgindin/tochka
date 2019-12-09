package tochka

object TestApp extends App {
  val t = "asdasdaaaweqbbbbasdasd".groupBy(_.toChar).values.toList.sortWith(_.length > _.length).reduce((a,b) => a + b)
  assert(t == "aaaaaaassssddddbbbbwqe" || t == "aaaaaaassssbbbbddddeqw") // группы с одинаковым кол-вом символов могут быть в произвольном порядке, например “qwe” или “eqw”
}
