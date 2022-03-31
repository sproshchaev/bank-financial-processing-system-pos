package ru.sbp.bankfinancialprocessingsystem.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Cards;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Transactions;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.TransactionsCards;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Класс ServerController содержит методы реализации REST-контроллера
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
@RestController
@RequestMapping("/bank")
public class ServerController {

    private static final Logger logger = LoggerFactory.getLogger(ServerController.class);

    @Value("${appName}")
    private String appName;

    @Value("${dbType}")
    private String dbType;

    @Autowired
    private GlobalUserRepository globalUserRepository;

    @Autowired
    private BankDataRepository bankDataRepository;

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private TransactionsRepository transactionsRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private TransactionsCardsRepository transactionsCardsRepository;

    /**
     * Метод index выполняет тестирование сервисов Сервера
     * GET http://localhost:8080/bank/test
     *
     * @return - String информационная строка
     */
    @RequestMapping("/test")
    public String index() {

        String responseString = appName + "<br>" + " DBMS=" + dbType + "<br>"
                + "Our development team: sproshchaev@gmail.com, evgenusn@gmail.com, vasiljevserj777@gmail.com, " +
                "clame023@gmail.com, konstfilin1962@gmail.com" + "<br>" + "Сurrent date and time: "
                + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()) + "<br>";

        logger.info("1) Test globalUserRepository.existsById(\"admin\")=" + globalUserRepository.existsById("admin"));
        responseString = responseString + "1) Test globalUserRepository=" + globalUserRepository.existsById("admin") + ", <br>";

        logger.info("2) Test bankDataRepository.existsById(1)=" + bankDataRepository.existsById(1));
        responseString = responseString + "2) Test bankDataRepository.existsById(1)=" + bankDataRepository.existsById(1) + ", <br>";

        logger.info("3) Test bankDataRepository.count()=" + clientsRepository.count());
        responseString = responseString + "3) Test bankDataRepository.count()=" + clientsRepository.count() + ", <br>";

        logger.info("4) Test accountsRepository.count()=" + accountsRepository.count());
        responseString = responseString + "4) Test accountsRepository.count()=" + accountsRepository.count() + ", <br>";

        responseString = responseString + "4.1) Test accountsRepository.findAccountsByNumberAccount()=" + accountsRepository.findAccountsByNumberAccount("12345678901234567890") + ", <br>";

        responseString = responseString + "4.2) getAccount(4000000000000002)=" + getAccount("4000000000000002");

        logger.info("5) Test transactionsRepository.count()=" + transactionsRepository.count());
        responseString = responseString + "5) Test transactionsRepository.count()=" + transactionsRepository.count() + ", <br>";

        List<Transactions> transactions = new ArrayList<>((Collection) transactionsRepository.findAll());
        responseString = responseString + "5.1) TransactionsRepository: <br>" + transactions.toString() + ", <br>";

        logger.info("6) Test cardsRepository.count()=" + cardsRepository.count());
        responseString = responseString + "6) Test cardsRepository.count()=" + cardsRepository.count() + ", <br>";

        responseString = responseString + "6.1) " + cardsRepository.findCardsByCardNumber("4000000000000002").toString() + ", <br>";

        logger.info("7) Test transactionsCardsRepository.count()=" + transactionsCardsRepository.count());
        responseString = responseString + "7) Test transactionsCardsRepository.count()=" + transactionsCardsRepository.count() + ", <br>";

        List<TransactionsCards> transactionsCards = new ArrayList<>((Collection) transactionsCardsRepository.findAll());
        responseString = responseString + "7.1) TransactionsCardsRepository: <br>" + transactionsCards.toString() + ". <br>";

        return responseString;
    }

    /**
     * Метод getAccount возвращает номер лицевого счета 20 знаков из таблицы accounts
     *
     * @param cardNumber - номер банковской карты
     * @return - String лицевой счет банковской карты 20 знаков
     */
    public String getAccount(String cardNumber) {

        List<Cards> cards = new ArrayList();

        cards = cardsRepository.findCardsByCardNumber(cardNumber);

        return cards.get(0).getNumberAccount();
    }


}
