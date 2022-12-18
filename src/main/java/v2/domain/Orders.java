package v2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.util.Objects;

@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "AO_ORDERS")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrders;
    @Column(name = "idOtv")
    private int idOtv;//Ответсвенный
    @Column(name = "systems")
    private int systems;//система
    @Column(name = "number")
    private String number;//номер
    @Column(name = "dateCreate")
    private Date dateCreate;//дата создания
    @Column(name = "changeObject")
    private String changeObject;//изменяемый объект
    @Column (name = "fcAgreement")
    private int fcAgreement;//требуется согласование с ФЗ
    @Column(name = "version")
    private String version;//Номер версии изменений
    @Column (name = "reasons")
    private String reasons;//Основание
    @Column (name = "conditions")
    private String conditions;//Условия выполнения наряда
    //private changeList;
    @Column(name = "docChange")
    private String docChange;//Изменения в документации
    @Column(name = "dSrcProd")
    private String dSrcProd;// источник данных Промышленный полигон
    @Column(name = "dSrcTest")
    private String dSrcTest;// источник данных Test полигон
    @Column(name = "installTest")
    private String installTest;//установка на Тест
    @Column(name = "installProd")
    private String installProd;//установка на пром
    @Column(name = "methodTest")
    private String methodTest;//метод проверки Тест
    @Column(name = "methodProd")
    private String methodProd;//метод проверки Пром
    @Column(name = "menhodProdF")
    private String methodProdF;//Методика проверки функций Пром
    @Column(name = "methodTestF")
    private String methodTestF;//Методика проверки функций Тест
    @Column(name = "rollback")
    private String rollback;//технология отката
    @Column (name = "responsibleContact")
    private String responsibleContact;//ответсвенный контакт
    @Column (name = "stopSystem")
    private int stopSystem;//остановка системы 0-нет.1-да.
    @Column (name = "downTime")
    private String downTime;//Время простоя системы
    @Column(name = "idProg")
    private int idProg;//id программиста
    @Column (name = "idTech")
    private int idTech;//id технолога
    @Column(name = "phoneTech")
    private String phoneTech;//телефон технолога
    @Column (name = "phoneProg")
    private String phoneProg;//телефон программиста
    @Column(name = "idAdm")
    private int idAdm;//id администратора
    @Column(name = "phoneAdm")
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
