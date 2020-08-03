package com.griddynamics.gridu.cartService.tests;

import com.griddynamics.gridu.spring.CartApplication;
import com.griddynamics.gridu.spring.service.CartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartApplication.class)
public class CartServiceTest {

    @Autowired
    CartService cartService;

    @Test
    public void testGetCartByValidId() {
    cartService.findAll();
    }

    /*@Test
    public void get_person_phone_numbers() {
        final Set<String> expected = new HashSet<>(asList("+79601232233"));
        assertEquals("phone numbers do not match",
                expected,
                phoneBookRepository.findAll().get("Alex"));
    }

    @Test
    public void get_person_name_by_phone_numbers() throws ContactNotFoundException {
        final String expected = "Alex";
        assertEquals("user name does not match with searching phone",
                expected,
                phoneBookRepository.findNameByPhone("+79601232233"));
    }

    @Test
    public void add_phone_for_user() throws ContactNotFoundException {
        final String phoneNumber = "+79609999999";
        final String userName = "Kate";
        phoneBookRepository.createContact(userName, phoneNumber);
        assertTrue("Phone number doesn't add to user info",
                phoneBookRepository.findAllPhonesByName(userName).contains(phoneNumber));
    }

    @Test
    public void remove_phone_for_user() throws ContactNotFoundException {
        final String phoneNumber = "+79213215568";
        final String userName = "Billy";
        phoneBookRepository.removePhone(phoneNumber);
        assertFalse("Phone number doesn't remove",
                phoneBookRepository.findAllPhonesByName(userName).contains(phoneNumber));
    }

    @Test
    public void remove_all_phone_numbers() throws ContactNotFoundException {
        final String phoneNumber = "+79601232233";
        final String userName = "Alex";
        phoneBookRepository.removePhone(phoneNumber);
        assertNull("User is present", phoneBookRepository.findAll().get(userName));
    }*/
}
