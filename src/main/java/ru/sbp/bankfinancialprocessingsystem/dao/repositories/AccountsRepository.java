package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Accounts;

import java.util.List;

/**
 * Интерфейс AccountsRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Accounts#Object()
 */
@Repository
public interface AccountsRepository extends CrudRepository<Accounts, Integer> {

    List<Accounts> findAccountsByNumberAccount(String numberAccount);


}
