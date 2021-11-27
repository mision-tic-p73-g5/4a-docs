package san.medicamentos.controllers;

import org.springframework.web.bind.annotation.*;
import san.medicamentos.exceptions.MedicineNotFoundException;
import san.medicamentos.models.Medicamento;
import san.medicamentos.repositories.MedicamentoRepository;

import java.util.Optional;

@RestController
public class MedicamentoController {

    private final MedicamentoRepository medicamentoRepository;

    public MedicamentoController(MedicamentoRepository medicamentoRepository){
        this.medicamentoRepository = medicamentoRepository;
    }

    @GetMapping("/medicamento/{id}")
    Optional<Medicamento> getMedicamento(@PathVariable String id){
        return medicamentoRepository.findById(id);
    }

    @GetMapping("/medicamento/byname/{name}")
    Medicamento getMedicamentoByName(@PathVariable String name) { return medicamentoRepository.findByName(name); }

    @PostMapping("/medicamento")
    Medicamento newMedicamento(@RequestBody Medicamento medicamento){
        long nextId = medicamentoRepository.count();
        medicamento.setId(String.valueOf(nextId));
        return medicamentoRepository.save(medicamento);
    }

    @PostMapping("/medicamento/update")
    Medicamento updateMedicamento(@RequestBody Medicamento medicamento){
        Optional<Medicamento> med = medicamentoRepository.findById(medicamento.getId());
        if(med.isPresent()){
            medicamento.setQuantity(medicamento.getQuantity() + med.get().getQuantity());
            return medicamentoRepository.save(medicamento);
        }
        else{
            throw new MedicineNotFoundException("No se encontro el medicamento " + medicamento.getName());
        }
    }
}
