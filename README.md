# Naver Homework Week3-2
1. [Summary](#summary)
2. [DTOs](#dtos)
   1. [Employee DTO](#employee-dto)
   2. [Department DTO](#department-dto)
3. [Get Department API](#get-department-api)
    1. [Department Example 1: Valid Input](#department-example-1-valid-input)
    2. [Department Example 2: Invalid Input](#department-example-2-invalid-input)
4. [Get Employee API](#get-employee-api)
   1. [Employee Example 1: Valid Input](#employee-example-1-valid-input)
   2. [Employee Example 2: Invalid Input](#employee-example-2-invalid-input)
## Summary
- Port: 9081
- Context Path: /likelion
- Logging Level Root: TRACE
- Logging File Name: service.log
- Logging Pattern: `%d{dd-MM-yyyy HH:mm:ss.SSS} %-5level %logger{50} : %msg%n`
## DTOs
### Employee DTO
```java
@Data
public class EmployeeDto {
    private Long employeeId;
    @NotEmpty(message = "Thiếu tên")
    @Size(min = 10, max = 50, message = "Tên nhân viên phải nằm trong khoảng 10 đến 50 ký tự")
    private String name;
    private Date birthDate;
    private String gender;
    @NotEmpty(message = "Thiếu email")
    @Email(message = "Sai định dạng email")
    private String email;
}
```
### Department DTO
```java
@Data
public class DepartmentDto {
    private Long departmentId;
    @NotEmpty(message = "Thiếu tên")
    @Size(min = 10, max = 50, message = "Tên phòng ban phải nằm trong khoảng 10 đến 50 ký tự")
    private String name;
    @NotEmpty(message = "Miêu tả không được rỗng")
    private String description;
    private List<@Valid EmployeeDto> employeeDtoList;
}
```
## Get Department API
- Endpoint: `POST /department/getDepartment`
- Body: Department DTO
### Department Example 1: Valid Input
- Request:
  ```json
    {
      "departmetnId":"",
      "name":"Tên đủ dài",
      "description":"Một phòng ban mới",
      "employeeDtoList":[
          {
              "employeeId":"",
              "name":"Tên vừa đủ",
              "email":"123@gmail.com"
          }
      ]
    }
  ```
- Response:
  ```json
  {
    "departmentId": null,
    "name": "Tên đủ dài",
    "description": "Một phòng ban mới",
    "employeeDtoList":
    [
        {
            "employeeId": null,
            "name": "Tên vừa đủ",
            "birthDate": null,
            "gender": null,
            "email": "123@gmail.com"
        }
    ]
  }
  ```
- Console:
    ```
    08-09-2022 04:36:13.408 INFO  c.e.n.aspect.DepartmentAndEmployeeServiceAspect : Before called execution(ResponseEntity com.example.naver_week32.controller.DepartmentController.getDepartmentDto(DepartmentDto))
    08-09-2022 04:36:13.426 INFO  c.e.n.service.impl.DepartmentServiceImpl : Đối số truyền vào: DepartmentDto(departmentId=null, name=Tên đủ dài, description=Một phòng ban mới, employeeDtoList=[EmployeeDto(employeeId=null, name=Tên vừa đủ, birthDate=null, gender=null, email=123@gmail.com)])
    08-09-2022 04:36:13.429 INFO  c.e.n.aspect.DepartmentAndEmployeeServiceAspect : After called execution(ResponseEntity com.example.naver_week32.controller.DepartmentController.getDepartmentDto(DepartmentDto))
    ```
### Department Example 2: Invalid Input
- Request:
  ```json
    {
      "departmetnId":"",
      "name":"Tên ngắn",
      "description":"",
      "employeeDtoList":[
          {
              "employeeId":"",
              "name":"Tên vừa đủ",
              "email":"123@gmail.com"
          }
      ]
    }
  ```
- Response:
  ```json
  {
    "timestamp": "2022-09-07T21:45:16.368+00:00",
    "status": 400,
    "error": "Bad Request",
    "path": "/likelion/department/getDepartment"
  }
  ```
- Console:
    ```
    08-09-2022 04:45:16.359 WARN  o.s.w.s.m.support.DefaultHandlerExceptionResolver : Resolved [org.springframework.web.bind.MethodArgumentNotValidException: Validation failed for argument [0] in public org.springframework.http.ResponseEntity<com.example.naver_week32.dto.DepartmentDto> com.example.naver_week32.controller.DepartmentController.getDepartmentDto(com.example.naver_week32.dto.DepartmentDto) with 2 errors: [Field error in object 'departmentDto' on field 'description': rejected value []; codes [NotEmpty.departmentDto.description,NotEmpty.description,NotEmpty.java.lang.String,NotEmpty]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [departmentDto.description,description]; arguments []; default message [description]]; default message [Miêu tả không được rỗng]] [Field error in object 'departmentDto' on field 'name': rejected value [Tên ngắn]; codes [Size.departmentDto.name,Size.name,Size.java.lang.String,Size]; arguments [org.springframework.context.support.DefaultMessageSourceResolvable: codes [departmentDto.name,name]; arguments []; default message [name],50,10]; default message [Tên phòng ban phải nằm trong khoảng 10 đến 50 ký tự]] ]
    ```
## Get Employee API
- Endpoint: `POST employee/getEmployee`
- Body: Employee DTO
### Employee Example 1: Valid Input
- Request:
  ```json
    {
    "employeeId":"",
    "name":"Tên vừa đủ",
    "email":"123@gmail.com"
    }
  ```
- Response:
  ```json
  {
    "employeeId": null,
    "name": "Tên vừa đủ",
    "birthDate": null,
    "gender": null,
    "email": "123@gmail.com"
  }
  ```
- Console:
    ```
    08-09-2022 04:53:30.365 INFO  c.e.naver_week32.service.impl.EmployeeServiceImpl : Đối số truyền vào: EmployeeDto(employeeId=null, name=Tên vừa đủ, birthDate=null, gender=null, email=123@gmail.com)
    ```
### Employee Example 2: Invalid Input
- Request:
  ```json
  {
    "employeeId":"",
    "name":"Tên ngắn",
    "email":"123"
  }
  ```
- Response: `400 Bad Request`
- Console:
    ```
    08-09-2022 04:56:11.146 INFO  c.e.n.aspect.DepartmentAndEmployeeServiceAspect : After called execution(ResponseEntity com.example.naver_week32.controller.EmployeeController.getEmployee(EmployeeDto,BindingResult)) undone
    ```