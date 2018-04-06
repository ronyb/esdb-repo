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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import il.co.topq.esdbserver.exception.ResourceNotFoundException;
import il.co.topq.esdbserver.model.Skill;
import il.co.topq.esdbserver.repository.SkillRepository;
import il.co.topq.esdbserver.utils.Validation;

@RestController
@RequestMapping("/api")
public class SkillController {

    @Autowired
    SkillRepository skillsRepository;

    @GetMapping("/skills")
    public List<Skill> getAllSkills() {
        return skillsRepository.findAll();
    }

    @PostMapping("/skill")
    public Skill createSkill(@Valid @RequestBody Skill skill) {
        if (Validation.strNotEmpty(skill.getSkillName()) && Validation.strNotEmpty(skill.getCategory())) {
        	return skillsRepository.save(skill);
        }
        else {
        	throw new RuntimeException("Skill name and/or category were not provided");
        }
    }
    
    @GetMapping("/skill/{id}")
    public Skill getSkillById(@PathVariable(value = "id") Long skillId) {
        return skillsRepository
        		.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));
    }
    
    @GetMapping("/skill")
    public List<Skill> getSkillByParameter(@RequestParam(value="paramName") String paramName, @RequestParam(value="paramValue") String paramValue) {
        
    	switch(paramName) {
    	case "skillName":
        	return skillsRepository.findBySkillName(paramValue);
    	case "category":
        	return skillsRepository.findByCategory(paramValue);
    	}
    	
    	throw new ResourceNotFoundException("Skill", paramName, paramValue);
    }

    @PutMapping("/skill/{id}")
    public Skill updateSkill(@PathVariable(value = "id") Long skillId, @Valid @RequestBody Skill skillDetails) {

    	Skill skill = skillsRepository.findById(skillId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", skillId));

    	skill.update(skillDetails);
    	
    	skill = skillsRepository.save(skill);
        return skill;
    }

    @DeleteMapping("/skill/{id}")
    public ResponseEntity<?> deleteSkill(@PathVariable(value = "id") Long employeeId) {
    	Skill skill = skillsRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", employeeId));

    	skillsRepository.delete(skill);

        return ResponseEntity.ok().build();
    }
}
