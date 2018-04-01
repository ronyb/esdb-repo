package il.co.topq.esdbserver.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import il.co.topq.esdbserver.exception.ResourceNotFoundException;
import il.co.topq.esdbserver.model.Skill;
import il.co.topq.esdbserver.repository.SkillRepository;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillRepository skillsRepository;

    @GetMapping("/skills")
    public List<Skill> getAllEnployees() {
        return skillsRepository.findAll();
    }

    @PostMapping("/skills")
    public Skill createEmployee(@Valid @RequestBody Skill skill) {
        return skillsRepository.save(skill);
    }
    
    @GetMapping("/skills/{id}")
    public Skill getNoteById(@PathVariable(value = "id") Long skillId) {
        return skillsRepository
        		.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));
    }

    @PutMapping("/skills/{id}")
    public Skill updateNote(@PathVariable(value = "id") Long skillId, @Valid @RequestBody Skill skillDetails) {

    	Skill skill = skillsRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));

    	skill.update(skillDetails);
    	
    	skill = skillsRepository.save(skill);
        return skill;
    }

    @DeleteMapping("/skills/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long employeeId) {
    	Skill skill = skillsRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", employeeId));

    	skillsRepository.delete(skill);

        return ResponseEntity.ok().build();
    }
}
