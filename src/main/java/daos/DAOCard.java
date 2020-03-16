package daos;

import models.DTO;

import java.util.List;

public interface DAOCard<T> {
    T getCard(String cardNumber);
    List<T> findAll();
    Boolean update(DTO dto);
    Boolean create(DTO dto);
    Boolean delete(String cardNumber);
}
