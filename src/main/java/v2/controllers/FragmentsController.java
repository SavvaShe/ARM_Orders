package v2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import v2.model.request.CreateCardRequest;

@Controller
public class FragmentsController {
    @GetMapping("/menu")
    public String getMenu() {
        return "menu";
    }

    @PostMapping("/orders")
    public String openOrders(){
        return "card_list";
    }

    @PostMapping("/cards")
    public String openCards(){
        return "card_list";
    }

    @PostMapping("/dashboard")
    public String openDashboard(){
        return "card_list";
    }

    @PostMapping("/settings")
    public String openSettings(){
        return "card_list";
    }

    @PostMapping("/services")
    public String openServices(){
        return "card_list";
    }

    @RequestMapping("/my_cards_list")
    public String showDashCardsList(){
        return "dashdoard_cards :: #dashCardsList";
    }
}
