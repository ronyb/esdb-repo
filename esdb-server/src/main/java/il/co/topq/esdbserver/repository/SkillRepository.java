package il.co.topq.esdbserver.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import il.co.topq.esdbserver.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	List<Skill> findBySkillName(String skillName);
    
    List<Skill> findByCategory(String category);
	
}