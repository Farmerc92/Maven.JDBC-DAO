package daos;

import models.DTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DAO implements DAOCard{

    public DTO getCard(String cardNumber) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM CARD_DATA WHERE credit_card_number="+cardNumber);
            if (resultSet.next()){
                return extractCardFromResultSet(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<DTO> findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Card_Data");

            List<DTO> cards = new ArrayList<>();

            while (resultSet.next()){
                DTO card = extractCardFromResultSet(resultSet);
                cards.add(card);
            }

            return cards;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Boolean update(DTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Card_Data SET first_name=?, last_name=?, card_type=?, credit_card_number=? WHERE customer_ssn=?");
            preparedStatement.setString(1, dto.getFirstName());
            preparedStatement.setString(2, dto.getLastName());
            preparedStatement.setString(3, dto.getType());
            preparedStatement.setString(4, dto.getCardNumber());
            preparedStatement.setString(5, dto.getSSN());
            int i = preparedStatement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean create(DTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Card_Data VALUES (?,?,?,?,?)");
            preparedStatement.setString(1, dto.getType());
            preparedStatement.setString(2, dto.getFirstName());
            preparedStatement.setString(3, dto.getLastName());
            preparedStatement.setString(4, dto.getCardNumber());
            preparedStatement.setString(5, dto.getSSN());
            int i  = preparedStatement.executeUpdate();
            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Boolean delete(String cardNumber) {
        Connection connection = ConnectionFactory.getConnection();
        try{
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate("DELETE FROM Card_Data WHERE credit_card_number = " + cardNumber);

            if (i == 1){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private DTO extractCardFromResultSet(ResultSet resultSet) throws SQLException {
        DTO card = new DTO();

        card.setSsn(resultSet.getString("customer_ssn"));
        card.setCardNumber(resultSet.getString("credit_card_number"));
        card.setFirstName(resultSet.getString("first_name"));
        card.setLastName(resultSet.getString("last_name"));
        card.setType(resultSet.getString("card_type"));

        return card;
    }
}
