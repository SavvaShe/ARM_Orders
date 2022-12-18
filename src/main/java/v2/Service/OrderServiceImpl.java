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
        orderUpdate(orders, request);
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
        return new OrderResponse()
                .setIdOrder(orders.getIdOrders())//так же со всеми полями
                .setChangeObject(orders.getChangeObject())
                .setIdOtv(orders.getIdOtv())
                .setDateCreate(orders.getDateCreate())
                .setIdAdm(orders.getIdAdm())
                .setConditions(orders.getConditions())
                .setNumber(orders.getNumber())
                .setDocChange(orders.getDocChange())
                .setDownTime(orders.getDownTime())
                .setDSrcTest(orders.getDSrcTest())
                .setFcAgreement(orders.getFcAgreement())
                .setDSrcProd(orders.getDSrcProd())
                .setFzFTest(orders.getFzFTest())
                .setIdProg(orders.getIdProg())
                .setIdTech(orders.getIdTech())
                .setInstallProd(orders.getInstallProd())
                .setInstallTest(orders.getInstallTest())
                .setMethodProd(orders.getMethodProd())
                .setMethodProdF(orders.getMethodProdF())
                .setMethodTest(orders.getMethodTest())
                .setMethodTestF(orders.getMethodTestF())
                .setPhoneAdm(orders.getPhoneAdm())
                .setPhoneFZFTest(orders.getPhoneFZFTest())
                .setPhoneProg(orders.getPhoneProg())
                .setPhoneTech(orders.getPhoneTech())
                .setReasons(orders.getReasons())
                .setResponsibleContact(orders.getResponsibleContact())
                .setRollback(orders.getRollback())
                .setStopSystem(orders.getStopSystem())
                .setSystems(orders.getSystems())
                .setVersion(orders.getVersion());


    }



    private void orderUpdate(@NotNull Orders orders, @NotNull CreateOrderRequest request) {
        ofNullable(request.getNumber()).map(orders::setNumber);//так же со всеми полями
        ofNullable(request.getIdAdm()).map(orders::setIdAdm);
        ofNullable(request.getIdOrder()).map(orders::setIdOrders);
        ofNullable(request.getChangeObject()).map(orders::setChangeObject);
        ofNullable(request.getIdOtv()).map(orders::setIdOtv);
        ofNullable(request.getDateCreate()).map(orders::setDateCreate);
        ofNullable(request.getConditions()).map(orders::setConditions);
        ofNullable(request.getDocChange()).map(orders::setDocChange);
        ofNullable(request.getDownTime()).map(orders::setDownTime);
        ofNullable(request.getDSrcTest()).map(orders::setDSrcTest);
        ofNullable(request.getFcAgreement()).map(orders::setFcAgreement);
        ofNullable(request.getDSrcProd()).map(orders::setDSrcProd);
        ofNullable(request.getFzFTest()).map(orders::setFzFTest);
        ofNullable(request.getIdProg()).map(orders::setIdProg);
        ofNullable(request.getIdTech()).map(orders::setIdTech);
        ofNullable(request.getInstallProd()).map(orders::setInstallProd);
        ofNullable(request.getInstallTest()).map(orders::setInstallTest);
        ofNullable(request.getMethodProd()).map(orders::setMethodProd);
        ofNullable(request.getMethodProdF()).map(orders::setMethodProdF);
        ofNullable(request.getMethodTest()).map(orders::setMethodTest);
        ofNullable(request.getMethodTestF()).map(orders::setMethodTestF);
        ofNullable(request.getPhoneAdm()).map(orders::setPhoneAdm);
        ofNullable(request.getPhoneFZFTest()).map(orders::setPhoneFZFTest);
        ofNullable(request.getPhoneProg()).map(orders::setPhoneProg);
        ofNullable(request.getPhoneTech()).map(orders::setPhoneTech);
        ofNullable(request.getReasons()).map(orders::setReasons);
        ofNullable(request.getResponsibleContact()).map(orders::setResponsibleContact);
        ofNullable(request.getRollback()).map(orders::setRollback);
        ofNullable(request.getStopSystem()).map(orders::setStopSystem);
        ofNullable(request.getSystems()).map(orders::setSystems);
        ofNullable(request.getVersion()).map(orders::setVersion);

    }

    @NotNull
    private Orders buildOrderRequest(@NotNull CreateOrderRequest request) {
        return new Orders()
                .setIdOrders(request.getIdOrder())//так же со всеми полями
                .setChangeObject(request.getChangeObject())
                .setIdOtv(request.getIdOtv())
                .setDateCreate(request.getDateCreate())
                .setIdAdm(request.getIdAdm())
                .setConditions(request.getConditions())
                .setNumber(request.getNumber())
                .setDocChange(request.getDocChange())
                .setDownTime(request.getDownTime())
                .setDSrcTest(request.getDSrcTest())
                .setFcAgreement(request.getFcAgreement())
                .setDSrcProd(request.getDSrcProd())
                .setFzFTest(request.getFzFTest())
                .setIdProg(request.getIdProg())
                .setIdTech(request.getIdTech())
                .setInstallProd(request.getInstallProd())
                .setInstallTest(request.getInstallTest())
                .setMethodProd(request.getMethodProd())
                .setMethodProdF(request.getMethodProdF())
                .setMethodTest(request.getMethodTest())
                .setMethodTestF(request.getMethodTestF())
                .setPhoneAdm(request.getPhoneAdm())
                .setPhoneFZFTest(request.getPhoneFZFTest())
                .setPhoneProg(request.getPhoneProg())
                .setPhoneTech(request.getPhoneTech())
                .setReasons(request.getReasons())
                .setResponsibleContact(request.getResponsibleContact())
                .setRollback(request.getRollback())
                .setStopSystem(request.getStopSystem())
                .setSystems(request.getSystems())
                .setVersion(request.getVersion());


    }
}
