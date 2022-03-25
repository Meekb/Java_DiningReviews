# Java_DiningReviews

## Overview
RESTful Dining Review API with data persistence built in Java using Spring and Spring Data JPA.  
Dining Review API designed for folks with allergies. Users indicated interest in any or all of three categories - peanut, egg, dairy.
Restaurants are rated in each category, and have an overall rating. Reviews contain username and optional scores for peanut, egg, dairy, and an 
optional commentary.

### Instructions
You will need an Integrated Develepor Environment (IDE) such as IntelliJ IDE, or VS Code and a Java Development Kit (JDK) version 8 or higher.
From the command line:
```
git clone git@github.com:Meekb/Java_DiningReviews.git <project name>
cd <project name>
npm install
```
Open project in IDE, run local server to curl endpoints

### Model:
User
  * auto-generated unique id Long
  * username String
  * city String
  * state String
  * zipCode Integer
  * peanutInterest Boolean
  * eggInterest Boolean
  * dairyInterest Boolean

Restaurant
  * auto-generated unique id Long
  * name String
  * peanutRating Integer
  * eggRating Integer
  * dairyRating Integer
  * overallRating Integer

Dining Review
  * auto-generated unique id Long
  * username String
  * restaurant (represented by the restaurant id) Long
  * peanutScore Optional Integer
  * eggScore Optional Integer
  * dairyScore Optional Integer
  * commentary Optional String

### Controller:
DiningReviewController
  * @RequestMapping("/reviews") - returns all Dining Reviews
  * @GetMapping("/{id}") - returns Dining Review by id
  * @GetMapping("/peanut/score_greaterthanequal_{peanutScore}") - returns Dining Reviews with peanut score >= requested
  * @GetMapping("/egg/score_greaterthanequal_{eggScore}") - returns Dining Reviews with egg score >= requested
  * @GetMapping("/dairy/score_greaterthanequal_{dairyScore}") - returns Dining Reviews with dairy score >= requested

RestaurantController
  * @RequestMapping("/restaurants") - returns all Restaurants
  * @GetMapping("/{id}") - return Restaurant by id
  * @GetMapping("/rating/overall_greaterthanequal_{overallRating}") - returns Restaurants with overall rating >= requested
  * @GetMapping("/rating/peanut_greaterthanequal_{peanutRating}") - returns Restaurants with peanut rating >= requested
  * @GetMapping("/rating/egg_greaterthanequal_{eggRating}") - returns Restaurants with egg rating >= requested
  * @GetMapping("/rating/dairy_greaterthanequal_{dairyRating}") - returns Restaurants with dairy rating >= requested



