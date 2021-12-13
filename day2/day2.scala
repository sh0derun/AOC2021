import scala.io.Source
object day2 {
    def part1(commands: List[(String, Int)]): Int = {
        val map = commands.foldLeft(Map[String, Int]("up"->0,"down"->0,"forward"->0))((acc, curr)=>{
            acc.updated(curr._1, if(curr._1 == "up") acc.get(curr._1).get - curr._2 else acc.get(curr._1).get + curr._2)
        })
        (map.get("down").get+map.get("up").get)*map.get("forward").get
    }
    def part2(commands: List[(String, Int)]): Int = {
        val map = commands.foldLeft(Map[String, Int]("horizantal"->0,"depth"->0,"aim"->0))((acc, curr)=>{
            curr._1 match {
                    case "down"    => acc.updated("aim", acc.get("aim").get + curr._2)
                    case "up"      => acc.updated("aim", acc.get("aim").get - curr._2)
                    case "forward" => Map[String, Int]("horizantal" -> (acc.get("horizantal").get + curr._2).toInt,
                                                       "depth"      -> ((curr._2 * acc.get("aim").get) + acc.get("depth").get).toInt,
                                                       "aim"        -> acc.get("aim").get)
            }
        })
        map.get("horizantal").get * map.get("depth").get
    }
    def main(args: Array[String]): Unit = {
        val map = Source.fromFile("input.txt").getLines.toList
        .map(x=>{val n = x.split(" ")
                (n(0),n(1).toInt)})
        println(part1(map))
        println(part2(map));
    }
}
