ALTER TABLE weather_data
ADD COLUMN should_go_out BOOLEAN;
UPDATE weather_data
SET should_go_out = CASE
    WHEN cloud <= 80 AND humidity <=80 AND temperature_celsius >=10 AND wind_kph<=10 THEN TRUE
    ELSE FALSE
END;