package org.example;

import org.example.WindDirection;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import org.hibernate.annotations.Proxy;
@Entity
@Table(name = "weather")
@Proxy(lazy = false)
public class Weather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "country", insertable = true, updatable = true)
    private String country;

    @Column(name = "wind_degree")
    private Integer windDegree;

    @Column(name = "wind_kph")
    private Double windKph;

    @Enumerated(EnumType.STRING)
    @Column(name = "wind_direction")
    private WindDirection windDirection;

    @Column(name = "last_updated")
    private Date lastUpdated;

    //@Column(name = "sunrise")
    //private LocalDateTime sunrise;

    @Column(name = "temperature_celsius")
    private double temperatureCelsius;

    @Column(name = "temperature_fahrenheit")
    private double temperatureFahrenheit;

    @Column(name = "condition_text")
    private String conditionText;

    @Column(name = "pressure_mb")
    private double pressureMb;

    @Column(name = "pressure_in")
    private double pressureIn;

    @Column(name = "precip_mm")
    private double precipMm;

    @Column(name = "precip_in")
    private double precipIn;

    @Column(name = "humidity")
    private int humidity;

    @Column(name = "cloud")
    private int cloud;

    @Column(name = "feels_like_celsius")
    private double feelsLikeCelsius;

    @Column(name = "feels_like_fahrenheit")
    private double feelsLikeFahrenheit;

    @Column(name = "visibility_km")
    private double visibilityKm;

    @Column(name = "visibility_miles")
    private double visibilityMiles;

    @Column(name = "uv_index")
    private double uvIndex;

    @Column(name = "air_quality_Carbon_Monoxide")
    private double airQualityCarbonMonoxide;

    @Column(name = "air_quality_Ozone")
    private double airQualityOzone;

    @Column(name = "air_quality_Nitrogen_dioxide")
    private double airQualityNitrogenDioxide;

    @Column(name = "air_quality_Sulphur_dioxide")
    private double airQualitySulphurDioxide;


    @Column(name = "air_quality_PM10")
    private double airQualityPM10;


    public void setCountry(String country) {
        this.country = country;
    }

    public void setWindDegree(int windDegree) {
        this.windDegree = windDegree;
    }

    public void setWindKph(double windKph) {
        this.windKph = windKph;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    //public void setSunrise(LocalDateTime sunrise) {
    //    this.sunrise = sunrise;
    //}

    public void setTemperatureCelsius(double temperatureCelsius) {
        this.temperatureCelsius = temperatureCelsius;
    }

    public void setTemperatureFahrenheit(double temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public void setConditionText(String conditionText) {
        this.conditionText = conditionText;
    }

    public void setPressureMb(double pressureMb) {
        this.pressureMb = pressureMb;
    }

    public void setPressureIn(double pressureIn) {
        this.pressureIn = pressureIn;
    }

    public void setPrecipMm(double precipMm) {
        this.precipMm = precipMm;
    }

    public void setPrecipIn(double precipIn) {
        this.precipIn = precipIn;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setCloud(int cloud) {
        this.cloud = cloud;
    }

    public void setFeelsLikeCelsius(double feelsLikeCelsius) {
        this.feelsLikeCelsius = feelsLikeCelsius;
    }

    public void setFeelsLikeFahrenheit(double feelsLikeFahrenheit) {
        this.feelsLikeFahrenheit = feelsLikeFahrenheit;
    }

    public void setVisibilityKm(double visibilityKm) {
        this.visibilityKm = visibilityKm;
    }

    public void setVisibilityMiles(double visibilityMiles) {
        this.visibilityMiles = visibilityMiles;
    }

    public void setUvIndex(double uvIndex) {
        this.uvIndex = uvIndex;
    }

    public void setAirQualityCarbonMonoxide(double airQualityCarbonMonoxide) {
        this.airQualityCarbonMonoxide = airQualityCarbonMonoxide;
    }

    public void setAirQualityOzone(double airQualityOzone) {
        this.airQualityOzone = airQualityOzone;
    }

    public void setAirQualityNitrogenDioxide(double airQualityNitrogenDioxide) {
        this.airQualityNitrogenDioxide = airQualityNitrogenDioxide;
    }

    public void setAirQualitySulphurDioxide(double airQualitySulphurDioxide) {
        this.airQualitySulphurDioxide = airQualitySulphurDioxide;
    }


    public void setAirQualityPM10(double airQualityPM10) {
        this.airQualityPM10 = airQualityPM10;
    }


}