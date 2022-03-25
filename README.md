# Java_DiningReviews

## Overview
RESTful Dining Review API with data persistence built in Java using Spring and Spring Data JPA.  
Dining Review API designed for folks with allergies. Users indicated interest in any or all of three categories - peanut, egg, dairy.  
Restaurants are rated in each category, and have an overall rating. 
Reviews contain username and optional scores for peanut, egg, dairy, and an optional commentary.


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
UserController

RestaurantController

DiningReviewController



