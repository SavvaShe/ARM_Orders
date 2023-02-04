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
        request.setNumber(nextOrderNumber(request.getSystems()));
        OrderResponse orderResponse =  orderService.create(request);
        return "redirect:../order_list";
    }

 //Для подтягивания шаблонных нарядов на вход строковое значение типа наряда
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
    //Для получения следующего номера Наряда на вход нужно передать Систему в строковом формате
    public String nextOrderNumber(String sys) {
        NextOrderNumber nextOrderNumber = new NextOrderNumber();
        return nextOrderNumber.nextOrderNumber(sys);
    }
//Для подтягивания данных из карточки на вход нужно передать наполнения пользователем инфы про наряд,и данные карточки данные из которой нужно передать в наряд
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

    @PostMapping("/order_edit/save_order_change/{idOrders}")
    public String updateOrder(CreateOrderRequest request, @PathVariable Integer idOrders){
        ModelAndView mav = new ModelAndView("order_edit");
        OrderResponse orderResponse = orderService.update(idOrders, request);
        return "../../order_list";

    }

}