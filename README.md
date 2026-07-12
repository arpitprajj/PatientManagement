# PatientManagement

> A microservices-based patient management system implemented in Java.

![Build status](https://img.shields.io/github/actions/workflow/status/arpitprajj/PatientManagement/ci.yml?style=for-the-badge&logo=githubactions&logoColor=white&label=CI) ![GitHub stars](https://img.shields.io/github/stars/arpitprajj/PatientManagement?style=for-the-badge&logo=github) ![GitHub forks](https://img.shields.io/github/forks/arpitprajj/PatientManagement?style=for-the-badge&logo=github) ![GitHub issues](https://img.shields.io/github/issues/arpitprajj/PatientManagement?style=for-the-badge&logo=github) ![Last commit](https://img.shields.io/github/last-commit/arpitprajj/PatientManagement?style=for-the-badge&logo=github)

## 📑 Table of Contents

- [Description](#description)
- [Key Features](#key-features)
- [Use Cases](#use-cases)
- [Tech Stack](#tech-stack)
- [Quick Start](#quick-start)
- [Key Dependencies](#key-dependencies)
- [Project Structure](#project-structure)
- [Contributors](#contributors)
- [Contributing](#contributing)

## 📝 Description

PatientManagement is a distributed, microservices-based platform designed for healthcare administration and clinical data tracking. The project addresses the complexity of modern healthcare IT systems by dividing core responsibilities into dedicated, independent services. This architectural division provides isolated environments for handling patient records, billing operations, and system-wide authentication securely.

## ✨ Key Features

- **🔀 Centralized API Gateway** — Routes incoming external client traffic to the appropriate backend microservices efficiently.
- **🏥 Dedicated Patient Service** — Manages core patient demographic information and medical records independently.
- **💳 Integrated Billing Service** — Handles financial operations, transactional invoicing, and payment processing records.
- **📨 Event-Driven Kafka Integration** — Facilitates asynchronous, event-driven communication between microservices using Apache Kafka.
- **🔐 Isolated Authentication Service** — Manages user identity and access control across the entire microservice ecosystem.
- **☸️ Kubernetes Orchestration Configs** — Provides Kubernetes deployment manifests for orchestrating containerized application instances.

## 🎯 Use Cases

- Deploying a scalable microservices architecture for managing patient records and healthcare billing.
- Developing event-driven Java applications that communicate asynchronously via Apache Kafka.
- Testing and simulating distributed transactions and routing using an API Gateway and local containers.

## 🛠️ Tech Stack

![Java (Maven)](https://img.shields.io/badge/Java%20(Maven)-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

## ⚡ Quick Start

```bash

# 1. Clone the repository
git clone https://github.com/arpitprajj/PatientManagement.git

# Build with Maven
mvn install
```

## 📦 Key Dependencies

```
protobuf-java: managed
spring-boot-starter-web: managed
spring-kafka: managed
spring-boot-starter-test: managed
```

## 📁 Project Structure

```
.
├── analytics-service
│   ├── .mvn
│   │   └── wrapper
│   │       └── maven-wrapper.properties
│   ├── analytics-service.yaml
│   ├── dockerfile
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── ...
│       │   ├── proto
│       │   │   └── patient_event.proto
│       │   └── resources
│       │       └── application.properties
│       └── test
│           └── java
│               └── com
│                   └── ...
├── api-gateway
│   ├── .mvn
│   │   └── wrapper
│   │       └── maven-wrapper.properties
│   ├── api-gateway-docker.yaml
│   ├── dockerfile
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       └── main
│           ├── java
│           │   └── com
│           │       └── ...
│           └── resources
│               ├── application-prod.yaml
│               └── application.yaml
├── auth-service
│   ├── .mvn
│   │   └── wrapper
│   │       └── maven-wrapper.properties
│   ├── auth-service-db.yaml
│   ├── auth-service.yaml
│   ├── dockerfile
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── ...
│       │   └── resources
│       │       ├── application.properties
│       │       └── data.sql
│       └── test
│           └── java
│               └── com
│                   └── ...
├── billing-service
│   ├── .mvn
│   │   └── wrapper
│   │       └── maven-wrapper.properties
│   ├── billing-service.yaml
│   ├── dockerfile
│   ├── mvnw
│   ├── mvnw.cmd
│   ├── pom.xml
│   └── src
│       ├── main
│       │   ├── java
│       │   │   └── com
│       │   │       └── ...
│       │   ├── proto
│       │   │   └── billing_service.proto
│       │   └── resources
│       │       └── application.properties
│       └── test
│           └── java
│               └── com
│                   └── ...
├── docker-kafka.yaml
├── infrastructure
│   └── localstack-deploy.sh
├── integration-tests
│   ├── pom.xml
│   └── src
│       └── test
│           └── java
│               ├── AuthIntegrationTest.java
│               └── PatientIntegrationTest.java
├── k8s
│   ├── analytics-deployment.yaml
│   ├── analytics-service.yaml
│   ├── auth-deployment.yaml
│   ├── auth-mysql-deployment.yaml
│   ├── auth-mysql-service.yaml
│   ├── auth-service.yaml
│   ├── billing-deployment.yaml
│   ├── billing-service.yaml
│   ├── gateway-deployment.yaml
│   ├── gateway-service.yaml
│   ├── kafka-deployment.yaml
│   ├── kafka-service.yaml
│   ├── mysql-deployment.yaml
│   ├── mysql-service.yaml
│   ├── patient-deployment.yaml
│   └── patient-service.yaml
└── patient-service
    ├── .mvn
    │   └── wrapper
    │       └── maven-wrapper.properties
    ├── dockerfile
    ├── mvnw
    ├── mvnw.cmd
    ├── mysql-docker.yaml
    ├── patient-service.yaml
    ├── pom.xml
    └── src
        ├── main
        │   ├── java
        │   │   └── com
        │   │       └── ...
        │   ├── proto
        │   │   ├── billing_service.proto
        │   │   └── patient_event.proto
        │   └── resources
        │       └── application.properties
        └── test
            └── java
                └── com
                    └── ...
```

## 👥 Contributors

Thanks to everyone who has contributed to this project:

<p align="left">
<a href="https://github.com/arpitprajj" title="arpitprajj"><img src="https://avatars.githubusercontent.com/u/98028010?v=4&s=64" width="64" height="64" alt="arpitprajj" style="border-radius:50%" /></a>
</p>

[See the full list of contributors →](https://github.com/arpitprajj/PatientManagement/graphs/contributors)

## 👥 Contributing

Contributions are welcome! Here's the standard flow:

1. **Fork** the repository
2. **Clone** your fork: `git clone https://github.com/arpitprajj/PatientManagement.git`
3. **Branch**: `git checkout -b feature/your-feature`
4. **Commit**: `git commit -m 'feat: add some feature'`
5. **Push**: `git push origin feature/your-feature`
6. **Open** a pull request

Please follow the existing code style and include tests for new behavior where applicable.

---

<div align="center">

[![Made with ReadmeBuddy](https://img.shields.io/badge/Made%20with-ReadmeBuddy-8B5CFF?style=for-the-badge&logo=markdown&logoColor=white)](https://readmebuddy.com)

<sub>Generate beautiful READMEs in seconds → <a href="https://readmebuddy.com">readmebuddy.com</a></sub>

</div>
