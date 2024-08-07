# Food Delivery Service

## Description
This is a food delivery application with Microservice based architecture. 
It is developed using Java, Spring Boot, Maven, Angular, TypeScript, JavaScript, NPM, Node, Yarn, MySQL, MongoDB, Eureka.
It is built using Docker and Kubernetes and deployed on AWS.

## Installation
It has 2 parts:
1. **Backend:** 

    It has 5 microservices:
    - Eureka - Service Registry
    - Order - Order Service
    - FoodCatalogue - Food Catalogue Service
    - RestarurantListing - Restaurant Listing Service
    - UserInfo - User Information Service
   
   
   Steps to run the backend:
- cd to each microservice
- Run Eureka service first of all
- Run the following command to build in each project

```bash
    mvn clean install
   ```
- Run the following command to run the project

```bash
    mvn spring-boot:run
   ```
       
2. **Frontend**
    Steps to run the frontend:
- Clone the repository
- Run the following command to install the dependencies

```bash
    npm install
   ```
- Run the following command to run the project

```bash
    ng serve
   ```

## Usage
- The application is a food delivery application where users can order food from different restaurants.
- The application has list of restaurants and food items. 
- The user can select the restaurant and add the food items to the cart.
- The user can place the order and it shall be shown in his order history.

