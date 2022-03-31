package ru.sbp.bankfinancialprocessingsystem.pos;

import java.util.Date;

/**
 * Класс Payment содержит методы работы с платежами по банковским картам
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */

public class Payment {

    private String cardNumber;
    private String cardDateExp;
    private Date dateOperation;
    private double summaTrans;
    private String operationType;

    /**
     * Конструктор класса
     */
    public Payment() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String cardNumber
     * @param - String cardDateExp
     * @param - Date dateOperation
     * @param - double summaTrans
     * @param - String operationType
     */

    public Payment(String cardNumber, String cardDateExp, Date dateOperation, double summaTrans, String operationType) {
        this.cardNumber = cardNumber;
        this.cardDateExp = cardDateExp;
        this.dateOperation = dateOperation;
        this.summaTrans = summaTrans;
        this.operationType = operationType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardDateExp() {
        return cardDateExp;
    }

    public void setCardDateExp(String cardDateExp) {
        this.cardDateExp = cardDateExp;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getSummaTrans() {
        return summaTrans;
    }

    public void setSummaTrans(double summaTrans) {
        this.summaTrans = summaTrans;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardDateExp='" + cardDateExp + '\'' +
                ", dateOperation=" + dateOperation +
                ", summaTrans=" + summaTrans +
                ", operationType='" + operationType + '\'' +
                '}';
    }
}

