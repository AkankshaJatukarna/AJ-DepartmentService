package com.crudoperation.department.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long depId;
	@NotBlank(message = "Department name is mandatory")
	private String depName;
	private String depAdd;
	private String depCode;
//	public Department() {
//
//		// TODO Auto-generated constructor stub
//	}
//	public Department(Long depId, String depName, String depAdd, String depCode) {
//		super();
//		this.depId = depId;
//		this.depName = depName;
//		this.depAdd = depAdd;
//		this.depCode = depCode;
//	}
//	public Long getDepId() {
//		return depId;
//	}
//	public void setDepId(Long depId) {
//		this.depId = depId;
//	}
//	public String getDepName() {
//		return depName;
//	}
//	public void setDepName(String depName) {
//		this.depName = depName;
//	}
//	public String getDepAdd() {
//		return depAdd;
//	}
//	public void setDepAdd(String depAdd) {
//		this.depAdd = depAdd;
//	}
//	public String getDepCode() {
//		return depCode;
//	}
//	public void setDepCode(String depCode) {
//		this.depCode = depCode;
//	}
//	@Override
//	public String toString() {
//		return "Department [depId=" + depId + ", depName=" + depName + ", depAdd=" + depAdd + ", depCode=" + depCode
//				+ "]";
//	}
//
//
}
