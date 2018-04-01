package il.co.topq.esdbserver.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import il.co.topq.esdbserver.utils.Validation;

@SuppressWarnings("serial")
@Entity
@Table(name = "skills")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "updateDate"}, allowGetters = true)
public class Skill implements Serializable {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String skillName;
	
	private String skillDescription;
	
	private String category;
	
	private String subcategory;
	
	private String learningResourcesJson;
	
	private int topqRelevance;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date creationDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateDate;

    public void update(Skill updatedSkill) {
    	
    	if (Validation.strNotEmpty(updatedSkill.skillName)) {
    		this.skillName = updatedSkill.skillName;
    	}
    	
    	if (Validation.strNotEmpty(updatedSkill.skillDescription)) {
    		this.skillDescription = updatedSkill.skillDescription;
    	}
    	
    	if (Validation.strNotEmpty(updatedSkill.category)) {
    		this.category = updatedSkill.category;
    	}
    	
    	if (Validation.strNotEmpty(updatedSkill.subcategory)) {
    		this.subcategory = updatedSkill.subcategory;
    	}
    	
    	if (Validation.strNotEmpty(updatedSkill.learningResourcesJson)) {
    		this.learningResourcesJson = updatedSkill.learningResourcesJson;
    	}
    	
    	if (updatedSkill.topqRelevance != 0) {
    		this.topqRelevance = updatedSkill.topqRelevance;
    	}
    }
    
    // Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public String getSkillDescription() {
		return skillDescription;
	}

	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSubcategory() {
		return subcategory;
	}

	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}

	public String getLearningResourcesJson() {
		return learningResourcesJson;
	}

	public void setLearningResourcesJson(String learningResourcesJson) {
		this.learningResourcesJson = learningResourcesJson;
	}

	public int getTopqRelevance() {
		return topqRelevance;
	}

	public void setTopqRelevance(int topqRelevance) {
		this.topqRelevance = topqRelevance;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
