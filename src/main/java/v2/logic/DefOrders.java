package v2.logic;

import v2.Service.DefOrderService;
import v2.model.response.OrderResponse;
//типы нарядов
public class DefOrders {
    DefOrderService defOrderService;
    public OrderResponse findByType(String type){
        Integer id = 0;
        switch (type){
            default: id = 0;
            case "РРД-ГП":
                id = 0;
            case "ЕМД(кор)":
                id=1;
            case "ЕМД(пер)":
                id=2;
            case "ЕМД(нов)":
                id=3;
        }
        OrderResponse or = defOrderService.findById(id);
        return or;

    }
}
