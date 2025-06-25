package com.billGenerate.BillGenerate.repository;

import com.billGenerate.BillGenerate.model.Coustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CoustomerRepository extends JpaRepository<Coustomer,Integer> {
    @Query(value = "SELECT * FROM coustomer WHERE local_date = :date", nativeQuery = true)
    List<Coustomer> findByLocalDate(@Param("date") LocalDate date);
}
