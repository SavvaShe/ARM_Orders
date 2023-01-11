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
@Table(name = "cardpo")
public class CardV2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCards;//id
//
//    @Column(name = "login",nullable = false, unique = true)
//    private String login;// глянуть потом мб зацепиться про проверку прав

    @Column(name = "idotv")
    private int idOtv;//Ответсвенный
    @Column(name = "numbercard")
    private String numberCard;//Номер карточки
    @Column(name = "numberletter")
    private int numberLetter;//номер Письма
    @Column(name = "system")
    private int system;//подсистема
    @Column(name = "datecorrect")
    private Date dateCorrect;//дата корректировки карточки
    @Column(name = "datecreate")
    private Date dateCreate;//дата создания
    @Column(name = "sendletter")
    private Date sendLetter;//дата отправки письма
    @Column(name = "links")
    private String links;//ссылка на письмо

    @Column(name = "status")
    private String status;//ссылка на письмо

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        CardV2 cardV2 = (CardV2) o;
//        return login.equals(cardV2.login);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(login);
//    }


    public String ToString(){

        return "Cards{" +
                "idCards="+idCards+ '\''+ "," +
                " idOtv="+idOtv + '\''+"," +
                "links="+links + '\''+"," +
                "numberCard="+numberCard +"," +
                "numberLetter="+numberLetter + '\''+"," +
                "system="+system + '\''+"," +
                "dateCorrect="+dateCorrect + '\''+"," +
                "dateCreate='"+dateCreate + '\''+"," +
                "sendLetter="+sendLetter +'\''+"}";
    }
}
