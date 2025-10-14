package org.example.demoobserver.display;

import lombok.extern.slf4j.Slf4j;
import org.example.demoobserver.model.WeatherData;
import org.example.demoobserver.observer.Observer;

@Slf4j
public class TemperatureDisplay implements Observer<WeatherData> {

    private float currentTemperature;

    public TemperatureDisplay() {
        log.info("Display de temperatura creado");
        this.currentTemperature = 0.0f;
    }

    @Override
    public void update(WeatherData weatherData) {
        if (weatherData != null) {
            this.currentTemperature = weatherData.getTemperature();
            display();
        } else {
            log.warn("Datos meteorológicos nulos");
        }
    }

    private void display() {
        log.info("Display de temperatura: {} ºC", String.format("%.1f", this.currentTemperature));
    }

    public float getCurrentTemperature() {
        return this.currentTemperature;
    }

}
