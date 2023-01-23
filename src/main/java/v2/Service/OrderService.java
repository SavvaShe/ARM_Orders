package v2.Service;


import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.CardV2;
import v2.domain.Orders;
import v2.model.request.CreateCardRequest;
import v2.model.request.CreateOrderRequest;
import v2.model.response.CardResponse;
import v2.model.response.OrderResponse;

import java.sql.Date;
import java.util.List;

public interface OrderService {

    @NotNull
    List<OrderResponse> findAll();

    @NotNull
   OrderResponse findById(@NotNull Integer idOrder);



    @NotNull
    OrderResponse update(@NotNull Integer idOrder, @NotNull CreateOrderRequest  request);

    //Создаем пользователя
    @NotNull
    @Transactional
   OrderResponse create(@NotNull CreateOrderRequest request);

    //Обновляем пользователя по id

    void delete(@NotNull Integer idOrder);

    List<Orders> search(String keyword);

    OrderResponse    findByUser(@NotNull Integer idOtv);
}


