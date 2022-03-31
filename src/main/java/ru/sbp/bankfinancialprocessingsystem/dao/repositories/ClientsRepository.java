package ru.sbp.bankfinancialprocessingsystem.dao.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Clients;

/**
 * Интерфейс ClientsRepository для реализации методов CrudRepository
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see Clients#Object()
 */
@Repository
public interface ClientsRepository extends CrudRepository<Clients, String> {

}


