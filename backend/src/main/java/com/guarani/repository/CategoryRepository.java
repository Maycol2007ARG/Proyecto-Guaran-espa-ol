package com.guarani.repository;

import com.guarani.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByOrderByNameAsc();

    @Query("SELECT c.id, c.name, c.icon, c.description, SIZE(c.words) FROM Category c ORDER BY c.name ASC")
    List<Object[]> findAllWithWordCount();
}
