package com.generalnitin.springaop.repositories;

import com.generalnitin.springaop.models.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeRepository extends JpaRepository<Home, String> {
}
