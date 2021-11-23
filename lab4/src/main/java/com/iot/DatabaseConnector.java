package com.iot;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {
  private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
  private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/third_lab?useUnicode=true&serverTimezone=UTC";
  private static final String USERNAME = "kasyanka";
  private static final String PASSWORD = "Relax2003";

  private static Connection DATABASE_CONNECTION;

  public DatabaseConnector() {
  }

  public static Connection getConnection() {
    try {
      Class.forName(JDBC_DRIVER);
      if (DATABASE_CONNECTION == null || DATABASE_CONNECTION.isClosed()) {
        try {
          DATABASE_CONNECTION = DriverManager.getConnection(
                  DATABASE_URL,
                  USERNAME,
                  PASSWORD
          );
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return DATABASE_CONNECTION;
  }
}