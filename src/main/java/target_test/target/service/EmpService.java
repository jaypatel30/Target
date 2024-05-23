package target_test.target.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import target_test.target.entity.Emp;
import target_test.target.repo.EmpRepo;

@Service
public class EmpService {
	
	@Autowired
	public EmpRepo emprepo;
	
	
	
	public String createEmp(Emp emp) {
		
		emprepo.save(emp);
	
		return "Success";
	}
	
	

}
