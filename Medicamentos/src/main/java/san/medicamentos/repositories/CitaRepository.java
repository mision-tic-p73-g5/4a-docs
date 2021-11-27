package san.medicamentos.repositories;

import san.medicamentos.models.Cita;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CitaRepository extends MongoRepository<Cita, String> {
    List<Cita> findCitaByUser(String user);
}
