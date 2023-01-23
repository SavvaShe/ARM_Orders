package v2.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import v2.Service.CardService;
import v2.domain.CardV2;
import v2.model.request.CreateCardRequest;
import v2.model.response.CardResponse;

import java.util.List;

@Controller
@RequestMapping("resources/templates")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    //Получаем весь список карточек
//    @GetMapping(produces = APPLICATION_JSON_VALUE)
//    public List<CardResponse> findAll() {
//        return cardService.findAll();
//    }


    @GetMapping("/card_list")
    public ModelAndView openList() {
        ModelAndView mav = new ModelAndView("cards_list");
        mav.addObject("listCards", findAll());
 //       WebContext ctx = new WebContext();
//        ctx.setVariable("cards_list", cardsList);
   //     System.out.println(findAll())
        return mav;
    }


    @GetMapping("/page_not_found")
    public ModelAndView openPage404() {
        ModelAndView mav = new ModelAndView("page_not_found");
        return mav;
    }

//    @GetMapping("/card_view")
//    public ModelAndView openCardView() {
//        ModelAndView mav = new ModelAndView("card_view");
//        mav.addObject("listCards", findById());
//        //       WebContext ctx = new WebContext();
////        ctx.setVariable("cards_list", cardsList);
//        System.out.println(findById());
//        return mav;
//    }



   // @RequestMapping( value ="card_view", method = {RequestMethod.GET, RequestMethod.PUT}, consumes = MediaType.ALL_VALUE)
    @GetMapping("/card_view/{idCards}")
    public ModelAndView openCardView(/*@RequestParam*/@PathVariable Integer idCards) {
        ModelAndView mav = new ModelAndView("card_view");
        mav.addObject("cardView",cardService.findById(idCards));
        return mav;
    }

    public List<CardResponse> findAll() {
       return cardService.findAll();
    }

//@GetMapping("/card_list")
//  public String openList(Model model) {
//    model.addAttribute("cardsList", findAll());
//    return "cards_list";
//    }




    ////    //Создаем карту
//    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//    public CardResponse create(@RequestBody CreateCardRequest request) {
//        return cardService.createCard(request);
//    }
    @GetMapping("/card_edit")
    public ModelAndView openEditCards() {
        ModelAndView mav = new ModelAndView("card_edit");
        CreateCardRequest cr = new CreateCardRequest();
        mav.addObject("card_edit", cr);
        return mav;
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

    @RequestMapping( value ="/new_card", method =  RequestMethod.POST/*, consumes = MediaType.ALL_VALUE*/)
    public String create(/*@ModelAttribute*/ CreateCardRequest request){
        ModelAndView mav = new ModelAndView("card_edit");
       CardResponse cardResponse =  cardService.createCard(request);

        return "redirect:card_list";
    }

//    @RequestMapping(value = "/new_card", method = RequestMethod.POST)
//    public String createUser(Model model, @ModelAttribute CreateCardRequest card_edit) {
//        System.out.println("Я работаю");
//        @NotNull CreateCardRequest cr = cardService.createCard(card_edit);
//        return "redirect:/card_list";
//    }

//
//
//////    //Обновляем карту по id
//    @PatchMapping(value = "/{IdCard}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
//   public CardResponse update(@PathVariable Integer IdCard, @RequestBody CreateCardRequest request) {
//        return cardService.update(IdCard, request);
//    }
    @PostMapping("/korr_card")
    public String korr(@RequestBody CreateCardRequest request,@RequestParam int idCards){
    cardService.update(idCards,request);
    return "redirect:/cards_list";
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

      @GetMapping("/open_order_list")
    public ModelAndView openOrderList() {
          ModelAndView ol = new ModelAndView("orders_list");
          return ol;
    }
}
