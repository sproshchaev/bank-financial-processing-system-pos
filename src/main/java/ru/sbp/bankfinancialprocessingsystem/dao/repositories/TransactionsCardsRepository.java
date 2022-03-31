package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.TransactionsCards;

import java.util.List;

/**
 * Интерфейс TransactionsRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see TransactionsCards#Object()
 */
@Repository
public interface TransactionsCardsRepository extends CrudRepository<TransactionsCards, Integer> {

    List<TransactionsCards> findByTerminalId (String terminalId);

    List<TransactionsCards> findByCardNumber (String cardNumber);

}
