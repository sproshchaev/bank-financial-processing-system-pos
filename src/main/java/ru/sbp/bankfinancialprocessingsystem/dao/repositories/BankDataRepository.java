package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.BankData;

/**
 * Интерфейс BankDataRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see BankData#BankData()
 */
@Repository
public interface BankDataRepository extends CrudRepository<BankData, Integer> {

}
