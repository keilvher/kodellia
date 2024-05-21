package com.lvher.kodellia.repository;

import com.lvher.kodellia.domain.Tbuser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TbuserRepository extends JpaRepository<Tbuser, String> {

}
