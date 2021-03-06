package com.lab.lsystem.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="TEACHER")
public class TeacherDomain {
	private String id; //id
	private String name;//教师姓名
	private String workCode;//教师工号
	private int sex;//教师性别
	private int mentorStatus;//导师身份
	private String finAccount;//财务账号
	private String idNumber;//身份证号
	private int jobTitle;//职称
	@DateTimeFormat( pattern = "yyyy-MM-dd" )
	private Date birthday;//生日
	private String phoneNumber;//手机号
	private String email;//邮箱
	private String homeAddress;//家庭住址（修改为办公室地址）
	private String entryYear;//入职年份
	private String headImg;//头像
	private Set<StudentDomain> students=new HashSet<StudentDomain>();
	private Set<StudentDomain> resStudents=new HashSet<StudentDomain>();
	public TeacherDomain() {
		super();
	}
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid",strategy="uuid")
	@Column(name = "ID", unique = true, nullable = true, precision = 10, scale = 0)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "NAME",unique = true, nullable = true, length = 100)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "WORKCODE",unique = true, nullable = true, length = 100)
	public String getWorkCode() {
		return workCode;
	}
	public void setWorkCode(String workCode) {
		this.workCode = workCode;
	}
	@Column(name = "SEX",unique = true, nullable = true, length =11)
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	@Column(name = "FINACCOUNT",unique = true, nullable = true, length = 100)
	public String getFinAccount() {
		return finAccount;
	}
	public void setFinAccount(String finAccount) {
		this.finAccount = finAccount;
	}
	@Column(name = "IDNUMBER",unique = true, nullable = true, length = 100)
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	@Column(name = "JOBTITLE",unique = true, nullable = true, length = 11)
	public int getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(int jobTitle) {
		this.jobTitle = jobTitle;
	}
	@Column(name = "BIRTHDAY",unique = true, nullable = true, length = 100)
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Column(name = "PHONENUMBER",unique = true, nullable = true, length = 100)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Column(name = "EMAIL",unique = true, nullable = true, length = 100)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name = "HOMEADDRESS",unique = true, nullable = true, length = 255)
	public String getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	@Column(name = "ENTRYYEAR",unique = true, nullable = true, length = 100)
	public String getEntryYear() {
		return entryYear;
	}
	public void setEntryYear(String entryYear) {
		this.entryYear = entryYear;
	}
	@Column(name = "HEADIMG",unique = true, nullable = true, length = 200)
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorDomain", fetch = FetchType.LAZY)
	public Set<StudentDomain> getStudents() {
		return students;
	}
	public void setStudents(Set<StudentDomain> students) {
		this.students = students;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restutorDomain", fetch = FetchType.LAZY)
	public Set<StudentDomain> getResStudents() {
		return resStudents;
	}
	public void setResStudents(Set<StudentDomain> resStudents) {
		this.resStudents = resStudents;
	}
	@Column(name = "MENTORSTATUS",unique = true, nullable = true, length = 11)
	public int getMentorStatus() {
		return mentorStatus;
	}
	public void setMentorStatus(int mentorStatus) {
		this.mentorStatus = mentorStatus;
	}
	
}
