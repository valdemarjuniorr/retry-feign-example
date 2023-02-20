# Retry Feign Example
Spring boot application using OpenFeign Retry feature.

## Features
- Java 17
- Spring 2.7.8
- OpenFeign

## How to start
Clone the project:
```
$ git clone git@github.com:valdemarjuniorr/retry-feign-example.git
```
And then start the application running:
```
$ mvn spring-boot:run
```
To check if it's working run the cURL command below:
```
$ curl --location 'http://localhost:8080/retry'
```
The response expected is:
```json
{
  "userId": 1,
  "title": "delectus aut autem",
  "completed": false
}
```
**Everything ready to start**.

## Example
To see OpenFeign Retry feature working run the curl command below:
```
$ curl --location 'http://localhost:8080/retry/timeout'
```
After run it, it will be able to see in the log `request timeout occurs` appearing 3 times. It means OpenFeign client is the endpoint 
`/mock/timeout` 3 times, before it returns error. This configuration is set on `application.yml` file, in the property `retry.maxAttempts`.

In the class `CustomErrorDecoder` is set which exceptions will throw a RetryException and make OpenFeign retrying que request again:
- `REQUEST_TIMEOUT`
- `BAD_GATEWAY`
- `GATEWAY_TIMEOUT`
- `SERVICE_UNAVAILABLE`

In case any exceptions differ from those, OpenFeign will not retry a new request. It is possible to see this behavior running the curl:
```
$ curl --location 'http://localhost:8080/retry/internalerror'
```
And the `Generic Exception` will be thrown immediately.