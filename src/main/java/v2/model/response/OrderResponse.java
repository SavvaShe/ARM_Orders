package v2.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {

    private Integer idOrder;//id Наряда
    private int idOtv;//Ответсвенный
    private int systems;//система
    private String number;//номер
    private Date dateCreate;//дата создания
    private String changeObject;//изменяемый объект
    private int fcAgreement;//требуется согласование с ФЗ
    private String version;//Номер версии изменений
    private String reasons;//Основание
    private String conditions;//Условия выполнения наряда
    //private changeList;
    private String docChange;//Изменения в документации
    private String dSrcProd;// источник данных Промышленный полигон
    private String dSrcTest;// источник данных Test полигон
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
    private int idProg;//id программиста
    private int idTech;//id технолога
    private String phoneTech;//телефон технолога
    private String phoneProg;//телефон программиста
    private int idAdm;//id администратора
    private String phoneAdm;// телефон администратора
    private String fzFTest;// ответсвенный от функц. заказчика
    private String phoneFZFTest;//номер ответсвенного от функц. заказчика

}
