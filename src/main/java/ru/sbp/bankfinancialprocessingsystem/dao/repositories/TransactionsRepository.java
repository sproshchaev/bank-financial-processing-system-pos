package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;

/**
 * Интерфейс TransactionsRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Transactions#Object()
 */
@Repository
public interface TransactionsRepository extends CrudRepository<Transactions, Integer> {

}
