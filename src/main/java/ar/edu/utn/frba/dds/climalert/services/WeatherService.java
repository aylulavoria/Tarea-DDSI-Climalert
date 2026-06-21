package ar.edu.utn.frba.dds.climalert.services;

import ar.edu.utn.frba.dds.climalert.dtos.WeatherResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
  private final RestTemplate restTemplate = new RestTemplate();
  private final String API_URL = "http://api.weatherapi.com/v1/current.json?key=1965330d8c254f288a4155607262106&q=CABA";

  public WeatherResponseDTO obtenerClimaActual(){
    return restTemplate.getForObject(API_URL, WeatherResponseDTO.class);
  }


}
