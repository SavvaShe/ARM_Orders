package v2.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.Objects;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AO_ORDERS")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders",nullable = false)
    private Integer idOrders;
    @Column(name = "id_otv")
    private int idOtv;//Ответсвенный
    @Column(name = "systems")
    private int systems;//система
    @Column(name = "number")
    private String number;//номер
    @Column(name = "date_create")
    private Date dateCreate;//дата создания
    @Column(name = "change_object")
    private String changeObject;//изменяемый объект
    @Column (name = "fc_agreement")
    private int fcAgreement;//требуется согласование с ФЗ
    @Column(name = "version")
    private String version;//Номер версии изменений
    @Column (name = "reasons")
    private String reasons;//Основание
    @Column (name = "conditions")
    private String conditions;//Условия выполнения наряда
    //private changeList;
    @Column(name = "doc_change")
    private String docChange;//Изменения в документации
    @Column(name = "d_src_prod")
    private String dSrcProd;// источник данных Промышленный полигон
    @Column(name = "d_src_test")
    private String dSrcTest;// источник данных Test полигон
    @Column(name = "install_test")
    private String installTest;//установка на Тест
    @Column(name = "install_prod")
    private String installProd;//установка на пром
    @Column(name = "method_test")
    private String methodTest;//метод проверки Тест
    @Column(name = "method_prod")
    private String methodProd;//метод проверки Пром
    @Column(name = "menhod_prodf")
    private String methodProdF;//Методика проверки функций Пром
    @Column(name = "method_testf")
    private String methodTestF;//Методика проверки функций Тест
    @Column(name = "rollback")
    private String rollback;//технология отката
    @Column (name = "responsible_contact")
    private String responsibleContact;//ответсвенный контакт
    @Column (name = "stop_system")
    private int stopSystem;//остановка системы 0-нет.1-да.
    @Column (name = "down_time")
    private String downTime;//Время простоя системы
    @Column(name = "id_prog")
    private int idProg;//id программиста
    @Column (name = "id_tech")
    private int idTech;//id технолога
    @Column(name = "phone_tech")
    private String phoneTech;//телефон технолога
    @Column (name = "phone_prog")
    private String phoneProg;//телефон программиста
    @Column(name = "id_adm")
    private int idAdm;//id администратора
    @Column(name = "phone_adm")
    private String phoneAdm;// телефон администратора
    @Column(name = "fzFTest")
    private String fzFTest;// ответсвенный от функц. заказчика
    @Column(name = "phoneFZFTest")
    private String phoneFZFTest;//номер ответсвенного от функц. заказчика

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return Objects.equals(idOrders, orders.idOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOrders);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "idOrders=" + idOrders +
                ", idOtv=" + idOtv +
                ", systems=" + systems +
                ", number='" + number + '\'' +
                ", dateCreate=" + dateCreate +
                ", changeObject='" + changeObject + '\'' +
                ", fcAgreement=" + fcAgreement +
                ", version='" + version + '\'' +
                ", reasons='" + reasons + '\'' +
                ", conditions='" + conditions + '\'' +
                ", docChange='" + docChange + '\'' +
                ", dSrcProd='" + dSrcProd + '\'' +
                ", dSrcTest='" + dSrcTest + '\'' +
                ", installTest='" + installTest + '\'' +
                ", installProd='" + installProd + '\'' +
                ", methodTest='" + methodTest + '\'' +
                ", methodProd='" + methodProd + '\'' +
                ", methodProdF='" + methodProdF + '\'' +
                ", methodTestF='" + methodTestF + '\'' +
                ", rollback='" + rollback + '\'' +
                ", responsibleContact='" + responsibleContact + '\'' +
                ", stopSystem=" + stopSystem +
                ", downTime='" + downTime + '\'' +
                ", idProg=" + idProg +
                ", idTech=" + idTech +
                ", phoneTech='" + phoneTech + '\'' +
                ", phoneProg='" + phoneProg + '\'' +
                ", idAdm=" + idAdm +
                ", phoneAdm='" + phoneAdm + '\'' +
                ", fzFTest='" + fzFTest + '\'' +
                ", phoneFZFTest='" + phoneFZFTest + '\'' +
                '}';
    }
}
