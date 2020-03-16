package daos;

import models.DTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class JDBCTest {
    private DAO dao = new DAO();
    private DTO dto;


    @Test
    public void getCardTest(){
        String expected = dao.getCard("6767977022348089").getFirstName();
        String actual = "Luella";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void findAllTest(){
        List allCards = dao.findAll();
        int actual = 10;
        int expected = allCards.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTest(){
        String actual = "A A RON";
        dto = dao.getCard("6767977022348089");
        dto.setFirstName(actual);
        dao.update(dto);
        String expected = dao.getCard("6767977022348089").getFirstName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTest(){
        String actual = "americanexpress";
        dto = new DTO(actual, null, null, "100", null);
        dao.create(dto);
        String expected = dao.getCard("100").getType();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void deleteTest(){
        String cardNumber = "6767977022348089";
        Assert.assertNotNull(dao.getCard(cardNumber));

        dao.delete(cardNumber);
        Assert.assertNull(dao.getCard(cardNumber));
    }
}
