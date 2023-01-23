package v2.Service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.Orders;
import v2.model.request.CreateOrderRequest;
import v2.model.response.CardResponse;
import v2.model.response.OrderResponse;
import v2.repository.OrderRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private static OrderRepository orderRepository;

    //Получаем весь список пользователей
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::buildOrderResponse)
                .collect(Collectors.toList());

    }

    //Получаем пользователя по id
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public OrderResponse findById(@NotNull Integer idOrder) {
        return orderRepository.findById(idOrder)
                .map(this:: buildOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException("Order " + idOrder + " is not found"));

    }
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public OrderResponse findByUser(@NotNull Integer idOrder) {
        return orderRepository.findById(idOrder)
                .map(this:: buildOrderResponse)
                .orElseThrow(() -> new EntityNotFoundException("Order " + idOrder + " is not found"));

    }


    //Создаем пользователя
    @Override
    @Transactional
    @NotNull
    public OrderResponse create(@NotNull CreateOrderRequest request) {
       Orders orders = buildOrderRequest(request);
        OrderResponse orderResponse = buildOrderResponse(orderRepository.save(orders));
        return orderResponse;
    }

    //Обновляем пользователя по id
    @NotNull

    @Transactional
    public OrderResponse update(@NotNull Integer IdOrder, @NotNull CreateOrderRequest request) {
       Orders orders = (Orders) orderRepository.findById(IdOrder)
                .orElseThrow(() -> new EntityNotFoundException("Order " + IdOrder + " is not found"));
        buildOrderRequest(request);
        OrderResponse orderResponse = buildOrderResponse(orderRepository.save(orders));
        return orderResponse;
    }



    //Удаляем пользователя по id
    @Override
    @Transactional
    public void delete(@NotNull Integer IdOrder) {
        orderRepository.deleteById(IdOrder);
    }

    @NotNull
    @Transactional
    @Override
    public List<Orders> search(String keyword) {
        return null;
    }

    @NotNull
    private OrderResponse buildOrderResponse(@NotNull Orders orders) {
        return OrderResponse.builder()
                .idOrder(orders.getIdOrders())//так же со всеми полями
                .changeObject(orders.getChangeObject())
                .idOtv(orders.getIdOtv())
                .dateCreate(orders.getDateCreate())
                .idAdm(orders.getIdAdm())
                .conditions(orders.getConditions())
                .number(orders.getNumber())
                .docChange(orders.getDocChange())
                .downTime(orders.getDownTime())
                .dSrcTest(orders.getDSrcTest())
                .fcAgreement(orders.getFcAgreement())
                .dSrcProd(orders.getDSrcProd())
                .fzFTest(orders.getFzFTest())
                .idProg(orders.getIdProg())
                .idTech(orders.getIdTech())
                .installProd(orders.getInstallProd())
                .installTest(orders.getInstallTest())
                .methodProd(orders.getMethodProd())
                .methodProdF(orders.getMethodProdF())
                .methodTest(orders.getMethodTest())
                .methodTestF(orders.getMethodTestF())
                .phoneAdm(orders.getPhoneAdm())
                .phoneFZFTest(orders.getPhoneFZFTest())
                .phoneProg(orders.getPhoneProg())
                .phoneTech(orders.getPhoneTech())
                .reasons(orders.getReasons())
                .responsibleContact(orders.getResponsibleContact())
                .rollback(orders.getRollback())
                .stopSystem(orders.getStopSystem())
                .systems(orders.getSystems())
                .version(orders.getVersion()).build();


    }



//    private void orderUpdate(@NotNull Orders orders, @NotNull CreateOrderRequest request) {
//        ofNullable(request.getNumber()).map(orders::setNumber);//так же со всеми полями
//        ofNullable(request.getIdAdm()).map(orders::setIdAdm);
//        ofNullable(request.getIdOrder()).map(orders::setIdOrders);
//        ofNullable(request.getChangeObject()).map(orders::setChangeObject);
//        ofNullable(request.getIdOtv()).map(orders::setIdOtv);
//        ofNullable(request.getDateCreate()).map(orders::setDateCreate);
//        ofNullable(request.getConditions()).map(orders::setConditions);
//        ofNullable(request.getDocChange()).map(orders::setDocChange);
//        ofNullable(request.getDownTime()).map(orders::setDownTime);
//        ofNullable(request.getDSrcTest()).map(orders::setDSrcTest);
//        ofNullable(request.getFcAgreement()).map(orders::setFcAgreement);
//        ofNullable(request.getDSrcProd()).map(orders::setDSrcProd);
//        ofNullable(request.getFzFTest()).map(orders::setFzFTest);
//        ofNullable(request.getIdProg()).map(orders::setIdProg);
//        ofNullable(request.getIdTech()).map(orders::setIdTech);
//        ofNullable(request.getInstallProd()).map(orders::setInstallProd);
//        ofNullable(request.getInstallTest()).map(orders::setInstallTest);
//        ofNullable(request.getMethodProd()).map(orders::setMethodProd);
//        ofNullable(request.getMethodProdF()).map(orders::setMethodProdF);
//        ofNullable(request.getMethodTest()).map(orders::setMethodTest);
//        ofNullable(request.getMethodTestF()).map(orders::setMethodTestF);
//        ofNullable(request.getPhoneAdm()).map(orders::setPhoneAdm);
//        ofNullable(request.getPhoneFZFTest()).map(orders::setPhoneFZFTest);
//        ofNullable(request.getPhoneProg()).map(orders::setPhoneProg);
//        ofNullable(request.getPhoneTech()).map(orders::setPhoneTech);
//        ofNullable(request.getReasons()).map(orders::setReasons);
//        ofNullable(request.getResponsibleContact()).map(orders::setResponsibleContact);
//        ofNullable(request.getRollback()).map(orders::setRollback);
//        ofNullable(request.getStopSystem()).map(orders::setStopSystem);
//        ofNullable(request.getSystems()).map(orders::setSystems);
//        ofNullable(request.getVersion()).map(orders::setVersion);
//
//    }

    @NotNull
    private Orders buildOrderRequest(@NotNull CreateOrderRequest request) {
        return Orders.builder()
                .idOrders(request.getIdOrder())//так же со всеми полями
                .changeObject(request.getChangeObject())
                .idOtv(request.getIdOtv())
                .dateCreate(request.getDateCreate())
                .idAdm(request.getIdAdm())
                .conditions(request.getConditions())
                .number(request.getNumber())
                .docChange(request.getDocChange())
                .downTime(request.getDownTime())
                .dSrcTest(request.getDSrcTest())
                .fcAgreement(request.getFcAgreement())
                .dSrcProd(request.getDSrcProd())
                .fzFTest(request.getFzFTest())
                .idProg(request.getIdProg())
                .idTech(request.getIdTech())
                .installProd(request.getInstallProd())
                .installTest(request.getInstallTest())
                .methodProd(request.getMethodProd())
                .methodProdF(request.getMethodProdF())
                .methodTest(request.getMethodTest())
                .methodTestF(request.getMethodTestF())
                .phoneAdm(request.getPhoneAdm())
                .phoneFZFTest(request.getPhoneFZFTest())
                .phoneProg(request.getPhoneProg())
                .phoneTech(request.getPhoneTech())
                .reasons(request.getReasons())
                .responsibleContact(request.getResponsibleContact())
                .rollback(request.getRollback())
                .stopSystem(request.getStopSystem())
                .systems(request.getSystems())
                .version(request.getVersion()).build();

    }
}
