package ru.sbp.bankfinancialprocessingsystem.dao.entity;

import ru.sbp.bankfinancialprocessingsystem.dao.repositories.TransactionsCardsRepository;

import javax.persistence.*;
import java.sql.Date;

/**
 * Класс TransactionsCards - POJO-класс (Plain Old Java Object) таблицы transactions_cards
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 * @see TransactionsCardsRepository#Object()
 */
@Entity
@Table(name = "transactions_cards", schema = "public", catalog = "backofficedb")
public class TransactionsCards {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "number_account")
    private String numberAccount;
    @Basic
    @Column(name = "date_transaction")
    private Date dateTransaction;
    @Basic
    @Column(name = "operation_type")
    private String operationType;
    @Basic
    @Column(name = "sum_transaction")
    private Double sumTransaction;
    @Basic
    @Column(name = "currency_type")
    private String currencyType;
    @Basic
    @Column(name = "terminal_id")
    private String terminalId;
    @Basic
    @Column(name = "code_authorization")
    private String codeAuthorization;
    @Basic
    @Column(name = "card_number")
    private String cardNumber;

    /**
     * Конструктор класса
     */
    public TransactionsCards() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - long id
     * @param - String numberAccount
     * @param - Date dateTransaction
     * @param - String operationType
     * @param - Double sumTransaction
     * @param - String currencyType
     * @param - String terminalId
     * @param - String codeAuthorization
     * @param - String cardNumber
     */
    public TransactionsCards(long id, String numberAccount, Date dateTransaction, String operationType, Double sumTransaction, String currencyType, String terminalId, String codeAuthorization, String cardNumber) {
        this.id = id;
        this.numberAccount = numberAccount;
        this.dateTransaction = dateTransaction;
        this.operationType = operationType;
        this.sumTransaction = sumTransaction;
        this.currencyType = currencyType;
        this.terminalId = terminalId;
        this.codeAuthorization = codeAuthorization;
        this.cardNumber = cardNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberAccount() {
        return numberAccount;
    }

    public void setNumberAccount(String numberAccount) {
        this.numberAccount = numberAccount;
    }

    public Date getDateTransaction() {
        return dateTransaction;
    }

    public void setDateTransaction(Date dateTransaction) {
        this.dateTransaction = dateTransaction;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Double getSumTransaction() {
        return sumTransaction;
    }

    public void setSumTransaction(Double sumTransaction) {
        this.sumTransaction = sumTransaction;
    }

    public String getCurrencyType() {
        return currencyType;
    }

    public void setCurrencyType(String currencyType) {
        this.currencyType = currencyType;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getCodeAuthorization() {
        return codeAuthorization;
    }

    public void setCodeAuthorization(String codeAuthorization) {
        this.codeAuthorization = codeAuthorization;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TransactionsCards that = (TransactionsCards) o;

        if (id != that.id) return false;
        if (numberAccount != null ? !numberAccount.equals(that.numberAccount) : that.numberAccount != null)
            return false;
        if (dateTransaction != null ? !dateTransaction.equals(that.dateTransaction) : that.dateTransaction != null)
            return false;
        if (operationType != null ? !operationType.equals(that.operationType) : that.operationType != null)
            return false;
        if (sumTransaction != null ? !sumTransaction.equals(that.sumTransaction) : that.sumTransaction != null)
            return false;
        if (currencyType != null ? !currencyType.equals(that.currencyType) : that.currencyType != null) return false;
        if (terminalId != null ? !terminalId.equals(that.terminalId) : that.terminalId != null) return false;
        if (codeAuthorization != null ? !codeAuthorization.equals(that.codeAuthorization) : that.codeAuthorization != null)
            return false;
        if (cardNumber != null ? !cardNumber.equals(that.cardNumber) : that.cardNumber != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (numberAccount != null ? numberAccount.hashCode() : 0);
        result = 31 * result + (dateTransaction != null ? dateTransaction.hashCode() : 0);
        result = 31 * result + (operationType != null ? operationType.hashCode() : 0);
        result = 31 * result + (sumTransaction != null ? sumTransaction.hashCode() : 0);
        result = 31 * result + (currencyType != null ? currencyType.hashCode() : 0);
        result = 31 * result + (terminalId != null ? terminalId.hashCode() : 0);
        result = 31 * result + (codeAuthorization != null ? codeAuthorization.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TransactionsCards{" +
                "id=" + id +
                ", numberAccount='" + numberAccount + '\'' +
                ", dateTransaction=" + dateTransaction +
                ", operationType='" + operationType + '\'' +
                ", sumTransaction=" + sumTransaction +
                ", currencyType='" + currencyType + '\'' +
                ", terminalId='" + terminalId + '\'' +
                ", codeAuthorization='" + codeAuthorization + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                '}';
    }
}
