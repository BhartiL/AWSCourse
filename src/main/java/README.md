# Git-Hub Url
https://github.com/BhartiL/AWSCourse/tree/assignment3/src/main/java

# AWS URL
http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com
----

 ## Professor:

### Create professor
 
Method: POST

URL: /webapi/professor

Payload:
```
{
    "department": "CSYE",
    "firstName": "Avinav",
    "joiningDate": "09/11/2018",
    "lastName": "Jami2",
    "professorId": "10"

}
```

### Get one particular professor

Method: GET

URL: /webapi/professor/{professorId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/1

### Update professor

Method: PUT 

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/{professorId}

Payload: 
```
{
    "department": "IS",
    "firstName": "Avinav",
    "joiningDate": "09/12/2018",
    "lastName": "Jami",
}
```


### Delete professor

Method: DELETE 

URL: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/professor/{professorId}

-------

 ## Course:
 
### Create a course

Method: POST

URL: /webapi/course

Payload: 
 ```
 {
	"courseId":"Info2345",
	"taId":"Jing",
	"department":"IS",
	"boardId": "board1",
	"professorId":"Jami.Avinav"
   }
 ```
### Get one particular course

Method: GET

URL: /webapi/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345
  
### Update course

Method: PUT

URL: /webapi/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345

Payload: 
 ```
 {
   	"taId":"Jing1",
	"department":"MIS",
	"boardId": "board2",
	"professorId":"Jami.Avinav1"
   }
 ```
   
### Delete course
Method: DELETE

URL: /webapi/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info2345
   

### Add board to course
Method: PUT

URL: /webapi/course/{courseId}/board/{boardId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/Info123/board/board1
   
### Add professor to course
Method: POST

URL: /webapi/course/{courseId}/professor/{professorId}

Ex : http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/course/INFO123/professsor/2

----------

## Board

### Create a Board

Method: POST

URL : /webapi/board

Payload: 
``` 
{
    "boardId": "board3",
    "courseId":"CSYE899"
}
```

### Get board by board Id

Method: GET

URL: /webapi/board/{boardId}

### Update board

Method: PUT

URL: /webapi/board/{boardId}

Payload: 
 ```
  {
    "courseId":"CSYE8991"
}
 ```   
### Delete board
Method: DELETE

URL: /webapi/board/{boardId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/board/board2

### add/update course for board
Method: PUT

URL: /webapi/board/{boardId}/course/{courseId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/board/board2/course/Info3456

------------
## Student:
### Create student
Method: POST
URL: /webapi/student

Payload:
```
{
	"studentId":"103",
	"department":"CS",
	"firstName": "Cannolie",
	"joiningDate":"08/09/2018",
    	"lastName": "Srock",
    	"emailId":"ladhani.b@husky.neu.edu"
  
  }
  ```
  
### Get student by student id
Method: GET
   
URL: webapi/student/{studentId}

Ex.: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1
  
  
### Delete student 
Method: DELETE

URL: /webapi/student/{studentId}

Ex.: http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/1
   
### Update student info 
Method: PUT

URL: /webapi/student/{studentId}

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/10

Payload:
```
{
	"department":"IS",
	"firstName": "Testing Update",
	"joiningDate":"08/08/9999",
    	"lastName": "T",
    "emailId":"ladhani.b@husky.neu.edu"
  }
  ```
  
### Register course for student
Method: POST

URL: /webapi/student/{studentId}/register

Ex. http://bhartiapp-env.vjipgaziy2.us-east-2.elasticbeanstalk.com/webapi/student/10/register

Payload:
```
{
	"courseId":"INFO6100"
}
  
```
---------------
## Announcement
Method: POST

URL : /webapi/announcement
Payload:
``` 
{
	"announcementId":"101",
	"announcementText":"Text1",
	"boardId":"board18"
	
}
```
### Get one announcement

Method: GET

URL: /webapi/announcement/{boardId_announcementId}

### Get all announcements for board Id

Method: GET

URL: /webapi/announcement/board/{boardId}

### Update Announcement 

Method: PUT

URL: /webapi/announcement/{boardId_announcementId}

Payload(boardId and announcementId are optional): 
 ```
  {
       "announcementId":"101",
	"announcementText":"Text1",
	"boardId":"board18"
	
}
 ```
### Delete Announcement
Method: DELETE

URL: /webapi/announcement/{boardId_announcementId}

------------

#Steps to post announcement:
1. Create course using Course POST API
2. Create board for course using board POST API
3. Create student using student POST API
4. Register student using student POST API for register action. 
With step 4, student will receive email to confirm subscription. Click on the link to  Confirm. 
5. Post an announcement using Announcement POST API.
This will cause deployed lambda function to publish the SNS message to the subscriber, i.e. student's email. 


