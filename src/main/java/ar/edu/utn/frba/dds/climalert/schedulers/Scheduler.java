package ar.edu.utn.frba.dds.climalert.schedulers;

import ar.edu.utn.frba.dds.climalert.services.ClimalertService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
  private final ClimalertService clima;

  public Scheduler(ClimalertService clima) {
    this.clima = clima;
  }
  @Scheduled(fixedRate = 300000)
  public void obtenerDatosClimaticos(){
    clima.registrarClima();
  }

  @Scheduled(fixedRate = 60000)
  public void analizarAlertas(){
    clima.analizarAlertas();
  }
}
