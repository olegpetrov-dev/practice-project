package com.olegpetrov.practiceproject.repository;

import com.olegpetrov.practiceproject.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
