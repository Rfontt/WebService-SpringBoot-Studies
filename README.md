# Studies about spring boot webservice - JAVA

### RestController

@RestController is an annotation which is responsible for declaring that api is a REST API.
So, spring boot understands that the api returns a JSON or XML data.

```java
@RestController
public class Example {}
```

### RequestMapping

@RequestMapping is an annotation which is responsible for representing the URI of this route.

```java
@RestController
@RequestMapping("/example")
public class Example {}
```

### Bean

Class Bean => It's a class which contains only attributes, gets and setters.