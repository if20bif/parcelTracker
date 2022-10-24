package at.fhtw.swen3.persistence.repository;

import at.fhtw.swen3.persistence.entity.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<ParcelEntity, Long> {}
