package com.learn.springboot.dev.module2SpringBootWebTutorialApplication.Controllers;

import com.learn.springboot.dev.module2SpringBootWebTutorialApplication.dto.EmployeeDTO;
import com.learn.springboot.dev.module2SpringBootWebTutorialApplication.entities.EmployeeEntity;
import com.learn.springboot.dev.module2SpringBootWebTutorialApplication.repositories.EmployeeRepository;
import com.learn.springboot.dev.module2SpringBootWebTutorialApplication.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employees") //path for the parent
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public String getMySuperSecretMessage(){
//        return "Secret message: aadea668ASE";
//    }

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/{employeeId}") //make sure that user provides the employee id
//    public EmployeeDTO getEmployeeById(@PathVariable Long employeeId){//mandatory data
//        return new EmployeeDTO(employeeId, "Shivanshi", "shiv@gmail.com", 25, LocalDate.of(2026, 9, 2), true);
//    }

    //For using different variable names - (/{employeeId} and id)
//    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){//other way to define if we want to rename it instead of employeeId to id only
//        //return new EmployeeDTO(id, "Shivanshi", "shiv@gmail.com", 25, LocalDate.of(2026, 9, 2), true);
//    }
//
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){
    return employeeService.getEmployeeById(id);
}


    //this - (name ="inputAge"), we use when we want different names for the input and the code
//    @GetMapping
//    public String getAllEmployees(@RequestParam(required = false, name ="inputAge") Integer age,
//                                  @RequestParam(required = false) String sortBy) {// optional data
//    return "Hi age "+ age +" "+sortBy;
//    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false, name ="inputAge") Integer age,
                                  @RequestParam(required = false) String sortBy) {// optional data

        return employeeService.getAllEmployees();//all the employee that we having will return from here
    }

//    @PostMapping //for creating new resource
//    public String createNewEmployee(){
//        return "Hello from Post";
//    }

//    @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//        inputEmployee.setId(100L);  //so user no need to provide the id, we will provide it
//        return inputEmployee;
//    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        return employeeService.createNewEmployee(inputEmployee); //saving the employee and not returning any optional
    }

    @PutMapping(path = "/{employeeId}") //updating the whole resource
    public EmployeeDTO updateEmployeeById(@RequestBody EmployeeDTO employeeDTO,
                                          @PathVariable Long employeeId) {
       return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){
       return employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")//to update some employee with some partial data
    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates,
                                             @PathVariable Long employeeId){
        return employeeService.updatePartialEmployeeById(employeeId, updates);
    }
}


/*
 * ========================= REST API NOTES =========================
 *
 * 1. @RestController
 * ------------------
 * @RestController is used to create REST APIs in Spring Boot.
 *
 * It combines:
 *      @Controller + @ResponseBody
 *
 * It tells Spring that the class will handle HTTP requests and
 * return data directly in the HTTP response, usually as JSON.
 *
 *
 * 2. @ResponseBody
 * ----------------
 * @ResponseBody tells Spring to return the method's result directly
 * as the response body instead of resolving it as a view.
 *
 * With @RestController, @ResponseBody is already included, so we
 * normally don't need to use it separately.
 *
 *
 * 3. Jackson
 * ----------
 * Spring Boot Web uses the Jackson library to convert data between
 * JSON and Java objects.
 *
 *      Java Object → JSON  = Serialization
 *      JSON → Java Object  = Deserialization
 *
 *
 * 4. GET Request
 * --------------
 * GET is mainly used to retrieve data from the server.
 *
 * Example:
 *      GET /employees
 *
 * A GET request can easily be tested using a browser because the
 * request can be made directly through the URL.
 *
 *
 * 5. POST Request
 * ---------------
 * POST is commonly used to send data to the server, for example,
 * when creating a new employee.
 *
 * The data is usually sent inside the request body as JSON.
 *
 * A browser's address bar cannot be used to send a POST request
 * with a custom request body, so we can use tools like Postman
 * during development.
 *
 *
 * 6. Postman
 * ----------
 * Postman is a tool used to test REST APIs.
 *
 * We can use it to send HTTP requests such as:
 *      GET, POST, PUT, DELETE, etc.
 *
 * We can also send JSON data in the request body.
 *
 *
 * 7. @RequestBody
 * ---------------
 * @RequestBody is used to receive data sent by the client
 * in the HTTP request body.
 *
 * Spring uses Jackson to convert the incoming JSON into the
 * required Java object.
 *
 * Example:
 *
 * Client / Postman
 *       ↓
 *   JSON Request
 *       ↓
 *  @RequestBody
 *       ↓
 * Java Object / DTO
 *       ↓
 *   Controller
 *       ↓
 *    Service
 *
 *
 * 8. Creating a New Employee
 * ---------------------------
 * When creating an employee:
 *
 * - The client sends employee details as JSON.
 * - @RequestBody receives the request body.
 * - Jackson converts the JSON into a Java object/DTO.
 * - The Controller receives this object.
 * - The Controller passes it to the Service layer.
 * - The Service handles the business logic.
 *
 * Can use ResponseEntity to return the status code
 * =================================================================
 */