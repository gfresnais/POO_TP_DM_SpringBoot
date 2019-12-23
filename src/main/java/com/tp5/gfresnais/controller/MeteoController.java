package com.tp5.gfresnais.controller;

import com.tp5.gfresnais.model.DarkSkyAPI.Currently;
import com.tp5.gfresnais.model.DarkSkyAPI.Weather;
import com.tp5.gfresnais.model.GeoAPI.GeoRequest;
import com.tp5.gfresnais.model.GeoAPI.Geometry;
import com.tp5.gfresnais.model.GeoAPI.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class MeteoController {

    private GeoRequest geoRequest;
    private Weather weather;

    private String apiAddr = "https://api-adresse.data.gouv.fr/search/?q=";
    private String darkApiAddr = "https://api.darksky.net/forecast/b5d1688c6b64c03daaf83118ace06c33/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/meteo")
    public String postMeteo(@RequestParam("address") String search, Model model) {
        geoRequest = restTemplate.getForObject(apiAddr + search, GeoRequest.class);

        Properties properties = geoRequest.getFeatures().get(0).getProperties();
        Geometry geometry = geoRequest.getFeatures().get(0).getGeometry();

        model.addAttribute("search", search);
        model.addAttribute("label", properties.getLabel());

        List<Double> coords = geometry.getCoordinates();

        String darkAddr = darkApiAddr + coords.get(1) + "," + coords.get(0) + "?units=si&lang=fr";

        weather = restTemplate.getForObject(darkAddr, Weather.class);

        Currently currently = weather.getCurrently();

        model.addAttribute("humidity", currently.getHumidity() * 100);
        model.addAttribute("temperature", currently.getTemperature());
        model.addAttribute("summary", currently.getSummary());

        return "weather";
    }


}
