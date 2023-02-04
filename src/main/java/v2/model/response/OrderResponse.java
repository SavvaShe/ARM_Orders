package v2.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;
import java.sql.Time;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    //Функция предназначена для обертки данных из БД и последующему взаимодействию с ними
    private Integer idOrders;//id Наряда
    private String idOtv;//Ответсвенный
    private String systems;//система
    private String number;//номер
    private Date dateCreate;//дата создания
    private String changeObject;//изменяемый объект
    private String version;//Номер версии изменений
    private String reasons;//Основание
    private String conditions;//Условия выполнения наряда
    //private changeList;
    private String docChange;//Изменения в документации
    private String srcProd;// источник данных Промышленный полигон
    private String srcTest;// источник данных Test полигон
    private String installTest;//установка на Тест
    private String installProd;//установка на пром
    private String methodTest;//метод проверки Тест
    private String methodProd;//метод проверки Пром
    private String methodProdF;//Методика проверки функций Пром
    private String methodTestF;//Методика проверки функций Тест
    private String rollback;//технология отката
    private String responsibleContact;//ответсвенный контакт
    private int stopSystem;//остановка системы 0-нет.1-да.
    private String downTime;//Время простоя системы
    private String idProg;//id программиста
    private String idTech;//id технолога
    private String phoneTech;//телефон технолога
    private String phoneProg;//телефон программиста
    private String idAdm;//id администратора
    private String phoneAdm;// телефон администратора
    private String fzFTest;// ответсвенный от функц. заказчика
    private String phoneFZFTest;//номер ответсвенного от функц. заказчика
    private Integer idCard;
    private String synchronization;//установка на пром
    private Date dateInstallTest;//метод проверки Тест
    private String timeInstallTest;//метод проверки Пром
    private String idContactTest;//Методика проверки функций Пром
    private String phoneContactTest;//Методика проверки функций Тест
    private String dataSourceTest;//технология отката
    private String periodTest;//ответсвенный контакт
    private String resultsTest;//остановка системы 0-нет.1-да.
    private String resultsTestConclusion;//Время простоя системы
    private String fzProject;//id программиста
    private String idCTSOtv;//id технолога
    private String dataSourceProd;//телефон технолога
    private Date dateInstallProd;//телефон программиста
    private String idDelegate;//id администратора
    private String phoneCTSOtv;
    private String timeInstallProd;
    private String phoneDeligate;


}
