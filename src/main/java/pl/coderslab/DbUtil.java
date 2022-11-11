package pl.coderslab;

import java.sql.*;
import java.util.Arrays;

public class DbUtil {


    private static final String DB_URL_CINEMAS   = "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_URL_PRODUCTS  = "jdbc:mysql://localhost:3306/products_ex?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_URL_WORKSHOP2 = "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    private static final String DB_USER          = "root";
    private static final String DB_PASS          = "haselko";
    private static final String DELETE_QUERY     = "DELETE FROM tableName where id = ?";


    public static Connection connect_cinemas() throws SQLException {
        return DriverManager.getConnection(DB_URL_CINEMAS, DB_USER, DB_PASS);
    }
    public static Connection connect_products() throws SQLException {
        return DriverManager.getConnection(DB_URL_PRODUCTS, DB_USER, DB_PASS);
    }
    public static Connection connect_db_test() throws SQLException {
        return DriverManager.getConnection(DB_URL_WORKSHOP2, DB_USER, DB_PASS);
    }
    public static void insert(Connection conn, String query, String... params) {
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            //System.out.println(statement);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {

        try (PreparedStatement statement = conn.prepareStatement(query);

             ResultSet resultSet = statement.executeQuery();) {

            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.println(resultSet.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printDataFlat(Connection conn, String query, String... columnNames) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query);

             ResultSet resultSet = statement.executeQuery();) {

            System.out.println("\n");

            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.print(resultSet.getString(columnName) + " | ");
                }
                System.out.println("\n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printDataFlatWithParameters(Connection conn, String query, int param1, int param2, String... columnNames) throws SQLException {
        try (PreparedStatement statement = conn.prepareStatement(query);){

            if (param1 > 0) {
                statement.setInt(1, param1);
                if (param2 > 0) {
                    statement.setInt(2, param2);
                }
            }
            ResultSet resultSet = statement.executeQuery();


            if (resultSet.next()) {
                do {
                    for (String columnName : columnNames) {
                        System.out.print(resultSet.getString(columnName) + " | ");
                    }
                    System.out.println("\n");
                } while(resultSet.next());
            } else {
                System.out.println("No results");
                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static int getUserId(Connection conn, String query, String param1, String param2, String param3) throws SQLException {
        int result = -1;

        try (PreparedStatement statement = conn.prepareStatement(query);){
            statement.setString(1, param1);
            statement.setString(2, param2);
            statement.setString(3, param3);

            //System.out.println("Zapytanie: " + statement);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result =  resultSet.getInt("id");
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static String[] getUserData(Connection conn, String query, int param1) throws SQLException {
        String [] result = new String[4];

        try (PreparedStatement statement = conn.prepareStatement(query);){
            statement.setInt(1, param1);
            //System.out.println("Zapytanie: " + statement);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                result[0] = String.valueOf(resultSet.getInt("id"));
                result[1] = resultSet.getString("userName");
                result[2] = resultSet.getString("eMail");
                result[3] = resultSet.getString("passWord");
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void updateData(Connection conn, String query, int userId, String... params) {
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.setInt(4, userId);
            //System.out.println("Zapytanie UPDATE: " + statement);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static User[] getAllData(Connection conn, String query) throws SQLException {
        User[] userArr = new User[0];

        try (PreparedStatement statement = conn.prepareStatement(query);){
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                userArr = Arrays.copyOf(userArr, userArr.length + 1);
                userArr[userArr.length - 1] = new User(resultSet.getInt("id"),
                        resultSet.getString("userName"),
                        resultSet.getString("eMail"),
                        resultSet.getString("passWord") );

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userArr;
    }





}
