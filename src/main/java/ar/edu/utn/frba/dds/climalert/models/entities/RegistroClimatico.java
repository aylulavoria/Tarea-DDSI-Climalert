package ar.edu.utn.frba.dds.climalert.models.entities;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class RegistroClimatico {
  float temp_c;
  int humidity;
  LocalDateTime fechaConsultada;

  public RegistroClimatico(float temp_c, int humidity, LocalDateTime fechaConsultada) {
    this.temp_c = temp_c;
    this.humidity = humidity;
    this.fechaConsultada = fechaConsultada;
  }
}

