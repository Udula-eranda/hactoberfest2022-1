package com.example.InventoryApp;

import static org.assertj.core.api.Assertions.assertThat;

import com.example.InventoryApp.category.Category;
import com.example.InventoryApp.category.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CategoryRepositoryTests {

    @Autowired
    private CategoryRepository  repo;

    @Test
    public void testCreateCategory(){

        Category savedCategory = repo.save(new Category("Electronics"));

        assertThat(savedCategory.getId()).isGreaterThan(0);
    }
}
