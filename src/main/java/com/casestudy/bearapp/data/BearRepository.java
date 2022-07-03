package com.casestudy.bearapp.data;
import com.casestudy.bearapp.models.Bear;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BearRepository extends JpaRepository<Bear, Long>{
}
