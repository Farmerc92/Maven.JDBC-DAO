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
        String expected = dao.getCard("3581107899214500").getFirstName();
        String actual = "Clywd";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void findAllTest(){
        List allCards = dao.findAll();
        int actual = 13;
        int expected = allCards.size();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void updateTest(){
        String actual = "A A RON";
        dto = dao.getCard("3581107899214500");
        dto.setFirstName(actual);
        dao.update(dto);
        String expected = dao.getCard("3581107899214500").getFirstName();

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void createTest(){
        String actual = "americanexpress";
        dto = new DTO(actual, null, null, "100", null);
        dao.create(dto);
        String expected = dao.getCard("100").getType();

        Assert.assertEquals(expected, actual);
        dao.delete("100");
    }

    @Test
    public void deleteTest(){
        dto = new DTO(null, null, null, "20", null);
        dao.create(dto);
        String cardNumber = "20";
        Assert.assertNotNull(dao.getCard(cardNumber));

        dao.delete(cardNumber);
        Assert.assertNull(dao.getCard(cardNumber));
    }
}
