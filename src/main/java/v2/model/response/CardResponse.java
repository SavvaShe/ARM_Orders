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
public class CardResponse {
    //Функция предназначена для обертки данных из БД и последующему взаимодействию с ними
    private Integer idCards;//id
    private String idOtv;//Ответсвенный
    private String numberCard;//Номер карточки
    private String numberLetter;//номер Письма
    private String system;//подсистема
    private Date dateCorrect;//дата корректировки карточки
    private Date dateCreate;//дата создания
    private Date sendLetter;//дата отправки письма
    private String links;//ссылка на письмо
    private String status;

}
