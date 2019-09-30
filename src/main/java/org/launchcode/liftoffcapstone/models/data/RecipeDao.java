package org.launchcode.liftoffcapstone.models.data;


import org.launchcode.liftoffcapstone.models.Recipe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RecipeDao extends CrudRepository<Recipe, Integer> {

     @Query(value = "SELECT r FROM Recipe r where r.name LIKE %?1%")
     public List<Recipe> findByNameContainingIgnoreCase(String name);


    /* List<Recipe> findByNameContainingIgnoreCase(String name);
*/



}
