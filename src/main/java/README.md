# Git-Hub Url
https://github.com/BhartiL/AWSCourse/tree/assignment4/src/main/java

# AWS URL
http://ladhanib-assignment4.us-east-2.elasticbeanstalk.com


#Workflow
1. Use course POST method(sample request below) to post a course and note down the course Id.
2. CourseHandler.java lambda will identify the event and trigger step function if course is New. 
3. Step function will check if the department is 'Seminars' or not. 
4. If it's Seminars, intermediate steps are skipped and execution goes to end step. 
5. Registrar Lambda executes now. It executes a HTTP POST request to enter record in registrar table if department is not 'Seminars'.
6. Next, step function calls GenerateUUID.py lambda to create a boardID. 
7. Using above boardId and courseId, record is created in Board table.
8. Course record is updated with above boardId. 
9. Step function exists with success code. 
10. Call get methods for board, course and registrar to confirm that above workflow did the job.
----


 
### Create a course

Method: POST

URL: /webapi/course

Payload: 
 ```
 {
    "courseId": "CS9999",
    "department": "CSYE",
    "professorId": "Jami.Avinav233",
    "taId": "Jing7"
  }
 ```
 
### Get one particular course

Method: GET

URL: /webapi/course/{courseId}

Ex. http://ladhanib-assignment4.us-east-2.elasticbeanstalk.com/webapi/course/Info2345

### Get all registrar objects

Method: GET

URL: /webapi/registrar


###Get all boards
Method: GET

URL: /webapi/board
  







