package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.GlobalUser;

/**
 * Интерфейс GlobalUserRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see GlobalUser#GlobalUser()
 */
@Repository
public interface GlobalUserRepository extends CrudRepository<GlobalUser, String> {

}
