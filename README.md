# Dining Reviews in Java  
An allergy-specific restaurant review API built to solidfy the fundamentals of Java and Spring

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
The Model consists of four classes - User, Restaurant, DiningReview, and AdminReviewStatus. 
 - User, Restaurant, and DingingReview classes have an auto-generated id, date type Long

##### **Code samples from DiningReview and AdminReviewStatus Classes**
  ```java
  @Entity
  @Table(name = "REVIEWS")
  public @Data
  @NoArgsConstructor
  class DiningReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "RESTAURANT")
    private Long restaurant; // represented by the restaurant id
    @Column(name = "PEANUTSCORE")
    private Integer peanutScore;
    @Column(name = "EGGSCORE")
    private Integer eggScore;
    @Column(name = "DAIRYSCORE")
    private Integer dairyScore;
    @Column(name = "COMMENTARY")
    private String commentary;
    @Column(name = "REVIEW_STATUS")
    @Enumerated(EnumType.STRING)
    private AdminReviewStatus adminReviewStatus;
  }
  ```

**AdminReviewStatus**
  ```java
  public enum AdminReviewStatus {
      PENDING,
      APPROVED,
      REJECTED,
  }
  ```

------------

### Controller:
Three controllers - UserController, RestaurantController, DiningReviewController

   ##### **Code samples from UserController**
   ```java
   // creates & saves a new user
    @PostMapping("/addNew")
    public User createUser(@RequestBody User user) {
        if (userRepository.getByUsername(user.getUsername()) != null || userRepository.findById(user.getId()).isPresent()) {
            System.out.print("Id or username already exists");
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or Id already exists");
        } else return userRepository.save(user);
    }

   // returns users with peanut allergy interest
    @GetMapping("/peanut_allergy")
    public Iterable <User> findByPeanutInterestTrue() {
        return this.userRepository.getByPeanutInterestTrue();
    }
  ```

   ##### **Code samples from RestaurantController**
   ```java
   // returns restaurant Optional or ResponseStatusException
    @GetMapping("/name_{name}")
     public Optional<Restaurant> getRestaurantByName(@PathVariable("name") String name) {
         Optional<Restaurant> restaurantOptional = this.restaurantRepository.findByNameContaining(name);
         if (restaurantOptional.isEmpty()) {
             System.out.print("No Restaurants found by that name.");
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No Restaurants found with that name.");
         } else return restaurantOptional;
     }

    // creates and saves a new restaurant
    @PostMapping("/addNew")
     public Restaurant createNewRestaurant(@RequestBody Restaurant restaurant) {
         if (restaurantRepository.findByNameContaining(restaurant.getName()).isEmpty()) {
             Restaurant newRestaurant = restaurantRepository.save(restaurant);
             System.out.print("\nNew restaurant created! id: " +  newRestaurant.getId() + ", name: " + newRestaurant.getName());
             return newRestaurant;
         } else throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Restaurant may already exist...");
     }

    // returns List of restaurants with overall rating greater than or equal to requested
    @GetMapping("/overallRating_{overallRating}")
    public List<Restaurant> getByOverallGreaterThanEqual(@PathVariable("overallRating") Double overallRating) {
        List<Restaurant> restaurantsToReturn = this.restaurantRepository.findByOverallRatingGreaterThanEqual(overallRating);
        if (restaurantsToReturn.isEmpty()) {
            System.out.print("\nSorry, no restaurants found with that overall rating.");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sorry, no restaurants found with that overall rating.");
        } else return restaurantsToReturn;
    }
   ```
   
   ##### **Code samples from DiningReviewController**  
   ```java 
   // returns review list with requested min dairy score
    @GetMapping("/dairyScore_{dairyScore}")
    public Iterable<DiningReview> getReviewsByDairyScoreGreaterThanEqual(@PathVariable("dairyScore") Integer dairyScore) {
        Iterable<DiningReview> resultList = diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
        if (resultList != null) {
            return diningReviewRepository.findByDairyScoreGreaterThanEqual(dairyScore);
        } else return new ArrayList<>();
    }
     
   // returns all reviews in order of id
    @GetMapping()
    public Iterable<DiningReview> getAllDiningReviews() {
        return diningReviewRepository.findAll();
    }
    
    // returns all reviews sorted by username
    @GetMapping("/sorted_username")
    public Iterable<DiningReview> getAllDiningReviewsSorted() {
        return diningReviewRepository.findAll(Sort.by("username"));
    }  
     
   // The following three endpoints return an Iterable of reviews by AdminReviewStatus Pending, Approved, Rejected
    @GetMapping("/pending")
    public Iterable<DiningReview> getPendingReviews() {
        return this.diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.PENDING);
    }
    @GetMapping("/approved")
    public Iterable<DiningReview> getApprovedReviews() {
        return this.diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.APPROVED);
    }
    @GetMapping("/rejected")
    public Iterable<DiningReview> getRejectedReviews() {
        return this.diningReviewRepository.findByAdminReviewStatus(AdminReviewStatus.REJECTED);
    }
   ```
   
_____________  
   
### Repositories:
Repositories for User, Restaurant, DiningReview

##### **Code sample from DiningReview Repository**
  ```java
  public interface DiningReviewRepository extends CrudRepository<DiningReview, Long> {
    Iterable<DiningReview> findByAdminReviewStatus(AdminReviewStatus adminReviewStatus);
    Iterable<DiningReview> findByPeanutScoreGreaterThanEqual(Integer peanutScore);
    Iterable<DiningReview> findByEggScoreGreaterThanEqual(Integer eggScore);
    Iterable<DiningReview> findByDairyScoreGreaterThanEqual(Integer dairyScore);
  }
  ```
##### **Code sample from Restaurant Repository**
  ```java
  public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    List<Restaurant> findAll(Sort name);
    List<Restaurant> findByNameContaining(String name);
    List<Restaurant> findByOverallRatingGreaterThanEqual(Double overallRating);
    List<Restaurant> findByPeanutRatingGreaterThanEqual(Integer peanutRating);
    List<Restaurant> findByEggRatingGreaterThanEqual(Integer eggRating);
    List<Restaurant> findByDairyRatingGreaterThanEqual(Integer dairyRating);
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


