package lesson7.project;

public class Weather {
    private String city;
    private String localDate;
    private String weatherText;
    private double temperature;

    public Weather(String city, String localDate, String weatherText, double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getWeatherText() {
        return weatherText;
    }

    public void setWeatherText(String weatherText) {
        this.weatherText = weatherText;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "city='" + city + '\'' +
                ", localDate='" + localDate + '\'' +
                ", weatherText='" + weatherText + '\'' +
                ", temperature=" + String.format("%.2f", temperature) +
                '}';
    }
}
