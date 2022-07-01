package ThreadLocal;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;

public class EmployeeWithAllData {
    public static void main(String[] args) throws JsonProcessingException {
//        EmployeeSkill employee = new EmployeeSkill();
//        employee.setAddress("NewYork");
//        employee.setAge(30);
//        employee.setName("David");
//        employee.setMobileNo("092121");
//        employee.setMarrired(false);
//        employee.setSkill("python");
//        employee.setSkillSet(new ArrayList<>());
//        employee.setFamilyMembers(new HashMap<>());

        String json = "{\n" +
                "  \"name\":\"David\",\n" +
                "  \"age\": 30\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        EmployeeSkill empObj =  objectMapper.readValue(json, EmployeeSkill.class);
        System.out.println(empObj.getAddress());
    }
}
