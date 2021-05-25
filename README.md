# Virtual Currency Management Tool
API to manage virtual currency and transfer them between users.

## Built With
* Java 12.2
* Spring Boot
* H2 in-memory DB
* Maven
* Swagger
* Actuator

### Build and Run
* Build with Maven.

Download the app. go inside project folder and run this maven commend.

`$ mvn clean install`

`$ mvn clean package spring-boot:run`

## Using the endpoints
* Once the app is up and running. you can check API documentation from this url
[Swagger API Documentation](http://localhost:8080/swagger-ui.html)

## Scenario Steps
* Create new account.
	http://localhost:8080/api/v1/accounts 	  					POST Create new account {userName, email, password}
* Get list of all accounts.
	http://localhost:8080/api/v1/accounts      					GET  List all account 
* send account-id in header as mock.
* Transfer VC to users.
	http://localhost:8080/api/v1/transfer 	  					POST Transfer vc to users {{ "accountToReceived" : [{ "accountId" : 1,"amount" : 0.2}]}}
* Get List of transactions
	http://localhost:8080/api/v1/account/transaction 	  		GET List of all transactions


## access H2 Data 
http://localhost:8080/h2
* username/password sa/sa


## Actuator
* The project uses spring actuator for monitoring.
* [actuator metrics](http://localhost:8080/actuator/metrics)
* [actuator env](http://localhost:8080/actuator/env)
* [actuator health](http://localhost:8080/actuator/health)


