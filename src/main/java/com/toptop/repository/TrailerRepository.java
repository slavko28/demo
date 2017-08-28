package com.toptop.repository;

import com.toptop.domain.Trailer;
import com.toptop.domain.enums.TrailerType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrailerRepository extends JpaRepository<Trailer, Long>{

    List<Trailer> findAllByType(TrailerType trailerType);

    List<Trailer> findAllByCompanyId(Long id);

    List<Trailer> findAllByCompanyIdAndType(Long companyId, TrailerType type);
}
