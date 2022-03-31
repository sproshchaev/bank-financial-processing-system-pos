package ru.sbp.bankfinancialprocessingsystem.pos;

/**
 * Класс ResponseCardAuthorization содержит методы обработки кодов ответов при оплате картами Visa и MasterCard
 * https://how-helper.ru/kody-otvetov-visa-mastercard/
 *
 * @version 1.0
 * @autor Sergey Proshchaev
 */

public class ResponseCardAuthorization {

    private String errorCode;
    private String errorDescription;
    private String authorizationCode;

    /**
     * Конструктор класса
     */
    public ResponseCardAuthorization() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String errorCode
     * @param - String errorDescription
     * @param - String authorizationCode
     */

    public ResponseCardAuthorization(String errorCode, String errorDescription, String authorizationCode) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
        this.authorizationCode = authorizationCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode;
    }

    @Override
    public String toString() {
        return "ResponseCardAuthorization{" +
                "errorCode='" + errorCode + '\'' +
                ", errorDescription='" + errorDescription + '\'' +
                ", authorizationCode='" + authorizationCode + '\'' +
                '}';
    }
}
