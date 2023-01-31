package v2.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ao_orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orders",nullable = false)
    private Integer idOrders;
    @Column(name = "id_otv")
    private String idOtv;//Ответственный
    @Column(name = "systems")
    private String systems;//система
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
    @Column(name = "doc_change")
    private String docChange;//Изменения в документации
    @Column(name = "d_src_prod")
    private String srcProd;// источник данных Промышленный полигон
    @Column(name = "d_src_test")
    private String srcTest;// источник данных Test полигон
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
    private String downTime;//Время простоя системыinstall_prod
    @Column(name = "id_prog")
    private String idProg;//id программиста
    @Column (name = "id_tech")
    private String idTech;//id технолога
    @Column(name = "phone_tech")
    private String phoneTech;//телефон технолога
    @Column (name = "phone_prog")
    private String phoneProg;//телефон программиста
    @Column(name = "id_adm")
    private String idAdm;//id администратора
    @Column(name = "phone_adm")
    private String phoneAdm;// телефон администратора
    @Column(name = "fzFTest")
    private String fzFTest;// ответсвенный от функц. заказчика
    @Column(name = "phoneFZFTest")
    private String phoneFZFTest;//номер ответсвенного от функц. заказчика
    @Column(name = "idCard")
    private Integer idCard;
    @Column(name = "synchronization")
    private String synchronization;//Методика проверки функций Тест
    @Column(name = "date_install_test")
    private Date dateInstallTest;//технология отката
    @Column (name = "time_install_test")
    private String timeInstallTest;//ответсвенный контакт
    @Column (name = "id_contact_test")
    private String idContactTest;//остановка системы 0-нет.1-да.
    @Column (name = "phone_contact_test")
    private String phoneContactTest;//Время простоя системыinstall_prod
    @Column(name = "data_source_test")
    private String dataSourceTest;//id программиста
    @Column (name = "period_test")
    private String periodTest;//id технолога
    @Column(name = "results_test")
    private String resultsTest;//телефон технолога
    @Column (name = "results_test_conclusion")
    private String resultsTestConclusion;//телефон программиста
    @Column(name = "fz_project")
    private String fzProject;//id администратора
    @Column(name = "id_cts_otv")
    private String idCTSOtv;// телефон администратора
    @Column(name = "data_source_prod")
    private String dataSourceProd;// ответсвенный от функц. заказчика
    @Column(name = "date_install_prod")
    private Date dateInstallProd;//номер ответсвенного от функц. заказчика
    @Column(name = "id_delegate")
    private String idDelegate;
    @Column(name = "phone_cts_otv")
    private String phoneCTSOtv;
    @Column(name = "time_install_prod")
    private String timeInstallProd;
    @Column(name = "phone_deligate")
    private String phoneDeligate;
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
                ", srcProd='" + srcProd + '\'' +
                ", srcTest='" + srcTest + '\'' +
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
                ", synchronization='" + synchronization + '\'' +
                ", dateInstallTest='" + dateInstallTest + '\'' +
                ", timeInstallTest='" + timeInstallTest + '\'' +
                ", idContactTest='" + idContactTest + '\'' +
                ", phoneContactTest='" + phoneContactTest + '\'' +
                ", dataSourceTest='" + dataSourceTest + '\'' +
                ", periodTest=" + periodTest +
                ", resultsTest='" + resultsTest + '\'' +
                ", resultsTestConclusion=" + resultsTestConclusion +
                ", fzProject=" + fzProject +
                ", idCTSOtv='" + idCTSOtv + '\'' +
                ", dataSourceProd='" + dataSourceProd + '\'' +
                ", dateInstallProd=" + dateInstallProd +
                ", idDelegate='" + idDelegate + '\'' +
                ", phoneCTSOtv='" + phoneCTSOtv + '\'' +
                ", timeInstallProd='" + timeInstallProd + '\'' +
                ", phoneDeligate='" + phoneDeligate + '\'' +

                '}';
    }
}
