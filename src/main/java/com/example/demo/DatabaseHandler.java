package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    // Объявление класса DatabaseHandler, который наследует настройки из класса Configs.

    Connection dbConnection;
    // Объявление переменной dbConnection типа Connection для установки соединения с базой данных.

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        // Метод getDbConnection, который возвращает объект Connection для работы с базой данных,
        // выбрасывает исключения ClassNotFoundException и SQLException при необходимости.

        String connectionString = "jdbc:mysql://" + dbHost + ":"
                + dbPort + "/" + dbName;
        // Формирование строки подключения к базе данных, используя параметры хоста, порта и имени базы данных.

        Class.forName("com.mysql.cj.jdbc.Driver");
        // Загрузка JDBC-драйвера MySQL, необходимого для работы с базой данных.

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);
        // Установка соединения с базой данных, используя строку подключения, а также имя пользователя и пароль.

        return dbConnection;
        // Возвращение объекта Connection, который можно использовать для выполнения SQL-запросов.
    }
}

