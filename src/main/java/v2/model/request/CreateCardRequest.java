package v2.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

import java.sql.Date;

@Data
@Accessors(chain = true)
public class CreateCardRequest {
    private int idCards;//id
    private int idOtv;//Ответсвенный
    private String numberCard;//Номер карточки
    private int numberLetter;//номер Письма
    private int system;//подсистема
    private Date dateCorrect;//дата корректировки карточки
    private Date dateCreate;//дата создания
    private Date sendLetter;//дата отправки письма
    private String links;//ссылка на письмо


}
