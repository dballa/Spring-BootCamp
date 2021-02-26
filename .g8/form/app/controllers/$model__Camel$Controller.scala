def hello() = Action { implicit request: Request[AnyContent] =>
  Ok(views.html.hello())
}