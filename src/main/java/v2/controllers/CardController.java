package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.context.WebContext;
import v2.Service.CardService;
import v2.domain.CardV2;
import v2.model.request.CreateCardRequest;
import v2.model.response.CardResponse;

import java.util.List;

@RestController
@RequestMapping("cards")
@RequiredArgsConstructor
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    //Получаем весь список карточек
//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    public List<CardResponse> findAll() {
//        return cardService.findAll();
//    }
    @GetMapping("/card_list")
    public ModelAndView openList() {
        List<CardResponse> cardsList = cardService.findAll();
        ModelAndView mav = new ModelAndView("card_list");
        mav.addObject("listCards", cardsList);
//        WebContext ctx = new WebContext();
//        ctx.setVariable("cards_list", cardsList);
        return mav;
    }


    ///    //Получаем карточку по id
//    @GetMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public CardResponse findById(@PathVariable Integer IdCard) {
//        return cardService.findById(IdCard);
//    }
    @GetMapping("/card_view")
    public ModelAndView findById(@RequestParam int idCards) {
        ModelAndView mav = new ModelAndView("card_view");
        CardResponse cardResponse = cardService.findById(idCards);
        mav.addObject("cards", cardResponse);
        return mav;
    }


    ////    //Создаем карту
//    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public CardResponse create(@RequestBody CreateCardRequest request) {
//        return cardService.createCard(request);
//    }
    @GetMapping("/edit")
    public String openEditCards() {
        return "cards_edit";
    }

    @GetMapping("/edit_id")
    public ModelAndView openEditWithId(@RequestParam int idCards) {
        ModelAndView mav = new ModelAndView("card_edit");
        CardResponse cardResponse = cardService.findById(idCards);
        mav.addObject("cardskorr", cardResponse);
        return mav;
    }

    //Обработка открытия карточки из card_list
//    @GetMapping("/open_card")
//    public String openViewCard(){
//        cardService.findById();  //ЧТО ПЕРЕДАЕТСЯ?
//        return"card_view";
//    }

    @PostMapping("/new")
    public String create(@RequestBody CreateCardRequest request){
        cardService.createCard(request);
        return "card_view";
    }


//
//
//////    //Обновляем карту по id
//    @PatchMapping(value = "/{IdCard}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//   public CardResponse update(@PathVariable Integer IdCard, @RequestBody CreateCardRequest request) {
//        return cardService.update(IdCard, request);
//    }
    @PostMapping("/korr")
    public String korr(@RequestBody CreateCardRequest request,@RequestParam int idCards){
    cardService.update(idCards,request);
    return "redirect:/card_edit";
}
//////    //Удаляем карту по id
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping(value = "/{IdCard}", produces = APPLICATION_JSON_VALUE)
//    public void delete(@PathVariable Integer IdCard) {
//        cardService.delete(IdCard);
//    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{idCard}")
    public String delete(@RequestParam int idCards) {
        cardService.delete(idCards);
        return "redirect:/card_list";
    }
    public ModelAndView search(@RequestParam String keyword) {
        List<CardV2> result = cardService.search(keyword);
        ModelAndView mav = new ModelAndView("search");
        mav.addObject("result", result);
        return mav;
    }
//    @GetMapping("/card_list")
//    public String openList(Mode0 l model) {
//        model.addAttribute("cardList", cardService.findAll());
//        return "card_list";
//    }
//    @GetMapping("/edit")
//    public String openEditCards(){
//        return "cards_edit";
//    }
}
