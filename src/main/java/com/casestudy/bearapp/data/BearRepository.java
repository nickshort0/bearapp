package com.casestudy.bearapp.data;
import com.casestudy.bearapp.models.Bear;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BearRepository extends JpaRepository<Bear, Long>{
}
