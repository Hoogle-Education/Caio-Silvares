# Interfaces and Annotations

## Functional interfaces

é basicamente uma variável carregando uma função

1. **`Predicate<T>`**

A predicate é invocada através de um método chamado `test()`, no qual ele recebe um parametro do tipo T e sempre retorna `boolean`.

```java
Predicate<Integer> isPositive = (n) -> (n > 0);
isPositive.test(5); // true
isPositive.test(-1); // false
list.stream().filter(isPositive).toList();
```

equivalente

```java
public class Something {
  public static boolean isPositive(int number) {
    return number > 0;
  }
}
```

2. **Consumer<T>**

A consumer é invocada através de um método chamado `accept()`, no qual ele recebe um parametro do tipo T e sempre retorna `void`.

```java
  Consumer<String> show = (text) -> System.out.println("Content: " + text);
  show.accept("my text 1"); // Content: my text 1
  lista.forEach(show);
```

3. **Function<T, R>**

A consumer é invocada através de um método chamado `apply()`, no qual ele recebe um parametro do tipo T e sempre retorna algo do tipo R.

```java
 Function<String, Integer> charCounter = (text) -> (text.size());
 Function<Product, String> productToName = (product) -> (product.getName());

 var product = new Product("Bread", 2.99);
 var name = productToName.apply(product);

 var text = "Guardians of Galaxy";
 var numberOfCharsInText = charCounter.apply(text); // 19
```

## DTO (Data Transfer Objects)

user {
id,
email,
phoneNumber,
username,
password,
profilePhoto,
about {
bio,
link
},
followers,
following,
posts,
}

loginDto {
email / username, (string)
password (string)
}

profileDto {
username,
profilePhoto,
posts,
followers,
following,
}

```java
  Function<LoginForm, User> login = ...;
  Function<User, Profile> showProfile = ...;
  Function<User, ShortProfile> showShortProfile = ...;
```

4. **`BiFunction<T1, T2, R>`**

```java
  BiFunction<Integer, Integer, Integer> sum = (a , b) -> a + b;
  BinaryOperator<Integer> multiply = (a , b) -> a * b;
```

```java
@FunctionalInterface
public interface BiFunction<T> {
  default T apply(T a, T b) {
    Function<T, T, T> function = ...;
  }
}
```

```java
@Persistent(name = "users")
public class User {

  @Id
  @AutoIncrement
  private long id;

  @Unique
  private String username;

  @Password
  private String password;

  @ToStringIgnore
  public void follow(User user) {
  }
}
```
