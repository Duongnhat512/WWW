package com.iuh.se.repositories;

import com.iuh.se.entities.DienThoai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DienThoaiRepository extends JpaRepository<DienThoai, Long> {
}
