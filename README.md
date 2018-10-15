# SpringBootWebServices
## Alexa Json Parser

Please find the below prerequisite to run the application

### Install postgresql/Pgadmin(any version is fine).
### Database name is alexa,username of database is postgres and password is admin.

##Explanation
The problem statement was to read Json file and push the data to any sql/nosql db and write the WS to retrive the value.

For the above requirement i used postgresql as database to store the content of json and spring boot i used to write web services because of container less deployment and configurations are very easy to make with spring boot.

clone the source code to IDE.May be you can use STS as IDE and run the appliction.Its based on mvc design pattern. after successfully running the application you can test the get api in postman or ARC or browser also.

Please find the below API.
##Get all the records/without any filter: http://localhost:8080/api/review/search

##filter by review date:
http://localhost:8080/api/review/search?review_date=2018-02-26

##filter by ratings:http://localhost:8080/api/review/search?rating=4

##filter by store_type:
http://localhost:8080/api/review/search?store_type=GooglePlayStore

