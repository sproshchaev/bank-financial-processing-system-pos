package ru.sbp.bankfinancialprocessingsystem.service;

public class PosUserInfo {

    private String login;
    private String password;
    private String name;
    private String role;

    /**
     * Конструктор класса
     */
    public PosUserInfo() {
    }

    /**
     * Конструктор класса с параметрами
     *
     * @param - String login
     * @param - String password
     * @param - String name
     * @param - String role
     */
    public PosUserInfo(String login, String password, String name, String role) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "UserCache{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
