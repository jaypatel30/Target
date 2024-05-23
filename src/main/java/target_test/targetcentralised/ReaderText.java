package target_test.targetcentralised;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import target_test.target.entity.Emp;

public class ReaderText {
	public static void main(String[] args) {
        String csvFile = "employee.csv";
        String line;
        String cvsSplitBy = ",";

        List<Emp> employees = new ArrayList<>();

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
                employees.add(employee);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
