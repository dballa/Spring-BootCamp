// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Bjorn/Downloads/play-samples-play-scala-hello-world-tutorial/conf/routes
// @DATE:Fri Feb 26 15:43:50 CET 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
