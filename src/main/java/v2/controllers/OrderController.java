package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.OrderService;
import v2.domain.Orders;
import v2.logic.DefOrders;
import v2.logic.NextOrderNumber;
import v2.model.request.CreateCardRequest;
import v2.model.request.CreateOrderRequest;
import v2.model.response.CardResponse;
import v2.model.response.OrderResponse;

import java.util.List;

@RestController
@RequestMapping("resources/templates/")
@RequiredArgsConstructor
public class OrderController {


    private final OrderService orderService;

    //Получаем весь список карточек
//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    public List<CardResponse> findAll() {
//        return cardService.findAll();
//    }

    @GetMapping("/order_list")
    public ModelAndView openList() {
        ModelAndView mav = new ModelAndView("orders_list");
        mav.addObject("listOrders", findAll());
        return mav;
    }

    @GetMapping("/order_view/{idOrders}")
    public ModelAndView openOrderView(/*@RequestParam*/@PathVariable Integer idOrders) {
        ModelAndView mav = new ModelAndView("order_view");
        mav.addObject("orderView",orderService.findById(idOrders));
        return mav;
    }

//    @GetMapping("/orders_list")
//    public ModelAndView openList() {
//        List<OrderResponse> List = orderService.findAll();
//        ModelAndView mav = new ModelAndView("orders_list");
//        mav.addObject("listOrders", List);
//        return mav;
//    }

    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }
    //    //Получаем карточку по id
//    @GetMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public CardResponse findById(@PathVariable Integer IdCard) {
//        return cardService.findById(IdCard);
//    }
    @RequestMapping( value ="order_view", method = {RequestMethod.GET, RequestMethod.PUT}, consumes = MediaType.ALL_VALUE)
    public ModelAndView findById(@RequestParam Integer idOrder){
        ModelAndView mav = new ModelAndView("order_view");
        OrderResponse orderResponse = orderService.findById(idOrder);
        mav.addObject("orders",orderResponse);
        return mav;
    }

//    @PostMapping( "/card_edit/save_card_change/{idCards}")
//    public String updateCard(/*@ModelAttribute*/ CreateCardRequest request, @PathVariable Integer idCards) {
//        ModelAndView mav = new ModelAndView("card_edit");
//        System.out.println(request);
//        //CardResponse cardResponse = cardService.findById(idCards);
////        mav.addObject("cardsKorr", request);
////        CardServiceImpl imp = new CardServiceImpl();
////        cardRepository.save(imp.buildCardRequest(request));
//        CardResponse cardResponse = cardService.update(idCards,request);
//        return "redirect:../../card_view/"+idCards;
//    }

    @GetMapping("/order_create")
    public ModelAndView openCreateOrder() {
        ModelAndView mav = new ModelAndView("order_create");
        CreateOrderRequest cr = new CreateOrderRequest();
        mav.addObject("order_create", cr);
        return mav;
    }
//    @RequestMapping( value ="new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
//    public String createOrder(/*@ModelAttribute*/ CreateOrderRequest request){
//        ModelAndView mav = new ModelAndView("order_create");
//        OrderResponse orderResponse =  orderService.create(request);
//        return "orders_list.html";
//    }


    @RequestMapping( value ="/new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
    public String createOrder(/*@ModelAttribute*/ CreateOrderRequest request){
        ModelAndView mav = new ModelAndView("order_create");
        String sysName = "";
        switch (request.getSystems()){
            case 1:
                sysName = "ЕМД";
            case 2:
                sysName = "РРД";
            default:
                sysName = "ЕМД";
        }
        request.setNumber(nextOrderNumber(sysName));
        OrderResponse orderResponse =  orderService.create(request);
        return "redirect:order_list";
    }

    @GetMapping("/select_orders_list")
    public ModelAndView openSelectOrdersList() {
        ModelAndView mav = new ModelAndView("select_orders_list");
        List<OrderResponse> List = orderService.findAll();
        System.out.println(List);
        mav.addObject("selectOrdersList",List);
        System.out.println(mav);
        return mav;
    }


    @GetMapping("/korr_id_order")
    public ModelAndView openEditWithId(@RequestParam Integer idOrder){
        ModelAndView mav = new ModelAndView("order_edit");
        OrderResponse orderResponse = orderService.findById(idOrder);
        mav.addObject("orderkorr",orderResponse);
        return mav;
    }
    @PostMapping("/korr_order")
    public String korr(@RequestBody CreateOrderRequest request,@RequestParam Integer idOrder){
        orderService.update(idOrder,request);
        return "redirect:/order_list";
    }
    @PostMapping("/def")
    public ModelAndView defOrders(@RequestParam String type){
        ModelAndView mav = new ModelAndView("order_edit");
        DefOrders defOrders = new DefOrders();
        mav.addObject("def",defOrders.findByType(type));
        return mav;
    }
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
    public String nextOrderNumber(String sys){
        NextOrderNumber nextOrderNumber = new NextOrderNumber();
        return nextOrderNumber.nextOrderNumber(sys);
    }
    //
//    //Создаем карту
//    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public CardResponse create(@RequestBody CreateCardRequest request) {
//        return cardService.createCard(request);
//    }



//    @RequestMapping( value ="/new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
//    public String create(/*@ModelAttribute*/ CreateOrderRequest request){
//        ModelAndView mav = new ModelAndView("order_create");
//        OrderResponse orderResponse =  orderService.create(request);
//        System.out.println(orderResponse);
//        return "redirect:order_list";
//    }


    //    //Обновляем карту по id
//    @PatchMapping(value = "/{IdCard}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public CardResponse update(@PathVariable Integer IdCard, @RequestBody CreateCardRequest request) {
//        return cardService.update(IdCard, request);
//    }

    //    //Удаляем карту по id
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public void delete(@PathVariable Integer IdCard) {
//        cardService.delete(IdCard);
//    }

}