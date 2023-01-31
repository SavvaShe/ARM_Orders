package v2.logic;

import v2.Service.OrderService;
import v2.model.response.OrderResponse;
import v2.repository.OrderRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//EMD230131 10
public class NextOrderNumber {
    OrderService service;
    private String nextOrder(){
       List<OrderResponse> ListOrder = service.findAll();
       OrderResponse or = ListOrder.get(ListOrder.size() -1);
      return or.getNumber();
    }
    public String nextOrderNumber(String system){
    String counter = counter();
    String date = dateNow();
    return system + date + counter;
    }
    private String dateNow(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyMMdd");
        return format.format(date);
    }
    private String counter(){
        String last = nextOrder();
      Integer i =0;
      String str = last.substring(3,9);
      Integer lastdate = Integer.parseInt(str);
      Integer nowdate = Integer.parseInt(dateNow());
      if(lastdate<nowdate){
          i = 1;
      }
      else {
          i = 1+ Integer.parseInt(last.substring(9));
      }
        String str1;
        if (i<10){
          str1 = "0"+ Integer.toString(i);
      }
      else{  str1 = Integer.toString(i);}
       return str1;
    }
}
