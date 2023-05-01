package lesson7.project;

import java.sql.*;
import java.util.List;

public class DataBaseRepository {
    private final String insertWeather = "insert into weather (city, localdate, text, temperature) values (?, ?, ?, ?)";
    private static final String DB_PATH = "jdbc:sqlite:local.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public boolean saveWeatherToDataBase(Weather weather) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH); PreparedStatement saveWeather = connection.prepareStatement(insertWeather)) {
            saveWeather.setString(1, weather.getCity());
            saveWeather.setString(2, weather.getLocalDate());
            saveWeather.setString(3, weather.getWeatherText());
            saveWeather.setDouble(4, weather.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Сохранение погоды в базу данных не выполнено!");
    }

    public void saveWeatherToDataBase(List<Weather> weatherList) {
        // Java will close all the connections there is exit from try block
        try (Connection connection = DriverManager.getConnection(DB_PATH); PreparedStatement saveWeather = connection.prepareStatement(insertWeather)) {
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setString(3, weather.getWeatherText());
                saveWeather.setDouble(4, weather.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void getSavedToDBWeather() {
        try (Connection connection = DriverManager.getConnection(DB_PATH); Statement statement = connection.createStatement();) {
            String getWeather = "select * from weather";
            ResultSet resultSet = statement.executeQuery(getWeather);
            while (resultSet.next()) {
                System.out.printf("| %s | В городе %s на дату %s ожидается %s, температура - %,.2f F |\n", resultSet.getInt("id"), resultSet.getString("city"), resultSet.getString("localdate"), resultSet.getString("text"), resultSet.getDouble("temperature"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
