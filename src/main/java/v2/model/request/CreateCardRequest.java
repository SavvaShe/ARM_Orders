package v2.model.request;

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
public class CreateCardRequest {
    //Функция предназначена для обертки занесенных данных пользователем,и последующей транзакции данных в БД
    private Integer idCards; //id
    private String idOtv; //Ответсвенный
    private String numberCard; //Номер карточки
    private String numberLetter; //номер Письма
    private String system; //подсистема
    private Date dateCorrect; //Дата корректировки карточки
    private Date dateCreate; //Дата создания
    private Date sendLetter; //Дата отправки письма
    private String links; //Ссылка на письмо
    private String status;

}
