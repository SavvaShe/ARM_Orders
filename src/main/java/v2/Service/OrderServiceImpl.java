package v2.Service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.CardV2;
import v2.domain.Orders;
import v2.model.request.CreateCardRequest;
import v2.model.request.CreateOrderRequest;
import v2.model.response.CardResponse;
import v2.model.response.OrderResponse;
import v2.repository.CardRepository;
import v2.repository.OrderRepository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.of;
import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    //Получаем весь список
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<OrderResponse> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(this::buildOrderResponse)
                .collect(Collectors.toList());

    }

    @Override
    public @NotNull List<OrderResponse> findByIdCard(Integer idCard) {
       return orderRepository.findByIdCard(idCard)
                .stream()
                .map(this::buildOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public @NotNull List<OrderResponse> findByIdOtv(Integer id) {
        return orderRepository.findByIdOtv(id)
                .stream()
                .map(this::buildOrderResponse)
                .collect(Collectors.toList());
    }

    @Override
    public @NotNull List<OrderResponse> findByDateCreate(java.sql.Date date) {
        return orderRepository.findByDateCreate(date)
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


    //Создание
    @NotNull
    @Override
    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        Orders orders = buildOrderRequest(request);
        System.out.println(orders);
        //     System.out.println("fghjk");
        /// System.out.println(request);
        Orders orders1 = orderRepository.save(orders);
        OrderResponse orderResponse = buildOrderResponse(orders1);
        return orderResponse;
    }
    //Обновляем  по id
    @NotNull
    @Override
    @Transactional

    public OrderResponse update(@NotNull Integer IdOrder, @NotNull CreateOrderRequest request) {
        Orders orders =  orderRepository.findById(IdOrder)
                .orElseThrow(() -> new EntityNotFoundException("Card " + IdOrder + " is not found"));
        Orders cv = buildOrderRequest(request);
        return buildOrderResponse(orderRepository.save(cv));
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

    //Для обертки данных из БД в класс
    @NotNull
    private OrderResponse buildOrderResponse(@NotNull Orders orders) {
        return OrderResponse.builder()
                .idOrders(orders.getIdOrders())//так же со всеми полями
                .changeObject(orders.getChangeObject())
                .idOtv(orders.getIdOtv())
                .dateCreate(orders.getDateCreate())
                .idAdm(orders.getIdAdm())
                .conditions(orders.getConditions())
                .number(orders.getNumber())
                .docChange(orders.getDocChange())
                .downTime(orders.getDownTime())
                .srcTest(orders.getSrcTest())
                .srcProd(orders.getSrcProd())
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
                .version(orders.getVersion())
                .synchronization(orders.getSynchronization())
                .dateInstallTest(orders.getDateInstallTest())
                .timeInstallTest(orders.getTimeInstallTest())
                .idContactTest(orders.getIdContactTest())
                .phoneContactTest(orders.getPhoneContactTest())
                .dataSourceTest(orders.getDataSourceTest())
                .periodTest(orders.getPeriodTest())
                .resultsTest(orders.getResultsTest())
                .resultsTestConclusion(orders.getResultsTestConclusion())
                .fzProject(orders.getFzProject())
                .idCTSOtv(orders.getIdCTSOtv())
                .dataSourceProd(orders.getDataSourceProd())
                .dateInstallProd(orders.getDateInstallProd())
                .phoneCTSOtv(orders.getPhoneCTSOtv())
                .idDelegate(orders.getIdDelegate()).build();



    }



    //Нужно для развертывания данных пользователя и переделки в данные реплекации таблицы
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
                .srcTest(request.getSrcTest())
                .srcProd(request.getSrcProd())
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
                .version(request.getVersion())
                .synchronization(request.getSynchronization())
                .dateInstallTest(request.getDateInstallTest())
                .timeInstallTest(request.getTimeInstallTest())
                .idContactTest(request.getIdContactTest())
                .phoneContactTest(request.getPhoneContactTest())
                .dataSourceTest(request.getDataSourceTest())
                .periodTest(request.getPeriodTest())
                .resultsTest(request.getResultsTest())
                .resultsTestConclusion(request.getResultsTestConclusion())
                .fzProject(request.getFzProject())
                .idCTSOtv(request.getIdCTSOtv())
                .dataSourceProd(request.getDataSourceProd())
                .dateInstallProd(request.getDateInstallProd())
                .idDelegate(request.getIdDelegate()).build();

    }
}
