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

    //Создаем пользователя
    @NotNull
    @Override
    @Transactional
    public CardResponse createCard(@NotNull CreateCardRequest request) {
        CardV2 cardV2 = buildCardRequest(request);
        CardResponse cardResponse = buildCardResponse(cardsRepository.save(cardV2));
        return cardResponse;
    }

    //Обновляем пользователя по id
    @NotNull
    @Override
    @Transactional
    public CardResponse update(@NotNull Integer IdCard, @NotNull CreateCardRequest request) {
       CardV2 cards =  cardsRepository.findById(IdCard)
                .orElseThrow(() -> new EntityNotFoundException("Card " + IdCard + " is not found"));
        cardUpdate(cards, request);
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
        return new CardResponse()
                .setIdCards(cards.getIdCards())
                .setLinks(cards.getLinks())
                .setIdOtv(cards.getIdOtv())
                .setSendLetter(cards.getSendLetter())
                .setSystem(cards.getSystem())
                .setNumberCard(cards.getNumberCard())
                .setDateCorrect(cards.getDateCorrect())
                .setDateCreate(cards.getDateCreate())
                .setNumberLetter(cards.getNumberLetter());

    }

    @NotNull
    private CardV2 buildCardRequest(@NotNull CreateCardRequest request) {
        return new CardV2()
                .setIdCards(request.getIdCards())
                .setLinks(request.getLinks())
                .setIdOtv(request.getIdOtv())
                .setSendLetter(request.getSendLetter())
                .setSystem(request.getSystem())
                .setNumberCard(request.getNumberCard())
                .setDateCorrect(request.getDateCorrect())
                .setDateCreate(request.getDateCreate())
                .setNumberLetter(request.getNumberLetter());
    }

    private void cardUpdate(@NotNull CardV2 cardV2, @NotNull CreateCardRequest request) {
        ofNullable(request.getNumberCard()).map(cardV2::setNumberCard);
        ofNullable(request.getLinks()).map(cardV2::setLinks);
        ofNullable(request.getIdOtv()).map(cardV2::setIdOtv);
        ofNullable(request.getSendLetter()).map(cardV2::setSendLetter);
        ofNullable(request.getSystem()).map(cardV2::setSystem);
        ofNullable(request.getDateCorrect()).map(cardV2::setDateCorrect);
        ofNullable(request.getDateCreate()).map(cardV2::setDateCreate);
        ofNullable(request.getNumberLetter()).map(cardV2::setNumberLetter);

    }

}
