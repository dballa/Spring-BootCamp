package com.example.application.views.Prove;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;
import com.example.application.views.main.MainView;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.component.button.Button;


@CssImport("./views/Prove/hello-view.css")
@Route (value="helloIkub", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("HelloWorld per Ikubin")

public class HelloView extends Div {

    public HelloView(){
        addClassName("hello-view");
        Button button=new Button("Shfaq");

        Text text = new Text("Hello World @IkubAcademy");
        add(button,text);
        button.addClickListener(e -> {
            text.setText("Hello Man");
        });




    }
}
