package ru.sbp.bankfinancialprocessingsystem.controllers;


import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Accounts;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.Cards;
import ru.sbp.bankfinancialprocessingsystem.dao.entity.TransactionsCards;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.AccountsRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.CardsRepository;
import ru.sbp.bankfinancialprocessingsystem.dao.repositories.TransactionsCardsRepository;
import ru.sbp.bankfinancialprocessingsystem.pos.Payment;
import ru.sbp.bankfinancialprocessingsystem.pos.ResponseCardAuthorization;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static ru.sbp.bankfinancialprocessingsystem.service.GenAuthorizationCode.genAuthorizationCode;

/**
 * Класс PosController содержит методы реализующие функционал обработки запросов на соверщение операций по банковским картам
 * от торговой точки (POS - point of sale)
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */
@Controller
@RequestMapping(value = "/pos")
public class PosController {

    private static final Logger logger = LoggerFactory.getLogger(PosController.class);

    @Value("${terminalid}")
    private String terminalId;

    @Value("${address}")
    private String address;

    @Value("${posname}")
    private String posName;

    @Value("${updatebalanceinaccounts}")
    private String updateBalanceInAccounts;

    @Autowired
    private AccountsRepository accountsRepository;

    @Autowired
    private CardsRepository cardsRepository;

    @Autowired
    private TransactionsCardsRepository transactionsCardsRepository;

    /**
     * Метод info реализует обработку вызова GET по адресу http://localhost:8080/pos
     *
     * @return - ModelAndView
     */
    @GetMapping
    public ModelAndView info() {
        ModelAndView modelAndView = new ModelAndView("/views/pos_info.jsp");
        modelAndView.addObject("tid", terminalId);
        modelAndView.addObject("sale_name", posName);
        modelAndView.addObject("address", address);
        modelAndView.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        return modelAndView;
    }

    /**
     * Метод adminPage реализует обработку вызова GET по адресу http://localhost:8080/pos/admin
     *
     * @return - ModelAndView
     */
    @GetMapping(value = "/admin")
    public ModelAndView adminPage() {
        ModelAndView paymentCardView = new ModelAndView("/views/pos_admin.jsp");
        return paymentCardView;
    }

    /**
     * Метод paymentCard реализует обработку вызова GET по адресу http://localhost:8080/pos/pay
     *
     * @return - ModelAndView
     */
    @GetMapping(value = "/pay")
    public ModelAndView paymentCard(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView paymentCardView = new ModelAndView("/views/pos_pay_card.jsp");
        return paymentCardView;
    }

    /**
     * Метод createTransaction реализует обработку вызова POST "createtrans" из "/views/pos_pay_card.jsp"
     *
     * @return - ModelAndView
     */
    @PostMapping(value = "/createtrans")
    public ModelAndView createTransaction(HttpServletRequest request, HttpServletResponse response,
                                          @RequestParam("card") String cardNumber,
                                          @RequestParam("dateexp") String dateExp,
                                          @RequestParam("summa") String summa) {

        logger.info("Авторизация: " + cardNumber + " " + dateExp + " " + summa + " RUB");

        java.sql.Date dateSqlFormat = new java.sql.Date(new java.util.Date().getTime());

        Payment payment = new Payment(cardNumber, dateExp, new java.sql.Date(new java.util.Date().getTime()), Double.valueOf(summa), "Payment");

        ResponseCardAuthorization responseCardAuthorization = doCardAuthorization(payment);

        ModelAndView authorizationResult = new ModelAndView("/views/pos_auth_result.jsp");
        authorizationResult.addObject("tid", terminalId);
        authorizationResult.addObject("sale_name", posName);
        authorizationResult.addObject("address", address);
        authorizationResult.addObject("dateAndTime", dateSqlFormat.toString());
        authorizationResult.addObject("codeAutor", responseCardAuthorization.getAuthorizationCode());
        authorizationResult.addObject("responseCardAuthorization", responseCardAuthorization.getErrorCode() + " " + responseCardAuthorization.getErrorDescription());

        return authorizationResult;
    }

    /**
     * Метод createRefund реализует обработку вызова POST "createrefund" из "/views/pos_admin.jsp"
     *
     * @return - ModelAndView
     */
    @PostMapping(value = "/createrefund")
    public ModelAndView createRefund(HttpServletRequest request, HttpServletResponse response,
                                     @RequestParam("card") String cardNumber,
                                     @RequestParam("dateexp") String dateExp,
                                     @RequestParam("summa") String summa) {

        logger.info("Возврат: " + cardNumber + " " + dateExp + " " + summa + "RUB");

        java.sql.Date dateSqlFormat = new java.sql.Date(new java.util.Date().getTime());

        Payment payment = new Payment(cardNumber, dateExp, new java.sql.Date(new java.util.Date().getTime()), Double.valueOf(summa), "Refund");

        ResponseCardAuthorization responseCardAuthorization = doCardAuthorization(payment);

        ModelAndView authorizationResult = new ModelAndView("/views/pos_auth_result.jsp");
        authorizationResult.addObject("tid", terminalId);
        authorizationResult.addObject("sale_name", posName);
        authorizationResult.addObject("address", address);
        authorizationResult.addObject("dateAndTime", dateSqlFormat.toString());
        authorizationResult.addObject("codeAutor", responseCardAuthorization.getAuthorizationCode());
        authorizationResult.addObject("responseCardAuthorization", responseCardAuthorization.getErrorCode() + " " + responseCardAuthorization.getErrorDescription());

        return authorizationResult;
    }

    /**
     * Метод createStatement реализует обработку вызова POST "createstatement" из "/views/pos_admin.jsp"
     * выписка с операциями сохраняется в формате файла MS Excel (.xlsx)
     *
     * @return - ModelAndView
     */
    @PostMapping(value = "/createstatement")
    public ModelAndView createStatement(HttpServletRequest request, HttpServletResponse response,
                                        @RequestParam("datebegin") String dateBegin,
                                        @RequestParam("dateend") String dateEnd) {

        logger.info("Выписка по операциям с : " + dateBegin + " " + dateEnd);

        List<TransactionsCards> transactionsCards = new ArrayList<>();
        transactionsCards = transactionsCardsRepository.findByTerminalId(terminalId);

        String fileOutStr = "pos" + terminalId + ".xlsx";
        logger.info("Создание файла с отчетом " + fileOutStr + "...");

        try {

            XSSFWorkbook myExcelBookOut = new XSSFWorkbook();
            FileOutputStream fileOut = new FileOutputStream(fileOutStr);
            XSSFSheet sheetOut = myExcelBookOut.createSheet("Лист1");

            creatingHeaderInReport(sheetOut, terminalId, address, posName);

            for (int i = 4; i < transactionsCards.size(); i++) {
                writeToCell(sheetOut, i, 0, transactionsCards.get(i).getDateTransaction().toString(), 4);
                writeToCell(sheetOut, i, 1, transactionsCards.get(i).getSumTransaction().toString(), 4);
                writeToCell(sheetOut, i, 2, "RUB", 4);
            }

            myExcelBookOut.write(fileOut);
            fileOut.close();
            logger.info("Файл с отчетом " + fileOutStr + " создан.");

        } catch (IOException ex) {
            ex.printStackTrace();
            logger.error("Error " + ex);
        }

        ModelAndView statementResult = new ModelAndView("/views/pos_statement_result.jsp");
        statementResult.addObject("tid", terminalId);
        statementResult.addObject("sale_name", posName);
        statementResult.addObject("address", address);
        statementResult.addObject("dateAndTime", new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()));
        statementResult.addObject("dateBegin", dateBegin);
        statementResult.addObject("dateEnd", dateEnd);
        statementResult.addObject("fileOutStr", fileOutStr);

        return statementResult;
    }


    /**
     * Метод cardNumberExists проверяет существование банковской карты с номером в таблице cards
     *
     * @param cardNumber - номер банковской карты
     * @return - boolean, true - если карта с номером существует в таблице cards
     */
    private boolean cardNumberExists(String cardNumber) {
        List<Cards> cards = new ArrayList();
        cards = cardsRepository.findCardsByCardNumber(cardNumber);
        if (cards.size() == 0) {
            return false;
        } else {
            return true;
        }

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

        if (cards.size() == 0) {
            return "";
        } else {
            return cards.get(0).getNumberAccount();
        }

    }

    /**
     * Метод getBalance возвращает баланс по карте из таблицы accounts
     *
     * @param cardNumber - номер банковской карты
     * @return - Double баланс по счету карты
     */
    private Double getBalance(String cardNumber) {

        String numberAccount = getAccount(cardNumber);

        List<Accounts> accounts = new ArrayList<>();

        accounts = accountsRepository.findAccountsByNumberAccount(numberAccount);

        if (accounts.size() == 0) {
            return 0.00;
        } else {
            return accounts.get(0).getBalance();
        }

    }

    /**
     * Метод getBalanceTransactions возвращает расчетный баланс по карте из таблицы TransactionsCards
     *
     * @param cardNumber - номер банковской карты
     * @return - Double баланс по счету карты
     */
    private Double getBalanceTransactions(String cardNumber) {

        List<TransactionsCards> transactionsCards = new ArrayList<>();

        transactionsCards = transactionsCardsRepository.findByCardNumber(cardNumber);

        if (transactionsCards.size() == 0) {
            return 0.00;
        } else {
            Double balanceTransactions = 0.0;
            for (int i = 0; i < transactionsCards.size(); i++) {
                balanceTransactions = balanceTransactions + (plusOrMinus(transactionsCards.get(i).getOperationType()) * transactionsCards.get(i).getSumTransaction());
            }
            return balanceTransactions;
        }

    }

    /**
     * Метод plusOrMinus возвращает арифметический знак операции по типу операции
     *
     * @param operationType тип операции: CashIn (+), CashOut (-), Payment (-), MoneyTransferIn (+), MoneyTransferOut (-), Refund (+)
     * @return - Double -1 для расходных операций по счету, 1 для приходных операций по счету
     */
    private Double plusOrMinus(String operationType) {

        Double resultPlusOrMinus = 0.0;

        switch (operationType) {
            case "CashIn":
                resultPlusOrMinus = 1.0;
                break;
            case "CashOut":
                resultPlusOrMinus = -1.0;
                break;
            case "Payment":
                resultPlusOrMinus = -1.0;
                break;
            case "MoneyTransferIn":
                resultPlusOrMinus = 1.0;
                break;
            case "MoneyTransferOut":
                resultPlusOrMinus = -1.0;
                break;
            case "Refund":
                resultPlusOrMinus = 1.0;
                break;

        }
        return resultPlusOrMinus;
    }


    /**
     * Метод getDateExp возвращает срок действия банковской карты из таблицы cards
     *
     * @param cardNumber - номер карты
     * @return - String срок действия YYYY-MM-DD
     */
    private String getDateExp(String cardNumber) {

        List<Cards> cards = new ArrayList();

        cards = cardsRepository.findCardsByCardNumber(cardNumber);

        if (cards.size() == 0) {
            return "";
        } else {
            return cards.get(0).getExpirationDate().toString();
        }

    }


    /**
     * Метод dateToDateExp возвращает срок действия банковской карты в формате MMYY
     *
     * @param dateExpCard срок действия карты в формате YYYY-MM-DD
     * @return - String срок действия в формате MMYY
     */
    private String dateToDateExp(String dateExpCard) {
        String str = dateExpCard;
        return dateExpCard.substring(5, 7) + dateExpCard.substring(2, 4);
    }

    /**
     * Метод dateExpToDate возвращает срок действия банковской карты в формате YYYY-MM-DD
     *
     * @param dateExp срок действия карты в формате MMYY
     * @return - Date срок действия карты
     */
    private Date dateExpToDate(String dateExp) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.applyPattern("dd.mm.yyyy");
        Date date = format.parse("01." + dateExp.substring(1, 2) + ".20" + dateExp.substring(3, 4));

        return date;
    }

    /**
     * Метод getCardStatus возвращает статус банковской карты из таблицы cards
     *
     * @param cardNumber
     * @return - статус карты
     */
    private String getCardStatus(String cardNumber) {

        List<Cards> cards = new ArrayList();

        cards = cardsRepository.findCardsByCardNumber(cardNumber);

        if (cards.size() == 0) {
            return "";
        } else {
            if (cards.get(0).getCardStatus() == null) {
                return "";
            } else {
                return cards.get(0).getCardStatus().toString();
            }
        }
    }

    /**
     * Метод doCardAuthorization осуществляет авторизацию платежа по банковской карте
     *
     * @param - Payment
     * @return - ResponseCardAuthorization
     */
    private ResponseCardAuthorization doCardAuthorization(Payment payment) {

        logger.info("doCardAuthorization " + payment.toString());

        boolean stopAuthorization = false;

        ResponseCardAuthorization responseCardAuthorization = new ResponseCardAuthorization("", "", "0");

        logger.info("transactionsCardsRepository.count()=" + transactionsCardsRepository.count());

        String acc = getAccount(payment.getCardNumber());
        Double bal = getBalance(payment.getCardNumber());
        String dateExp = getDateExp(payment.getCardNumber());
        String cardStatus = getCardStatus(payment.getCardNumber());

        logger.info("Проверка номера карты...");
        if (!stopAuthorization) {

            if (!cardNumberExists(payment.getCardNumber())) {
                stopAuthorization = true;
                responseCardAuthorization.setErrorCode("14");
                responseCardAuthorization.setErrorDescription("недействительный номер карты");
                responseCardAuthorization.setAuthorizationCode("0");
            }

        }

        logger.info("Проверка номера карты - есть или нет такая карта (совпадение по сроку в магазине и в базе)...");
        if (!stopAuthorization) {

            if (!payment.getCardDateExp().equals(dateToDateExp(getDateExp(payment.getCardNumber())))) {
                stopAuthorization = true;
                responseCardAuthorization.setErrorCode("14");
                responseCardAuthorization.setErrorDescription("недействительный номер карты (срок)");
                responseCardAuthorization.setAuthorizationCode("0");
            }

        }

        if (!stopAuthorization) {

            logger.info("getBalanceTransactions(payment.getCardNumber())=" + getBalanceTransactions(payment.getCardNumber()));

            if ((payment.getSummaTrans() <= getBalanceTransactions(payment.getCardNumber())) | (payment.getOperationType().equals("Refund"))) {

                String authorizationCode = genAuthorizationCode();

                TransactionsCards transactionsCards = new TransactionsCards();
                transactionsCards.setNumberAccount(getAccount(payment.getCardNumber()));
                transactionsCards.setDateTransaction((java.sql.Date) payment.getDateOperation());
                transactionsCards.setOperationType(payment.getOperationType());
                transactionsCards.setSumTransaction(payment.getSummaTrans());
                transactionsCards.setCurrencyType("RUB");
                transactionsCards.setTerminalId(terminalId);
                transactionsCards.setCodeAuthorization(authorizationCode);
                transactionsCards.setCardNumber(payment.getCardNumber());
                transactionsCardsRepository.save(transactionsCards);

                if (updateBalanceInAccounts.equals("true")) {
                    Accounts account = new Accounts();
                    account = accountsRepository.findAccountsByNumberAccount(acc).get(0);
                    Double newBalance = (account.getBalance() - payment.getSummaTrans());
                    account.setBalance(newBalance);
                    accountsRepository.save(account);
                }

                responseCardAuthorization.setErrorCode("00");
                responseCardAuthorization.setErrorDescription("одобрено и завершено");
                responseCardAuthorization.setAuthorizationCode(authorizationCode);

            } else {
                responseCardAuthorization.setErrorCode("51");
                responseCardAuthorization.setErrorDescription("недостаточно средств на счёте");
                responseCardAuthorization.setAuthorizationCode("0");
            }
        }

        return responseCardAuthorization;

    }

    /**
     * Метод writeToCell записывает значение в ячейку листа MS Excel
     *
     * @param - XSSFSheet excelSheet имя листа
     * @param - int row строка ячейки
     * @param - int column столбец ячейки
     * @param - String value значение, записываемое в ячейку
     * @param - byte valueType типа значения в ячейке: 1 - NUMBER, 2 - DATE, 4 - TEXT
     */
    private static void writeToCell(XSSFSheet excelSheet, int row, int column, String value, int valueType) {

        XSSFRow rowObj;
        XSSFCell cellObj;

        if (excelSheet.getRow(row) == null) {
            rowObj = excelSheet.createRow((short) row);
        } else {
            rowObj = excelSheet.getRow((short) row);
        }

        if (rowObj.getCell(column) == null) {
            cellObj = rowObj.createCell(column);
        } else {
            cellObj = rowObj.getCell(column);
        }

        switch (valueType) {
            case 1:
                cellObj.setCellType(CellFormatType.NUMBER.ordinal());
                cellObj.setCellValue(Double.valueOf(value));
                break;
            case 2:
                cellObj.setCellType(CellFormatType.DATE.ordinal());
                cellObj.setCellValue(value);
                break;
            case 4:
                cellObj.setCellType(CellFormatType.TEXT.ordinal());
                cellObj.setCellValue(value);
                break;
            default:
                cellObj.setCellType(CellFormatType.TEXT.ordinal());
                cellObj.setCellValue(value);
        }
    }

    /**
     * Метод readFromCell читает значение из ячейки листа MS Excel
     *
     * @param - XSSFSheet excelSheet имя листа
     * @param - int row строка ячейки
     * @param - int column столбец ячейки
     * @return - String значение ячейки в текстовом формате
     */
    private static String readFromCell(XSSFSheet excelSheet, int row, int column) {
        String resultReadFromCell = "null";

        XSSFRow rowObj = excelSheet.getRow(row);
        XSSFCell cellObj;

        if (rowObj != null) {
            cellObj = rowObj.getCell(column);
            resultReadFromCell = cellObj.toString();
        }
        return resultReadFromCell;
    }

    /**
     * Метод getLastCellNum возвращает значение последней заполненной ячейки в строке листа MS Excel
     *
     * @param - XSSFSheet excelSheet имя листа
     * @param - int row строка ячейки
     * @return - int значение последней заполненной ячейки в строке row
     */
    private static int getLastCellNum(XSSFSheet excelSheet, int row) {

        if (excelSheet.getRow(row) != null) {
            return excelSheet.getRow(row).getLastCellNum();
        } else {
            return 0;
        }
    }

    /**
     * Метод creatingHeaderInReport формрует заголовки отчета листа MS Excel
     *
     * @param - XSSFSheet excelSheet имя листа
     */
    private static void creatingHeaderInReport(XSSFSheet excelSheet, String terminalId, String address, String posName) {

        writeToCell(excelSheet, 0, 0, "Отчет по операциям оплаты ", 4);
        writeToCell(excelSheet, 1, 0, "Дата отчета " + new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date()), 4);
        writeToCell(excelSheet, 2, 0, "POS " + terminalId + " адрес: " + address + " наименование: " + posName, 4);

        writeToCell(excelSheet, 3, 0, "Дата операции", 4);
        writeToCell(excelSheet, 3, 1, "Сумма операции", 4);
        writeToCell(excelSheet, 3, 2, "Валюта", 4);

    }

}
