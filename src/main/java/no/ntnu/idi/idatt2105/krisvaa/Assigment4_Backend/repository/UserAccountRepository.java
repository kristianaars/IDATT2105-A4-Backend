package no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.repository;

import no.ntnu.idi.idatt2105.krisvaa.Assigment4_Backend.model.UserAccount;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository extends CrudRepository<UserAccount, Long> {

    @Query("SELECT usr FROM UserAccount usr WHERE usr.email = :email AND usr.password = :password")
    UserAccount getUserWithCreds(
            @Param("email") String email,
            @Param("password") String password);

}
