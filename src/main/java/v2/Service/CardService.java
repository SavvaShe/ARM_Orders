package v2.Service;



import org.jetbrains.annotations.NotNull;

import v2.domain.CardV2;
import v2.model.request.CreateCardRequest;
import v2.model.response.CardResponse;

import java.util.List;

public interface CardService {

    @NotNull
    List<CardResponse> findAll();

    @NotNull
    CardResponse findById(@NotNull Integer idCard);

    @NotNull
    CardResponse createCard(@NotNull CreateCardRequest request);

    @NotNull
    CardResponse update(@NotNull Integer idCard, @NotNull CreateCardRequest  request);

    void delete(@NotNull Integer idCard);

    List<CardV2> search(String keyword);
}


