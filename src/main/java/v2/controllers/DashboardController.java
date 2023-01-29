package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.CardService;
import v2.Service.OrderService;
import v2.model.response.CardResponse;
import v2.model.response.OrderResponse;

import java.util.List;

@RestController
@RequestMapping("resources/templates")
@RequiredArgsConstructor
public class DashboardController {

    private final OrderService orderService;
    private final CardService cardService;

    @GetMapping("/my_order_list")
    public ModelAndView openMyOrderList(@PathVariable Integer idUser) {
        ModelAndView mav = new ModelAndView("orders_list");
        mav.addObject("orderCards", orderService.findByUser(idUser));
        return mav;
    }

    @GetMapping("/my_card_list")
    public ModelAndView openMyCardList(@PathVariable Integer idUser) {
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("dashCardsList", cardService.findAll());
        return mav;
    }

    @GetMapping("/my_orders_list")
    public ModelAndView openMyOredersList(@PathVariable Integer idUser) {
        ModelAndView mav = new ModelAndView("dashboard");
        mav.addObject("dashOrdersList", cardService.findAll());
        return mav;
    }

}