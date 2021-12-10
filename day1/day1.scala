import scala.io.Source
object day1{
    def main(args: Array[String]) : Unit = {
        val list = Source.fromFile("input.txt").getLines.map(x => x.toInt).toList
        println(list.zip(list.tail).map(x => x._2 - x._1).count(_ > 0))
        val sumwins = list.sliding(3).map(_.sum).toList
        println(sumwins.zip(sumwins.tail).map(x => x._2 - x._1).count(_ > 0))
    }
}