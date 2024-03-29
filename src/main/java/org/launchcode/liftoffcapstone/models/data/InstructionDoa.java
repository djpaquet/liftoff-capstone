package org.launchcode.liftoffcapstone.models.data;

import org.launchcode.liftoffcapstone.models.Instruction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface InstructionDoa extends CrudRepository<Instruction, Integer> {
}
