package org.example;

import antlr.PreservingFileWriter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration().configure();
            configuration.addAnnotatedClass(Weather.class);
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }



    public void main(String[] args) {
        Transaction transaction = null;
        Session session= sessionFactory.openSession();
        try
        {
            session.getTransaction().begin();

            try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\38067\\IdeaProjects\\lab3\\src\\GlobalWeatherRepository.csv"))) {
                String line;
                br.readLine();
                while ((line = br.readLine()) != null) {
                    String[] data = line.split(",");
                    Weather weather = new Weather();
                    weather.setCountry(data[0]);
                    weather.setWindDegree(Integer.parseInt(data[12]));
                    weather.setWindKph(Double.parseDouble(data[11]));
                    weather.setWindDirection(WindDirection.valueOf(data[13]));
                    weather.setTemperatureCelsius(Double.parseDouble(data[7]));
                    weather.setTemperatureFahrenheit(Double.parseDouble(data[8]));
                    weather.setConditionText(data[9]);
                    weather.setPressureMb(Double.parseDouble(data[14]));
                    weather.setPressureIn(Double.parseDouble(data[15]));
                    weather.setPrecipMm(Double.parseDouble(data[16]));
                    weather.setPrecipIn(Double.parseDouble(data[17]));
                    weather.setHumidity(Integer.parseInt(data[18]));
                    weather.setCloud(Integer.parseInt(data[19]));
                    weather.setFeelsLikeCelsius(Double.parseDouble(data[20]));
                    weather.setFeelsLikeFahrenheit(Double.parseDouble(data[21]));
                    weather.setVisibilityKm(Double.parseDouble(data[22]));
                    weather.setVisibilityMiles(Double.parseDouble(data[23]));
                    weather.setUvIndex(Double.parseDouble(data[24]));
                    weather.setAirQualityCarbonMonoxide(Double.parseDouble(data[27]));
                    weather.setAirQualityOzone(Double.parseDouble(data[28]));
                    weather.setAirQualityNitrogenDioxide(Double.parseDouble(data[29]));
                    weather.setAirQualitySulphurDioxide(Double.parseDouble(data[30]));
                    //weather.setAirQualityPM2_5(Double.parseDouble(data[31]));
                    weather.setAirQualityPM10(Double.parseDouble(data[32]));
                    //weather.setAirQualityUsEpaIndex(Integer.parseInt(data[33]));
                    //weather.setAirQualityGbDefraIndex(Integer.parseInt(data[34]));
                    session.save(weather);
                    session.persist(weather);

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:aa");
                    //weather.setLastUpdated(dateFormat.parse(data[6]));
                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a", Locale.US);
                    LocalTime.parse(data[35], timeFormatter);
                    // set other properties
                }
                 session.flush();
                 session.getTransaction().commit();
            } catch (IOException e) {
                e.printStackTrace();
                if (session.getTransaction() != null) {
                    session.getTransaction().rollback();
                }
            }
        } finally {

            session.close();
            }
        }
    }
