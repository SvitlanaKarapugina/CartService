package com.griddynamics.gridu.spring.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WebController {

  /*  @Autowired
    private CartServiceRepository repository;

    @ModelAttribute("phoneBook")
    public Cart preparePhoneBookModel() {
        return new Cart();
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showAll(ModelMap model) {
        Map<String, Set<String>> myMap = repository.findAll();
        model.put("myMap", myMap);
        return "home";
    }

    @SneakyThrows
    @RequestMapping(value = "/contact/{id}", method = RequestMethod.GET)
    public String showContactInfoByName(@PathVariable String id, ModelMap model) {
        Set<String> myMap = repository.findAllPhonesByName(id);
        model.put("listOfPhoneNumbers", myMap);
        model.put("name", id);
        return "userInfo";
    }

    @RequestMapping(value = {"/addContact"}, method = {RequestMethod.GET})
    public String addContact() {
        return "addContact";
    }

    @RequestMapping(value = "/createContact", method = RequestMethod.POST)
    public String createContact(Cart phoneBook) {
        repository.createContact(phoneBook.getName(), phoneBook.getNumber());
        return "redirect:/";
    }

    @RequestMapping(value = "/addPhone/{id}", method = RequestMethod.POST)
    public String addPhone(@PathVariable String id, Cart phoneBook) {
        repository.createContact(id, phoneBook.getNumber());
        return "redirect:/";
    }

    @RequestMapping(value = "/deletePhoneNumber/{phone}", method = RequestMethod.DELETE)
    public String deletePhoneNumber(@PathVariable String phone) {
        repository.removePhone(phone);
        return "redirect:/";
    }

    @RequestMapping(value = "/deleteContact/{id}", method = RequestMethod.DELETE)
    public String deleteContact(@PathVariable String id){
        repository.removeContact(id);
        return "redirect:/";
    }*/
}
