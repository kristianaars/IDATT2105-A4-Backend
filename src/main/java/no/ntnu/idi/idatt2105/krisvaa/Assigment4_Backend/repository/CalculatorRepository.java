package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.repository;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.Calculation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CalculatorRepository extends CrudRepository<Calculation, Long> {

    @Override
    Calculation save(Calculation entity);

    @Query("SELECT c FROM Calculation c WHERE c.user_id = :user_id")
    List<Calculation> findAllByUserId(
            @Param("user_id") long user_id
    );
}
