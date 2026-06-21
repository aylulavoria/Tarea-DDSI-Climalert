package ar.edu.utn.frba.dds.climalert.services;

import ar.edu.utn.frba.dds.climalert.dtos.WeatherResponseDTO;
import ar.edu.utn.frba.dds.climalert.models.entities.RegistroClimatico;
import ar.edu.utn.frba.dds.climalert.repositories.RegistroClimaticoRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ClimalertService {
  private final WeatherService weatherApi;
  private final RegistroClimaticoRepository registroClimaticoRepository;

  public ClimalertService(WeatherService weatherApi, RegistroClimaticoRepository registroClimaticoRepository) {
    this.weatherApi = weatherApi;
    this.registroClimaticoRepository = registroClimaticoRepository;
  }

  public void registrarClima(){
    System.out.println("Buscando datos meteorologicos en CABA");
    WeatherResponseDTO climaDto = weatherApi.obtenerClimaActual();

    if(climaDto != null){
      RegistroClimatico registroClimatico = new RegistroClimatico(
          climaDto.current().temp_c(),
          climaDto.current().humidity(),
          LocalDateTime.now()
          );
      registroClimaticoRepository.save(registroClimatico);
    }
  }

  public void analizarAlertas(){
    RegistroClimatico ultimoRegistro = registroClimaticoRepository.obtenerUltimoRegistroClimatico();

    if(ultimoRegistro.getTemp_c() > 35 && ultimoRegistro.getHumidity() > 60){
      enviarAlerta(ultimoRegistro.getTemp_c(),ultimoRegistro.getHumidity());
    }else {
      System.out.println(
          "Condiciones normales. Temp: " + ultimoRegistro.getTemp_c() + "Humedad: " + ultimoRegistro.getHumidity());
    }
  }

  public void enviarAlerta(float temp_c, int humidity){
    System.out.println("Alerta meteorologica enviada.");
    System.out.println("Destinatarios: admin@clima.com, emergencias@clima.com, meteorologia@clima.com");
    System.out.println("Detalle: Temperatura de " + temp_c + "°C y humedad del " + humidity + "%");
  }
}
