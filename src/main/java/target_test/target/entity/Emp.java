package target_test.target.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Emp {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int employeeid;

	
    @Column(nullable = false)
	private String firstname;
	
    @Column(nullable = false)
	private String lastname;

    
    @Column(nullable = false)
	private String department;


    @Column(nullable = false)
	private String costcenter;
    
   
    @Column(nullable = false)
	private long level;



	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getCostcenter() {
		return costcenter;
	}


	public void setCostcenter(String costcenter) {
		this.costcenter = costcenter;
	}


	public long getLevel() {
		return level;
	}


	public void setLevel(long level) {
		this.level = level;
	}
   

}
