
package com.tp5.gfresnais.model.DarkSkyAPI;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Flags {

    private List<String> sources = null;
    private String meteoalarmLicense;
    private Double nearestStation;
    private String units;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public String getMeteoalarmLicense() {
        return meteoalarmLicense;
    }

    public void setMeteoalarmLicense(String meteoalarmLicense) {
        this.meteoalarmLicense = meteoalarmLicense;
    }

    public Double getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(Double nearestStation) {
        this.nearestStation = nearestStation;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
