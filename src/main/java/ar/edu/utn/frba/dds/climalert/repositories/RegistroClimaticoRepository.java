package ar.edu.utn.frba.dds.climalert.repositories;

import ar.edu.utn.frba.dds.climalert.models.entities.RegistroClimatico;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RegistroClimaticoRepository {
  private final List<RegistroClimatico> historial = new ArrayList<>();

  public void save(RegistroClimatico registro){
    historial.add(registro);
  }
  public RegistroClimatico obtenerUltimoRegistroClimatico(){
    return historial.getLast();
  }

}
