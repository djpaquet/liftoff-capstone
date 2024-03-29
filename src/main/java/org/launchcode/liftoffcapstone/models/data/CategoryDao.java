package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {

    Category findByCategoryName(String name);
}
