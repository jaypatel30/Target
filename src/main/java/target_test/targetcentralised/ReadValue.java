package target_test.targetcentralised;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import target_test.target.entity.Emp;

public class ReadValue {

	 public List<Emp> readEmployeesFromCSV(String fileName) {
		 
	        List<Emp> employees = new ArrayList<>();

	        try (FileReader reader = new FileReader(fileName);
	             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withHeader())) {

	            for (CSVRecord csvRecord : csvParser) {
	                String firstName = csvRecord.get("FirstName");
	                String lastName = csvRecord.get("LastName");
	                String department = csvRecord.get("Department");
	                String costCenter = csvRecord.get("CostCenter");

	                Emp employee = new Emp();               
	                employee.setFirstname(csvRecord.get("FirstName"));
	                employee.setLastname(csvRecord.get("LastName"));
	                employee.setDepartment(csvRecord.get("Department"));
	                employee.setCostcenter(csvRecord.get("CostCenter"));
	                employee.setLevel(Long.parseLong(csvRecord.get("Level")));
	               
	                employees.add(employee);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return employees;
	    }
	
}
