package san.medicamentos.controllers;

import org.springframework.web.bind.annotation.*;
import san.medicamentos.exceptions.MedicineNotFoundException;
import san.medicamentos.exceptions.NotEnoughMedicineException;
import san.medicamentos.models.Cita;
import san.medicamentos.models.Medicamento;
import san.medicamentos.repositories.CitaRepository;
import san.medicamentos.repositories.MedicamentoRepository;

import java.util.*;

@RestController
public class CitaController {

    private final CitaRepository citaRepository;
    private final MedicamentoRepository medicamentoRepository;

    public CitaController(CitaRepository citaRepository, MedicamentoRepository medicamentoRepository){
        this.citaRepository = citaRepository;
        this.medicamentoRepository = medicamentoRepository;
    }

    @GetMapping("/cita/{id}")
    Optional<Cita> getCita(@PathVariable String id){
        return citaRepository.findById(id);
    }

    @GetMapping("/cita/byuser/{user}")
    List<Cita> getCitas(@PathVariable String user){
        return citaRepository.findCitaByUser(user);
    }

    @PostMapping("/cita")
    Cita newCita(@RequestBody Cita cita) {
        List medicine = cita.getMedicine();
        List<Medicamento> listMedicine = new ArrayList<>();
        medicine.forEach(e -> {
            listMedicine.add(new Medicamento(
                    ((LinkedHashMap)e).get("id").toString(),
                    ((int) ((LinkedHashMap) e).get("quantity"))));
        });
        //Verificar cantidad de medicamento disponible
        listMedicine.forEach(e -> {
            Optional<Medicamento> med = medicamentoRepository.findById(e.getId());
            if (med.isPresent()) {
                if (med.get().getQuantity() < e.getQuantity()) {
                    throw new NotEnoughMedicineException("La máxima disponibilidad del medicamento " + e.getName() + " es de " + med.get().getQuantity());
                }
            }
            else{
                throw new MedicineNotFoundException("No se encuentra el medicamento " + e.getName());
            }
        });
        //Reservar la cantidad de medicamento
        listMedicine.forEach(e -> {
            Medicamento med = medicamentoRepository.findById(e.getId()).get();
            med.setQuantity(med.getQuantity()-e.getQuantity());
            medicamentoRepository.save(med);
        });
        long nextId = citaRepository.count();
        cita.setId(String.valueOf(nextId));
        return citaRepository.save(cita);
    }
}
