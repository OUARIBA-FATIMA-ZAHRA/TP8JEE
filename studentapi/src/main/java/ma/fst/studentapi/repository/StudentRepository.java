package ma.fst.studentapi.repository;

import ma.fst.studentapi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByEmail(String email);
    boolean existsByEmail(String email);

    List<Student> findByFirstName(String firstName); // tous les étudiants avec ce prénom
    List<Student> findByLastNameAndFirstName(String lastName, String firstName); // prénom + nom
    Optional<Student> findByIdAndEmail(Long id, String email);// id + email

    List<Student> findByFirstNameContaining(String keyword); // prénom contient "keyword"
    List<Student> findByLastNameStartingWith(String prefix); // prénom commence par "prefix"
    List<Student> findByEmailEndingWith(String suffix); // email finit par "@gmail.com"

    List<Student> findByFirstNameOrderByLastNameAsc(String firstName); // tri ascendant par nom
    List<Student> findByLastNameOrderByFirstNameDesc(String lastName); // tri descendant par prénom

    List<Student> findTop3ByOrderByIdDesc(); // les 3 derniers étudiants ajoutés
    List<Student> findFirst5ByLastName(String lastName); // les 5 premiers avec ce nom


    void deleteByEmail(String email); // supprime un étudiant avec cet email
    void deleteByLastName(String lastName); // supprime tous les étudiants avec ce nom
}