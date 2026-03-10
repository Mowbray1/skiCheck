package com.skiCheck;

import org.springframework.stereotype.Service;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    public Resort getWeatherForResort(Resort resort){
        double latitude = resort.getLatitude();
        double longitude = resort.getLongitude();

        String base = "https://api.open-meteo.com/v1/forecast?latitude="+latitude+"&longitude="+longitude;
        String values = "&current=temperature_2m,snow_depth";
        String url = base+values;
        try (HttpClient client = HttpClient.newHttpClient()) {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(response ->{
                        try{
                            ObjectMapper mapper = new ObjectMapper();
                            JsonNode root = mapper.readTree(response);

                            double temp = root.path("current").path("temperature_2m").asDouble();
                            double snowDepth = root.path("current").path("snow_depth").asDouble();

                            return new Double[]{temp, snowDepth};
                        }catch (Exception e) {
                            return new Double[]{0.0,0.0};
                        }
                    })
                    .thenAccept(data -> {
                        resort.setTemperature(data[0]);
                        resort.setSnowDepth(data[1]);
                    })
                    .join();
        }

        return resort;
    }
}
