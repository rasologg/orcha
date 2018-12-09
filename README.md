Simple mobile provisioning system build on top of Activiti Cloud with Apache Kafka

#Requirement
To run the system you need Docker, Postgresql, Keycloak and Kafka broker.

##Start Apache Kafka
I use the landoop distribution because, it's easy to use the docker image
```console
docker run --rm -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost landoop/fast-data-dev:latest
```

##Start Keycloak
```console
docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8080 -d jboss/keycloak
```
- Create a realm : provisioning
- Create a client : provisioning
- Create roles : ACTIVITI_USER, ACTIVITI_ADMIN
- Create an user and attribute the roles above.

##Start Postgres
```console
docker run --name postgres -e POSTGRES_PASSWORD=rootpwd -d postgres
```

- Create a database : provisioningdb, querydb and auditdb

##Start provisioning-rb
You can start the application with your IDE or by maven command line.

The actual version of Activiti Cloud has this bug https://github.com/Activiti/Activiti/issues/2247 with Apache Kafka.
You must override the system variable ACT_INT_RES_CONSUMER to bypass the problem, for example ACT_INT_RES_CONSUMER=integrationResult_provisioning

##Start all the connectors
Don't forget to change the server.port, and ACT_INT_RES_CONSUMER with the same value as provisioning-rb

##Provision one mobile line
Send a request to http://<provisioning-rb_host : provisioning-rb_port>/provision
Method: POST
Body :
{
	"customer_id":"c0001",
	"simcard_id":"sim0001"
}