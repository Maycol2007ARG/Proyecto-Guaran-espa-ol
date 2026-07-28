package com.guarani.service;

import com.guarani.dto.CategoryDTO;
import com.guarani.model.Category;
import com.guarani.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<CategoryDTO> getAllCategories() {
        List<Object[]> rows = categoryRepository.findAllWithWordCount();
        return rows.stream()
            .map(row -> new CategoryDTO(
                (Long) row[0],
                (String) row[1],
                (String) row[2],
                (String) row[3],
                (Integer) row[4]
            ))
            .collect(Collectors.toList());
    }
}
