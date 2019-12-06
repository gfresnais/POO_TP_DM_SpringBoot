package com.tp5.gfresnais.controller;

import com.tp5.gfresnais.model.GeoAPI.GeoRequest;
import com.tp5.gfresnais.model.GeoAPI.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
public class MeteoController {

    private GeoRequest geoRequest;

    private String apiAddr = "https://api-adresse.data.gouv.fr/search/";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/meteo")
    public String postMeteo(@RequestParam("address") String search, Model model) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiAddr)
                .queryParam("q", search);
                //.queryParam("type", "housenumber")
                //.queryParam("autocomplete", "1");
        geoRequest = restTemplate.getForObject(builder.toUriString(), GeoRequest.class);

        Properties properties = geoRequest.getFeatures().get(0).getProperties();

        model.addAttribute("search", search);
        model.addAttribute("city", properties.getCity());
        return "weather";
    }


}
