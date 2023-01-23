package v2.Service;



import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import v2.domain.CardV2;
import v2.model.request.CreateCardRequest;
import v2.model.response.CardResponse;
import v2.repository.CardRepository;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardsRepository;
    private final CardRepository cardRepository;

    //Получаем весь список пользователей
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public List<CardResponse> findAll() {
      return  cardsRepository.findAll()
                .stream()
                .map(this::buildCardResponse)
                .collect(Collectors.toList());
    }

    //Получаем пользователя по id
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public CardResponse findById(@NotNull Integer idCards) {
        return cardsRepository.findById(idCards)
                .map(this::buildCardResponse)
                .orElseThrow(() -> new EntityNotFoundException("Card " + idCards + " is not found"));
    }
    @NotNull
    @Override
    @Transactional(readOnly = true)
    public CardResponse findByUser(@NotNull Integer idCards) {
        return cardsRepository.findById(idCards)
                .map(this::buildCardResponse)
                .orElseThrow(() -> new EntityNotFoundException("Card " + idCards + " is not found"));
    }

    //Создаем пользователя
    @NotNull
    @Override
    @Transactional
    public CardResponse createCard(CreateCardRequest request) {
        CardV2 cardV2 = buildCardRequest(request);
        System.out.println(cardV2);
        //     System.out.println("fghjk");
       /// System.out.println(request);
        CardV2 cardV21 = cardsRepository.save(cardV2);
        CardResponse cardResponse = buildCardResponse(cardV21);
        return cardResponse;
    }

    //Обновляем пользователя по id
    @NotNull
    @Override
    @Transactional
    public CardResponse update(@NotNull Integer IdCard, @NotNull CreateCardRequest request) {
       CardV2 cards =  cardsRepository.findById(IdCard)
                .orElseThrow(() -> new EntityNotFoundException("Card " + IdCard + " is not found"));
        CardV2 cv = buildCardRequest(request);
        return buildCardResponse(cardsRepository.save(cards));
    }


    //Удаляем пользователя по id
    @Override
    @Transactional
    public void delete(@NotNull Integer IdCard) {
        cardsRepository.deleteById(IdCard);
    }


    @Transactional
    @Override
    public List<CardV2> search(String keyword) {
        return null;
    }

    @NotNull
    private CardResponse buildCardResponse(@NotNull CardV2 cards) {
      //  System.out.println(cards.getStatus());
        return CardResponse.builder()
                .idCards(cards.getIdCards())
                .links(cards.getLinks())
                .idOtv(cards.getIdOtv())
                .sendLetter(cards.getSendLetter())
                .system(cards.getSystem())
                .numberCard(cards.getNumberCard())
                .dateCorrect(cards.getDateCorrect())
                .dateCreate(cards.getDateCreate())
                .numberLetter(cards.getNumberLetter())
                .status(cards.getStatus())
                .build();


    }

    @NotNull
    private CardV2 buildCardRequest(@NotNull CreateCardRequest request) {
        return CardV2.builder()
                .idCards(request.getIdCards())
                .links(request.getLinks())
                .idOtv(request.getIdOtv())
                .sendLetter(request.getSendLetter())
                .system(request.getSystem())
                .numberCard(request.getNumberCard())
                .dateCorrect(request.getDateCorrect())
                .dateCreate(request.getDateCreate())
                .numberLetter(request.getNumberLetter())
                .status(request.getStatus())
                .build();

    }



}
