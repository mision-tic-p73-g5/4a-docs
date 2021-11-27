package san.medicamentos.repositories;

import san.medicamentos.models.Medicamento;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MedicamentoRepository extends MongoRepository<Medicamento, String> {
    Medicamento findByName(String name);
}
