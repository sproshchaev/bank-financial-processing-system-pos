[![Java](https://img.shields.io/badge/Java-E43222??style=for-the-badge&logo=java&logoColor=FFFFFF)](https://java.com/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-3E6389??style=for-the-badge&logo=PostgreSQL&logoColor=FFFFFF)](https://www.postgresql.org/)
[![Spring](https://img.shields.io/badge/Spring-FFFFFF??style=for-the-badge&logo=Spring)](https://spring.io/)
[![JSP](https://img.shields.io/badge/JSP-FFFFFF??style=for-the-badge&logo=Eclipse&logoColor=2A2252)](https://projects.eclipse.org/projects/ee4j.jsp)
[![Apache](https://img.shields.io/badge/Apache-F7F7F7??style=for-the-badge&logo=Apache&logoColor=C85D38)](https://apache.org/)

# Bank (Financial processing system)
----------------------------------
1. Проект bank-financial-processing-system создан на основе https://start.spring.io 
2. Ссылка на репозиторий bitbucket: bit.ly/3tT6Awd
3. Точка входа BankFinancialProcessingSystemApplication
4. Spring конфигурация в класса ru.sbp.bankfinancialprocessingsystem.config.ServerConfig
5. REST-контроллеры в пакете ru.sbp.bankfinancialprocessingsystem.controllers
6. DAO пакеты ru.sbp.bankfinancialprocessingsystem.dao 
7. Properties-файл resources/app.properties
8. Настроено сквозное логирование в классе ru.sbp.bankfinancialprocessingsystem.aop.ServerLoggerAspect 
9. Логирование с использованием slf4j и logback-classic, конфигурация в resources/logback.xml

### Who do I talk to? ###

* Repo owner or admin: sproshchaev@gmail.com

### Spring Initalizr https://start.spring.io/ ###
https://start.spring.io
Project: Maven Project, Language: Java
Spring Boot: 2.6.4
Project Metadata
- Group: ru.sbp
- Artifact: bank-financial-processing-system
- Name: bank-financial-processing-system
- Description: Bank (Financial processing system)
  Packaging: War
  Java: 8
  Dependencies: Spring Data JPA, Spring Web

### PostgreSQL ###
1. Run SQL Shell (psql): Server [localhost], Database [postgres], Port [5432], Username [postgres], password 12345
2. Set codepage: psql \! chcp1251
3. Databases list: \l

4. Create dump use pg_dump (https://help.sweb.ru/entry/113/)
   Change directory (cd) C:\Program Files\PostgreSQL\14\bin>
   pg_dump -d backofficedb -h localhost -p 5432 -U postgres -F p -f C:\Users\...\Documents\backofficedb
   (password 12345)

5. Restore dump (https://help.sweb.ru/entry/113/)
   Change directory (cd) C:\Program Files\PostgreSQL\14\bin>
   pg_restore -h localhost -U postgres -F p -d backofficedb C:\Users\...\Documents\backofficedb

6. Or use pgadmin https://betacode.net/11913/backup-and-restore-postgres-database-with-pgadmin
   Backup-file: db\backup\pgAdmin\backofficedb.dump

   (*) Для того, чтобы восстановить БД из файла backofficedb.backup необходимо:
   - удалить через pgAdmin БД backofficedb
   - создать через pgAdmin новую БД c именем backofficedb
   - на созданной БД backofficedb выбрать Restore (файл БД, UTF8, postgres)

7. Data type (Типы данных)
- bigserial - первичные ключи
- character varying, Length/Persion XX (соответствует varchar(XX)) - строковые типы данных

8. Таблицы:
1) table global_user
   (
   user_login    varchar(50) not null constraint "GlobalUser_pkey" primary key,
   user_password varchar(50),
   user_role     user_role_type
   )

2) table bank_data ( 
  id                    integer not null constraint bankdata_pkey primary key,
  bic                   varchar(10),
  full_name             varchar(100),
  abbreviated_name      varchar(50),
  license               varchar(100),
  registered_address    varchar(50),
  postal_address        varchar(50),
  correspondent_account varchar(20),
  kpp                   varchar(20),
  inn                   varchar(20),
  ogrn                  varchar(20),
  swift                 varchar(50)
)

3) table clients (
    user_login    varchar(50) not null constraint "UserData_pkey" primary key,
    first_name    varchar(50),
    middle_name   varchar(50),
    last_name     varchar(50),
    birthday      date,
    passport      varchar(100),
    passport_org  varchar(100),
    passport_date date,
    email         varchar(50),
    phone         varchar(50)
    )

4) table accounts (
   number_account varchar(20) not null constraint "Accounts_pkey" primary key,
   user_login     varchar(50),
   account_active boolean,
   date_open      date,
   currency       currency_type,
   balance        double precision,
   account_type   account_type,
   date_close     date
   )

5) table transactions (
   id                 bigserial,             
   number_account     varchar(20),
   date_transaction   date,
   operation_type     operation_type,
   sum_transaction    double precision,
   currency_type      currency_type,
   terminal_id        varchar(20),
   code_authorization varchar(20)
   )

6) table cards (
   card_number      varchar(19) not null constraint "Cards_pkey" primary key,
   number_account   varchar(20),
   expiration_date  date,
   card_holder_name varchar(20),
   payment_system   payment_system_type,
   card_status      card_status_type
   )

7) table transactions_cards (
   id                 bigserial
   number_account     varchar(20),
   date_transaction   date,
   operation_type     varchar(20) CashIn (+), CashOut (-), Payment (-), MoneyTransferIn (+), MoneyTransferOut (-), Refund (+),
   sum_transaction    double precision,
   currency_type      varchar(3) RUB, EUR, USD,
   terminal_id        varchar(20),
   code_authorization varchar(20),
   card_number        varchar(19)
   )

### Функциональная часть ###
I. Функционал микросервиса "Банк-эмитент" (ссылка на репозиторий bitbucket: bit.ly/3tT6Awd):
1. Регистрация пользователей в системе с ролями user, admin
2. Вывод информации по ранее зарегистрированным пользователям
3. Доступ к JSP-страницам всего приложения в зависимости от роли

4. Регистрация нового клиента, ввод персональных данных
5. Операции поиска, изменения, просмотра информации по клиенту
6. Определение прав клиента для доступа к функционалу из «Домашнего банка»

7. Открытие нового счета клиенту: текущий, накопительный, карточный
8. Операции внесения и получения средств со счета (CashIn, CashOut)
9. Формирование выписки по счету клиента

10. Открытие нового карточного продукта клиенту
11. Привязка карточного продукта к счету банковской карты
12. Изменение доступного остатка клиента при совершении операций

II. Функционал микросервиса "POS-эквайринг" реализованного в данном микросервисе: 
13. Авторизация суммы покупки по реквизитам банковской карты
14. Формирование возврата средств при отказе от покупки клиентом
15. Формирование выписки по операциям оплаты в POS (ПСВ)







