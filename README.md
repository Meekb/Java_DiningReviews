# Dining Reviews in Java  
An allergy-specific restaurant review API

## Overview
RESTful Dining Review API with data persistence built in Java using Spring and Spring Data JPA with Hibernate.  
This sample Dining Review API is designed for folks with allergies. Users indicate interest in any or all of three categories - peanut, egg, dairy.
Restaurants are rated in each category and have an overall rating which is the average of all review scores. Reviews contain username and optional scores for peanut, egg, dairy, as well as an optional commentary.

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
The Model consists of three classes - User, Restaurant, and DiningReview. 
Each class has an id which is an auto-generated Long data type

**User**
  * username String
  * city String
  * state String
  * zipCode Integer
  * peanutInterest Boolean
  * eggInterest Boolean
  * dairyInterest Boolean

**Restaurant**
  * name String
  * peanutRating Integer
  * eggRating Integer
  * dairyRating Integer
  * overallRating Integer

**Dining Review**
  * username String
  * restaurant (represented by the restaurant id) Long
  * peanutScore Optional Integer
  * eggScore Optional Integer
  * dairyScore Optional Integer
  * commentary Optional String

### Controller:

  **Code examples**
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
   
   // creates & saves a new user
    @PostMapping("/addNew")
    public User createUser(@RequestBody User user) {
        User newUser = this.userRepository.save(user);
        return newUser;
    }
   
   // returns users with peanut allergy interest
    @GetMapping("/peanut_interest")
    public Iterable <User> findByPeanutInterestTrue() {
        return this.userRepository.getByPeanutInterestTrue();
    }
  ```

DiningReviewController
  * @RequestMapping("/reviews") - returns all Dining Reviews
  * @GetMapping("/{id}") - returns Dining Review by id
  * @GetMapping("/peanut/score_greaterthanequal_{peanutScore}") - returns Dining Reviews with peanut score >= requested
  * @GetMapping("/egg/score_greaterthanequal_{eggScore}") - returns Dining Reviews with egg score >= requested
  * @GetMapping("/dairy/score_greaterthanequal_{dairyScore}") - returns Dining Reviews with dairy score >= requested

RestaurantController
  * @RequestMapping("/restaurants") - returns all Restaurants
  * @GetMapping("/{id}") - returns Restaurant by id
  * @GetMapping("/rating/peanut_greaterthanequal_{peanutRating}") - returns Restaurants with peanut rating >= requested
  * @GetMapping("/rating/egg_greaterthanequal_{eggRating}") - returns Restaurants with egg rating >= requested
  * @GetMapping("/rating/dairy_greaterthanequal_{dairyRating}") - returns Restaurants with dairy rating >= requested
  * @GetMapping("/rating/overall_greaterthanequal_{overallRating}") - returns Restaurants with overall rating >= requested
 
UserController
  * @GetMapping("/users") - returns all Users
  * @PostMapping("/users/addNew") - creates and saves new user to the userRepository, returns the new user
  * @GetMapping("/{id}") - returns user by id
  * @GetMapping("/username_{username}") - returns user my username
  * @GetMapping("/peanut_allery", "/egg_allergy", "/dairy_allergy") - returns list of users who flagged interest in specified allergy
  
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


