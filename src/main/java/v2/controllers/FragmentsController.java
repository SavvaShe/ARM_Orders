package v2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import v2.model.request.CreateCardRequest;

@Controller
public class FragmentsController {
    @GetMapping("/menu")
    public String getMenu() {
        return "menu";
    }

    @PostMapping("/orders")
    public String openOrders(){
        return " ";
    }

    @PostMapping("/cards")
    public String openCards(){
        return " ";
    }

    @PostMapping("/dashboard")
    public String openDashboard(){
        return " ";
    }

    @PostMapping("/settings")
    public String openSettings(){
        return " ";
    }

    @PostMapping("/services")
    public String openServices(){
        return " ";
    }

}
