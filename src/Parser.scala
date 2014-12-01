import scala.util.parsing.combinator._
object Parser extends PipelineParser{
	def main(args: Array[String]) {
        parse( args(0) )        
    }
	
	
	def parse(str : String) = {
	  val result = parseAll(entry,str)
	  println(s"Parsed $result")
	  result
	}
}

trait PipelineParser extends JavaTokenParsers {
  lazy val varName = """[a-zA-Z0-9\._-]*""".r
  
  lazy val predicat = equal | notEqual | greaterThan
    
  lazy val equal = "EQUAL" ^^^ { "T.eq" }
  
  lazy val notEqual = "NOT_EQUAL" ^^^ { "T.neq" }
  
  lazy val greaterThan = "GREATER_THAN" ^^^ { "T.gt" }
  
  lazy val entry = "[StartPipe," ~> rep1sep(expr, ",")  <~ "]" ^^ { l => "g.V" + l.mkString}
  
  lazy val as 	= "AsPipe(" ~> varName ~ "," ~ expr <~ ")" ^^ { case a ~ "," ~ c => s".as('$a')$c"}
  
  lazy val has 	= "PropertyFilterPipe(" ~> varName ~ "," ~ predicat ~ "," ~ varName <~ ")" ^^ { case a ~ "," ~ b ~ "," ~ c => s".has('$a',$b,'$c')"}
  
  lazy val back = "BackFilterPipe([" ~> rep1sep(expr, ",") <~ "])" ^^ { case l => l.mkString + ".back(" + l.size + ")" }
  
  lazy val or 	= "OrFilterPipe([" ~> rep1sep(expr, ",") <~ "])"  ^^ { case a => ".or("+ a.mkString  +")"}
  
  lazy val out	= "VertexQueryPipe(" ~> varName ~ ",[" ~ varName <~ "],vertex)" ^^ { case a ~ b ~ c => s".$a('$c')"}
  
  lazy val underscore = "HasNextPipe([" ~> expr <~ "])" ^^ { case a => "_" + a}
  
  lazy val expr : Parser[String] = as  | has  | or | back | out | underscore
}
