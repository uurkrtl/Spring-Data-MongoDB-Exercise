
# Creating a project with Spring-Data and MongoDB

## 1. Add dependencies
- [ ] Lombok
- [ ] Spring Web
- [ ] Spring Data MongoDB

## 2. Edit application.properties file
- [ ]  spring.data.mongodb.uri=${MONGODB_URI}
- [ ] spring.data.mongodb.database=shop

## 3. Set the Environment Variable
- [ ] Click on the Run button and then on `Edit Configurations…`
- [ ] Go to `Modify Options` and select `Environment Variables`
- [ ] Set the environment variable:
    - [ ] Name: MONGODB_URI
    - [ ] Value: [Connection String]

## 4. Create a record
```java 
public record Customer (String id, String firstName, String lastName){ }
```

## 5. Create interface and extend MongoRepository
```java 
public interface CustomerRepository extends MongoRepository<Customer, String> { }
```

## 6. Create CustomerController
```java 
@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerRepository customerRepository;
}
```

- [ ] Define CRUD operations
```java 
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public Iterable<Customer> getCustomers() {
  return this.customerRepository.findAll();
  }

  @PostMapping("/add")
  @ResponseStatus(HttpStatus.CREATED)
  public Customer createCustomer(@RequestBody Customer customer) {
  return this.customerRepository.save(customer);
  }

  @PutMapping("/update")
  @ResponseStatus(HttpStatus.OK)
  public Customer updateCustomer(@RequestBody Customer customer) {
  return this.customerRepository.save(customer);
  }

  @DeleteMapping("/delete/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void  deleteCustomer(@PathVariable String id) {
  this.customerRepository.deleteById(id);
  }
```