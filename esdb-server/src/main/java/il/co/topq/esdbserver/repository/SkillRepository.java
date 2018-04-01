package il.co.topq.esdbserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import il.co.topq.esdbserver.model.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

}