package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.OrderService;
import v2.domain.CardV2;
import v2.domain.Orders;
import v2.model.request.CreateCardRequest;
import v2.model.request.CreateOrderRequest;
import v2.model.response.OrderResponse;

import java.util.List;

@RestController
@RequestMapping("src/main/resources/templates/orders/")
@RequiredArgsConstructor
public class OrderController {
    @Autowired
    private OrderService orderService;

    //Получаем весь список карточек
//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    public List<CardResponse> findAll() {
//        return cardService.findAll();
//    }
    @GetMapping("/order_list")
    public ModelAndView openList() {
        List<OrderResponse> List = orderService.findAll();
        ModelAndView mav = new ModelAndView("order_list");
        mav.addObject("orderCards", List);
        return mav;
    }


//    //Получаем карточку по id
//    @GetMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public CardResponse findById(@PathVariable Integer IdCard) {
//        return cardService.findById(IdCard);
//    }
    @GetMapping("/")
    public ModelAndView findById(@RequestParam int idOrder){
        ModelAndView mav = new ModelAndView("order_view");
        OrderResponse orderResponse = orderService.findById(idOrder);
        mav.addObject("orders",orderResponse);
        return mav;
    }

//
//    //Создаем карту
//    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public CardResponse create(@RequestBody CreateCardRequest request) {
//        return cardService.createCard(request);
//    }
    @GetMapping("/edit")
    public String openEditCards(){
        return "order_edit";
    }
    @GetMapping("/edit_id")
    public ModelAndView openEditWithId(@RequestParam int idOrder){
        ModelAndView mav = new ModelAndView("order_edit");
        OrderResponse orderResponse = orderService.findById(idOrder);
        mav.addObject("orderkorr",orderResponse);
        return mav;
    }
    @PostMapping("/new")
    public String create(@RequestBody CreateOrderRequest request){
        orderService.create(request);
        return "redirect:/order_list";
    }



//    //Обновляем карту по id
//    @PatchMapping(value = "/{IdCard}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public CardResponse update(@PathVariable Integer IdCard, @RequestBody CreateCardRequest request) {
//        return cardService.update(IdCard, request);
//    }
    @PostMapping("/korr")
    public String korr(@RequestBody CreateOrderRequest request,@RequestParam int idOrder){
    orderService.update(idOrder,request);
    return "redirect:/order_list";
}
//    //Удаляем карту по id
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public void delete(@PathVariable Integer IdCard) {
//        cardService.delete(IdCard);
//    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{idOrder}")
    public String delete(@RequestParam int idOrder) {
        orderService.delete(idOrder);
        return "redirect:/order_list";
    }
    public ModelAndView search(@RequestParam String keyword) {
        List<Orders> result = orderService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }
}
