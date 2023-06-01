package uz.pdp.appspringjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.pdp.appspringjpa.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
