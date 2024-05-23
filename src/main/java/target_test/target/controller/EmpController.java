package target_test.target.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.Column;
import target_test.target.entity.Emp;
import target_test.target.service.EmpService;



@RestController
@CrossOrigin
public class EmpController {
	

	
	@Autowired
	public EmpService empService;
	
	@GetMapping("/hell")
	public String printHelloworld() {
		return "Hello worsdfsadfsfasdfld";
	}
	
	@PostMapping("/register")
	public String regsiterAdminDetails() {	
		
			
		 String csvFile = "/target/src/main/resources/static/employee.csv";
	        String line;
	        String cvsSplitBy = ",";

//	        List<Emp> employees = new ArrayList<>();

	        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
	            br.readLine();
	            while ((line = br.readLine()) != null) {
	                String[] fields = line.split(cvsSplitBy);                
	                
	                Emp employee = new Emp();               
	                employee.setFirstname(fields[1]);
	                employee.setLastname(fields[2]);
	                employee.setDepartment(fields[3]);
	                employee.setCostcenter(fields[4]);
	                employee.setLevel(Long.parseLong(fields[5]));
	        		return empService.createEmp(employee);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

		return "Failed";
	}
	

}