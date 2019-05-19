Simple mobile provisioning system build on top of Activiti Cloud with Apache Kafka

# Requirement

To run the system you need Docker, Postgresql, Keycloak and Kafka broker.

## Start Apache Kafka

I use the landoop distribution because it's easy to run but you can use another distribution.

```console
docker run --rm -p 2181:2181 -p 3030:3030 -p 8081-8083:8081-8083 -p 9581-9585:9581-9585 -p 9092:9092 -e ADV_HOST=localhost landoop/fast-data-dev:latest
```

## Start Keycloak

```console
docker run -e KEYCLOAK_USER=admin -e KEYCLOAK_PASSWORD=admin -p 8180:8080 -d jboss/keycloak
```

- Create a realm : provisioning
- Create a client : provisioning
- Create roles : ACTIVITI_USER, ACTIVITI_ADMIN
- Create an user and attribute the roles above.

## Start Postgres

```console
docker run --name postgres -e POSTGRES_PASSWORD=rootpwd -d -p 5432:5432 postgres
```

- Create a database : provisioningdb, querydb and auditdb

## Start provisioning-rb

You can start the application with your IDE or by maven command line.

## Start all the connectors

Don't forget to change the server.port

## Provision one mobile line

Send a request using Postman, curl... to http://<provisioning-rb_host : provisioning-rb_port>/provision
Method: POST
Body :
```json
{
	"customer_id":"c0001",
	"simcard_id":"sim0001"
}
```
