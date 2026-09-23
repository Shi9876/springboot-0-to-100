package com.learn.springboot.dev.module2SpringBootWebTutorialApplication.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

//POJO class - Plain Old Java Object (which is used to define some entities in our code)
//no custom logic define here
public class EmployeeDTO {  //this is our POJO class
    private Long id;

   // @NotNull(message = "Required field in Employee: name")
   // @NotEmpty(message = "Name of the employee cannot be empty")
   @NotBlank(message = "Name of the employee cannot be blank")
   @Size(min = 3, max = 10, message = "Number of characters in name should be in the range: [3, 10]")
    private String name;

   @NotBlank(message = "Email of the employee cannot be blank")
   @Email(message = "Email should be a valid email")
    private String email;

   @Max(value = 80, message = "Age of Employee cannot be greater than 80")
   @Min(value = 18, message = "Age of Employee cannot be less than 18")
    private Integer age;

   @NotBlank(message = "Role of the employee cannot be blank")
   @Pattern(regexp = "^(ADMIN|USER)$", message = "Role of Employee can either be USER or ADMIN")
   private String role; //ADMIN, USER

    @NotNull(message = "Salary of employee should be not null")
    @Positive(message = "Salary of Employee should be positive")
    @Digits(integer = 6, fraction = 2, message = "The salary can be in the form XXXXXX.YY")
    @DecimalMax(value = "100000.99")
    @DecimalMin(value = "100.50")
    private Double salary;

    @PastOrPresent(message = "DateOfJoining field in Employee cannot be in the future")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    private  Boolean isActive;

    public EmployeeDTO(){   //default constructor

    }

    public EmployeeDTO(Long id, String name, String email, Integer age, String role, Double salary, LocalDate dateOfJoining, Boolean isActive){     //all argument constructor
    this.id = id;
    this.name = name;
    this.email = email;
    this.age = age;
    this.role = role;
    this.salary = salary;
    this.dateOfJoining = dateOfJoining;
    this.isActive = isActive;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole(){
        return role;
    }

    public void setRole(String role){
        this.role = role;
    }

    public Double getSalary(){
        return salary;
    }

    public void setSalary(Double salary){
        this.salary = salary;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
