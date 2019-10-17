# spring-dynamodb-example
Dynamodb notes, an example integrate dynamodb with spring boot using localstack using technology stacks:

- Spring boot 2.x.

- Spring data dynamodb 5.0.4 (5.1.0 has error dynamoDBMapperConfig).

- Mapstruct 1.3.1.Final.

- Maven.

# About Localstack
LocalStack is a fully functional local AWS cloud stack. It provides an easy-to-use test/mocking framework for developing Cloud applications. Currently, the focus is primarily on supporting the AWS cloud stack. [Link localstack github](https://github.com/localstack/localstack)

**Installation**

```
pip install localstack awscli-local
```

**Start**

```
localstack start
```

**UI Web Dashboard**

```
localhost:8080
```

# About dynamodb
  
Amazon DynamoDB is a key-value and document database that delivers single-digit millisecond performance at any scale. It's a fully managed, multiregion, multimaster, durable database with built-in security, backup and restore, and in-memory caching for internet-scale applications. DynamoDB can handle more than 10 trillion requests per day and can support peaks of more than 20 million requests per second.

**[Usecase](https://aws.amazon.com/dynamodb/)**

- Ad Tech

- Gaming

- Retail

- Banking and Finance

- Media and entertainment

....
