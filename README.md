# Java_DiningReviews

## Overview
RESTful Dining Review API with data persistence built in Java using Spring and Spring Data JPA with Hibernate.  
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
  * @GetMapping("/rating/peanut_greaterthanequal_{peanutRating}") - returns Restaurants with peanut rating >= requested
  * @GetMapping("/rating/egg_greaterthanequal_{eggRating}") - returns Restaurants with egg rating >= requested
  * @GetMapping("/rating/dairy_greaterthanequal_{dairyRating}") - returns Restaurants with dairy rating >= requested
  * @GetMapping("/rating/overall_greaterthanequal_{overallRating}") - returns Restaurants with overall rating >= requested
  
  **Controller Code examples**
  ```java
   // returns List of restaurants with overall rating greater than or equal to requested
   @GetMapping("/rating/overall_greaterthanequal_{overallRating}")
   public List<Restaurant> getByOverallRatingGreaterThanEqual(@PathVariable("overallRating") Double overallRating) {
       if (overallRating != null) {
           return restaurantRepository.findByOverallRatingGreaterThanEqual(overallRating);
       } else return new ArrayList<>();
     }
    
   // returns review list with requested min dairy score
   @GetMapping("/dairy/score_greaterthanequal_{dairyScore}")
   public List<DiningReview> getReviewsByDairyScoreGreaterThanEqual(@PathVariable("dairyScore") Integer dairyScore) {
       if (dairyScore != null) {
           return diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
       } else return new ArrayList<>();
     }
  ```
  
## Tech Stack
<table>
  <tr>
    <td>Java</td>
    <td>Spring</td>
    <td>Hibernate</td>
    <td>IntelliJ IDE</td>
  </tr>
  <tr>
    <td><img width="55" src="https://raw.githubusercontent.com/gilbarbara/logos/master/logos/java.svg"/></td> 
    <td><img width="55" src="https://raw.githubusercontent.com/gilbarbara/logos/master/logos/spring.svg"/></td>
    <td><img width="55" src="https://raw.githubusercontent.com/gilbarbara/logos/master/logos/hibernate.svg"/></td>  
    <td><img width="55" src="https://raw.githubusercontent.com/gilbarbara/logos/master/logos/intellij-idea.svg"/></td>
  </tr>
</table>

## Contributors

<table>
  <tr>
   <td> Beth Meeker <a href="https://github.com/meekb">GH</td>
  </tr>
  </tr>
    <td><img src="https://avatars.githubusercontent.com/u/76264735?v=4" alt="Beth Meeker avatar"
    width="150" height="auto" /></td>
  </tr>
</table>


