package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.CardService;
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

 private final CardService cardService;

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



    public List<OrderResponse> findAll() {
        return orderService.findAll();
    }

    @RequestMapping( value ="order_view", method = {RequestMethod.GET, RequestMethod.PUT}, consumes = MediaType.ALL_VALUE)
    public ModelAndView findById(@RequestParam Integer idOrder){
        ModelAndView mav = new ModelAndView("order_view");
        OrderResponse orderResponse = orderService.findById(idOrder);
        mav.addObject("orders",orderResponse);
        return mav;
    }

    @GetMapping("/order_create/{idCards}")
    public ModelAndView openCreateOrder(/*@ModelAttribute*/@PathVariable Integer idCards) {
        ModelAndView mav = new ModelAndView("order_create");
        CardResponse cardResponse = cardService.findById(idCards);
        CreateOrderRequest cr = new CreateOrderRequest();
        cr = order(cr,cardResponse);
        System.out.println(cr);
        mav.addObject("order_create", cr);
        return mav;
    }

    @RequestMapping( value ="/new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
    public String createOrder(/*@ModelAttribute*/ CreateOrderRequest request){
        ModelAndView mav = new ModelAndView("order_create");
        OrderResponse orderResponse =  orderService.create(request);
        return "redirect:../order_list";
    }
/*    @GetMapping("/select_orders_list")
    public ModelAndView openSelectOrdersList() {
        ModelAndView mav = new ModelAndView("select_orders_list");
        List<OrderResponse> List = orderService.findAll();
       // System.out.println(List);
        mav.addObject("selectOrdersList",List);
     //   System.out.println(mav);
        return mav;
    }
*/
//    @GetMapping("/korr_id_order")
//    public ModelAndView openEditWithId(@RequestParam Integer idOrder){
//        ModelAndView mav = new ModelAndView("order_edit");
//        OrderResponse orderResponse = orderService.findById(idOrder);
//        mav.addObject("orderkorr",orderResponse);
//        return mav;
//    }
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
    public String nextOrderNumber(String sys) {
        NextOrderNumber nextOrderNumber = new NextOrderNumber();
        return nextOrderNumber.nextOrderNumber(sys);
    }

    public CreateOrderRequest  order(CreateOrderRequest createOrderRequest,CardResponse cardResponse){
        createOrderRequest.setSystems(cardResponse.getSystem());
        createOrderRequest.setIdCard(cardResponse.getIdCards());
        return createOrderRequest;

    }
    @GetMapping("order_edit/{idOrders}")
    public ModelAndView openEditWithId(/*@RequestParam*/@PathVariable Integer idOrders) {
        ModelAndView mav = new ModelAndView("order_edit");
        CreateOrderRequest co = new CreateOrderRequest();
        mav.addObject("orderKorr", orderService.findById(idOrders));
        return mav;
    }
 /*   @PostMapping( "/order_edit/save_order_change/{idOrders}")
    public String updateOrder(/*@ModelAttribute*/ /*CreateOrderRequest request, @PathVariable Integer idOrders) {
 /*       ModelAndView mav = new ModelAndView("order_edit");
        System.out.println(request);
        CardResponse cardResponse = cardService.findById(idCards);
        mav.addObject("cardsKorr", request);
        CardServiceImpl imp = new CardServiceImpl();
        cardRepository.save(imp.buildCardRequest(request));
        OrderResponse orderResponse = orderService.update(idOrders,request);
        return "/order_view/"+idOrders;
    } */

    @PostMapping("/order_edit/save_order_change/{idOrders}")
    public String updateOrder(CreateOrderRequest request, @PathVariable Integer idOrders){
        ModelAndView mav = new ModelAndView("order_edit");
        OrderResponse orderResponse = orderService.update(idOrders, request);
        return "../../order_list";

    }
    //    @GetMapping("/orders_list")
//    public ModelAndView openList() {
//        List<OrderResponse> List = orderService.findAll();
//        ModelAndView mav = new ModelAndView("orders_list");
//        mav.addObject("listOrders", List);
//        return mav;
//    }
    //    //Получаем карточку по id
//    @GetMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public CardResponse findById(@PathVariable Integer IdCard) {
//        return cardService.findById(IdCard);
//    }
//    @RequestMapping( value ="new_order", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
//    public String createOrder(/*@ModelAttribute*/ CreateOrderRequest request){
//        ModelAndView mav = new ModelAndView("order_create");
//        OrderResponse orderResponse =  orderService.create(request);
//        return "orders_list.html";
//    }
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