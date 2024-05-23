package target_test.target;

import static org.junit.Assert.assertEquals;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import target_test.target.entity.Emp;
import target_test.targetcentralised.ReadValue;

public class ReaderTest {


public ReadValue readertext;
private final String testName = "employee.csv";

@Before
public void setUp() throws IOException {
	readertext = new ReadValue();
    // Create a test CSV file
    try (FileWriter writer = new FileWriter(testName)) {
        writer.append("EmployeeID,FirstName,LastName,Department,CostCenter,Level");
        writer.append("1,Virat,Kholi,EC,101,50");
        writer.append("2,Jay,Patel,CSE,102,40");
        writer.append("3,Jay2,Patel2,ME,102,40");
        writer.append("4,Jay3,Patel3,CIVIL,102,40");
        writer.append("3,Bob,Brown,EX,103,300");
    }
}

@Test
public void testReadEmployeesFromCSV() {
    List<Emp> employees = readertext.readEmployeesFromCSV(testName);

    assertEquals(3, employees.size());

    Emp emp1 = employees.get(0);
    assertEquals("Virat", emp1.getFirstname());
    assertEquals("Kholi", emp1.getLastname());
    assertEquals("EC", emp1.getDepartment());
    assertEquals("101", emp1.getCostcenter());
    assertEquals(50, emp1.getLevel());

  
}
}