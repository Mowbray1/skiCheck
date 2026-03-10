package com.skiCheck;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

    @RestController
    public class ResortController {

        private final WeatherService weatherService;

        public ResortController(WeatherService weatherService) {
            this.weatherService = weatherService;
        }


        @GetMapping("/resorts")
        public List<Resort> getResorts() {
            Resort zugspitze = new Resort();
            zugspitze.setName("Zugspitze");
            zugspitze.setLatitude(47.4211);
            zugspitze.setLongitude(10.9850);
            Resort rusutsu = new Resort();
            rusutsu.setName("Rusutsu");
            rusutsu.setLatitude(42.7447);
            rusutsu.setLongitude(140.9011);
            Resort zermatt = new Resort();
            zermatt.setName("Zermatt");
            zermatt.setLatitude(45.9839);
            zermatt.setLongitude(7.7536);
            Resort verbier = new Resort();
            verbier.setName("Verbier");
            verbier.setLatitude(46.0961);
            verbier.setLongitude(7.2283);
            Resort niseko = new Resort();
            niseko.setName("Niseko");
            niseko.setLatitude(42.8042);
            niseko.setLongitude(140.6872);

            List<Resort> resorts = List.of(
                    zugspitze,
                    rusutsu,
                    zermatt,
                    verbier,
                    niseko
            );

            for (Resort resort : resorts){
                weatherService.getWeatherForResort(resort);
            }
            return resorts;
        }

    }


