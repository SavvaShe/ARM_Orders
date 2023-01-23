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
    private Integer idCards; //id
    private int idOtv; //Ответсвенный
    private String numberCard; //Номер карточки
    private int numberLetter; //номер Письма
    private int system; //подсистема
    private Date dateCorrect; //Дата корректировки карточки
    private Date dateCreate; //Дата создания
    private Date sendLetter; //Дата отправки письма
    private String links; //Ссылка на письмо
    private String status;

}
