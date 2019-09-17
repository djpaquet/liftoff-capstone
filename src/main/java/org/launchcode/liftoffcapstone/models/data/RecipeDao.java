package org.launchcode.liftoffcapstone.models.data;


import org.launchcode.liftoffcapstone.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RecipeDao extends CrudRepository<Recipe, Integer> {

     List<Recipe> findByNameIgnoreCase(String name);

     List<Recipe> findByNameContainingIgnoreCase(String searchTerm);




}
