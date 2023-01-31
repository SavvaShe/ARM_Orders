package v2.Service;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import v2.domain.NSIDefOrders;
import v2.model.request.CreateOrderRequest;
import v2.model.response.OrderResponse;
import v2.repository.DefOrderRepository;


@Service
@RequiredArgsConstructor
public class DefOrderServiceImpl implements DefOrderService {
    private final DefOrderRepository orderRepository;


    //Получаем весь список пользователей


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
    @Transactional
    public OrderResponse create(CreateOrderRequest request) {
        NSIDefOrders orders = buildOrderRequest(request);
       // System.out.println(orders);
        //     System.out.println("fghjk");
        /// System.out.println(request);
        NSIDefOrders orders1 = orderRepository.save(orders);
        OrderResponse orderResponse = buildOrderResponse(orders1);
        return orderResponse;
    }



    @NotNull
    private OrderResponse buildOrderResponse(@NotNull NSIDefOrders orders) {
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





    @NotNull
    private NSIDefOrders buildOrderRequest(@NotNull CreateOrderRequest request) {
        return NSIDefOrders.builder()
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
