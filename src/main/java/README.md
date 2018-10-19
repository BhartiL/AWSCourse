# Git-Hub Url
https://github.com/BhartiL/AWSCourse

----
## Student:
### Create student
Method: POST
AWS URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student

Payload:
```
{
   "studentName": "Bharti Ladhani",
        "photo": "photo1.jpg",
        "programId": "CSYE",
       "courses": "CSYE9810"
  }
  ```
  
### Get all students
   Method: GET
   URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/
   
  ### Get student by student ID
  Method: GET
   URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/{studentId}
  
  Ex.: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1
  
  
### GET student based on program Id:
Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/program/{programId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/program/IS

Note: You should have a program object created first.
  
### DELETE student 
Method: DELETE

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/{studentId}

Ex.: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1
   
### Update student info 
Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/{studentId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1

Payload:
```
{
   "studentName": "Jeff Bezos",
        "photo": "photo1.jpg",
        "programId": "IS",
       "courses": "CSYE9810"
  }
  ```
  
### Enroll student into a program
Method: PUT
http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/{studentId}/program/{programId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1/program/CS

### Enroll student into a course
Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/{studentId}/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1/course/Info123

-------------------------------------------------------------------------------------------------------------------------------
 ## Professor:

### Create professor
 
 Method: POST

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor

Postman URL:http://localhost:8080/courseservice3/webapi/professor

Payload:
```
{
	"firstName" : "Prof3",
	"department": "Dept2",
	"joiningDate": "2018-01-01"

}
```

### Get all professors

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor

### Get one particular professor

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/{professorID}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/1

### Update professor

Method: PUT 

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/{professorID}

Payload: 
```
{

	"professorId" : "3",
	"firstName" : "Prof3",
	"department": "Dept2",
	"joiningDate": "2018-01-01"

}
```


### Delete professor

Method: DELETE 

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/{professorID}

-------
  
 ## Course:
 
### Create a course

Method: POST

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course

Payload: 
 ```
 {
   		"courseId":"CSYE9810",
        "programId": "CSYE",
        "professorId": 1,
        "studentTAId":  1,
        "board": "board1",
        "roster": "roster1"
   }
 ```
 
### Get all courses

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course

### Get one particular course

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345
  
### Update course

Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}

Payload: 
 ```
 {
   		"courseId":"CSYE9810",
        "programId": "CSYE",
        "professorId": 1,
        "studentTAId":  1,
        "board": "board1",
        "roster": "roster1"
   }
 ```
Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345
   
### Delete course
Method: DELETE

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345
   
### Register student into course

Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}/student/{studentId} 

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info123/student/1

### Map program to course
Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}/program/{programId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info123/program/CS
   
### POST a new lecture in course
Method: POST

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}/lecture

Ex : http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/INFO123/lecture

Payload:
```
{
   		"materials": ["material1","material2"],
        "notes": ["notes1", "notes2"]
}
```

### Get all lectures for course

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}/lecture

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345/lecture

### Get one particular lecture for course

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}/lecture/{lectureId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345/lecture/1

### Update one particular lecture for course

Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/{courseId}/lecture/

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345/lecture/

Payload:
```
{       
        "lectureId" : 1,
   		"materials": ["material1","material2"],
        "notes": ["notes1", "notes2"]
}
```

------------
## Program

### Create a program

Method: POST

URL : http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program

Payload: 
``` 
{
   		"programId":"CSYE",
   		"programName": "Computer Systems Engineering"
   		
}
```

### Get all progreams

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program

### Get one particular program

Method: GET

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/{programId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/IS

### Update program

Method: PUT

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/{programId}

Payload: 
 ```
  {
        "courses": ["INFO123", "INFO567"],
        "enrolledStudents": ["1", "2", "6"],
        "programId": "CSYE",
        "programName": "Computer Systems Engineering"
    }
 ```

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345
   
### Delete program
Method: DELETE

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/{programId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/CS

### Map program to a course
Method: PUT

URL : http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/{programId}/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/IS/course/Info9850

### Map student to a program
Method: PUT

URL : http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/{programId}/student/{studentId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/program/IS/student/1
