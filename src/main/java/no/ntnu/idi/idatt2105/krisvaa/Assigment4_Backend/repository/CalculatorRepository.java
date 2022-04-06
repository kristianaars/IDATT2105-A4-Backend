package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.repository;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.Calculation;
import org.springframework.data.repository.CrudRepository;

public interface CalculatorRepository extends CrudRepository<Calculation, Long> {

    @Override
    Calculation save(Calculation entity);
}
