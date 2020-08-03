package com.griddynamics.gridu.spring.controller;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/phonebook/contact")
public class RestController {

   /* @Autowired
    private CartService phoneBookService;

    @GetMapping(name = "showAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Set<String>> showAll() {
        return phoneBookService.findAll();
    }

    @GetMapping(name = "showContactInfoByName", path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<String> showContactInfoByName(@PathVariable String name) throws ContactNotFoundException {
        return phoneBookService.findAllPhonesByName(name);
    }

    @PostMapping(name = "createContact", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createContact(@RequestBody Cart contact) {
        phoneBookService.createContact(contact.getName(), contact.getNumber());
    }


    @PutMapping(name = "addPhoneToContact", path = "/{name}/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void addPhoneToContact(@PathVariable String name, @PathVariable String phone) throws ContactNotFoundException {
        phoneBookService.addPhone(name, phone);
    }

    @DeleteMapping(name = "deletePhone", path = "/{name}/{phone}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePhone(@PathVariable String name, @PathVariable String phone) throws ContactNotFoundException {
        phoneBookService.removePhone(phone);
    }

    @DeleteMapping(name = "deleteContact", path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteContact(@PathVariable String name) throws ContactNotFoundException {
        phoneBookService.removeContact(name);
    }*/
}
