package lesson7.project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private WeatherModel weatherModel = new AccuweatherModel();
    private Map<Integer, Period> variants = new HashMap<>();

    public Controller() {
        variants.put(1, Period.NOW);
        variants.put(2, Period.DB);
        variants.put(5, Period.FIVE_DAYS);
    }

    public void getWeather(String userInput, String selectedCity) throws IOException {
        Integer userIntegerInput = Integer.parseInt(userInput);

        switch (variants.get(userIntegerInput)) {
            case NOW:
                try {
                    weatherModel.getWeather(selectedCity, Period.NOW);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case FIVE_DAYS:
                try {
                    weatherModel.getWeather(selectedCity, Period.FIVE_DAYS);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case DB:
                DataBaseRepository dataBaseRepository = new DataBaseRepository();
                dataBaseRepository.getSavedToDBWeather();
                break;
        }
    }
}
