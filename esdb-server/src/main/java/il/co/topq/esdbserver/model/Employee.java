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
@Table(name = "employees")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate", "updateDate"}, allowGetters = true)
public class Employee implements Serializable {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private int matrixId;
	
	private String firstNameEn;
	
	private String lastNameEn;
	
	private String firstNameHe;
	
	private String lastNameHe;
	
	private String jobTitle;
	
	private String email1;
	
	private String email2;
	
	private String phone;
	
	private String homeAddress;
	
	private String currentProjectsJson;
	
	private String prevProjectsJson;
	
	private String existingSkillsJson;
	
	private String desiredSkillsJson;
	
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
	private Date creationDate;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updateDate;

    
    public void update(Employee updatedEmployee) {
    	
    	if (updatedEmployee.matrixId != 0) {
    		this.matrixId = updatedEmployee.matrixId;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.firstNameEn)) {
    		this.firstNameEn = updatedEmployee.firstNameEn;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.lastNameEn)) {
    		this.lastNameEn = updatedEmployee.lastNameEn;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.firstNameHe)) {
    		this.firstNameHe = updatedEmployee.firstNameHe;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.lastNameHe)) {
    		this.lastNameHe = updatedEmployee.lastNameHe;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.jobTitle)) {
    		this.jobTitle = updatedEmployee.jobTitle;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.email1)) {
    		this.email1 = updatedEmployee.email1;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.email2)) {
    		this.email2 = updatedEmployee.email2;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.phone)) {
    		this.phone = updatedEmployee.phone;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.homeAddress)) {
    		this.homeAddress = updatedEmployee.homeAddress;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.currentProjectsJson)) {
    		this.currentProjectsJson = updatedEmployee.currentProjectsJson;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.prevProjectsJson)) {
    		this.prevProjectsJson = updatedEmployee.prevProjectsJson;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.existingSkillsJson)) {
    		this.existingSkillsJson = updatedEmployee.existingSkillsJson;
    	}
    	
    	if (Validation.strNotEmpty(updatedEmployee.desiredSkillsJson)) {
    		this.desiredSkillsJson = updatedEmployee.desiredSkillsJson;
    	}
    }
    
    // Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMatrixId() {
		return matrixId;
	}

	public void setMatrixId(int matrixId) {
		this.matrixId = matrixId;
	}

	public String getFirstNameEn() {
		return firstNameEn;
	}

	public void setFirstNameEn(String firstNameEn) {
		this.firstNameEn = firstNameEn;
	}

	public String getLastNameEn() {
		return lastNameEn;
	}

	public void setLastNameEn(String lastNameEn) {
		this.lastNameEn = lastNameEn;
	}

	public String getFirstNameHe() {
		return firstNameHe;
	}

	public void setFirstNameHe(String firstNameHe) {
		this.firstNameHe = firstNameHe;
	}

	public String getLastNameHe() {
		return lastNameHe;
	}

	public void setLastNameHe(String lastNameHe) {
		this.lastNameHe = lastNameHe;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getEmail1() {
		return email1;
	}

	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}

	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getPrevProjectsJson() {
		return prevProjectsJson;
	}

	public void setPrevProjectsJson(String prevProjectsJson) {
		this.prevProjectsJson = prevProjectsJson;
	}

	public String getExistingSkillsJson() {
		return existingSkillsJson;
	}

	public void setExistingSkillsJson(String existingSkillsJson) {
		this.existingSkillsJson = existingSkillsJson;
	}

	public String getDesiredSkillsJson() {
		return desiredSkillsJson;
	}

	public void setDesiredSkillsJson(String desiredSkillsJson) {
		this.desiredSkillsJson = desiredSkillsJson;
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

	public String getCurrentProjectsJson() {
		return currentProjectsJson;
	}

	public void setCurrentProjectsJson(String currentProjectsJson) {
		this.currentProjectsJson = currentProjectsJson;
	}
}
