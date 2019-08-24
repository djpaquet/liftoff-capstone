package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface IngredientsDao extends CrudRepository<Ingredient, Integer> {
}
