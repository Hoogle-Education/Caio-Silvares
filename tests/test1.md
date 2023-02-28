# Quick Test 1

## question 1

`and` (`&&`): precisa que as duas condições sejam verdade para dar `true`.

`or` (`||`): precisa que pelo menos uma seja `true`.

(true && false) = false

```java
x = (true && ( true || false )) // true
!x // false
```

## question 2

```java

if (b2 || b1) {

  if(b3 == false) {

  }
} else {

}
```

## question 3

```java
  switch (idade) {
    case 10:
      System.out.println("a");
    case 14:
      System.out.println("b");
  }

```

```java
  switch (character) {
    case "a":
    case "e":
    case "i":
    case "o":
    case "u":
      return true;
    default:
      return false;
  }
```

## question 4

```java

do {
  System.out.println("run");
}while(false);
```

x = 4
result =3\*3 = 9

result = 9 \* 4= 36
x= 5

## question 5

```java
double[] array = new double[10];
int x = 5;

for(var y : array) {
  y = x + 1;
  x++; //
}
```

## question 6

```java
  // static value == shared value
  Storage a = new Storage(); // this.number = 0 || value = 1
  a.setNumber(20); // this.number = 20 || value = 1
  a = new Storage(); // this.number = 0 || value = 2
  a.setNumber(30); // this.number = 30 || value = 2
  // No.: 230
```

## question 7

```java
Robot r1 = new Robot(); // r1: (50, 50)
r1.xPos = 30; // r1: (30, 50)
Robot.startPositionY = 20;
Robot r2 = new Robot(); // r2: (50, 20)
r1.xPos = r1.xPos + 10; // r1: (40, 50)
r2.xPos = r1.xPos; // r2: (40, 20)
```

## question 8

```java
Counter c1 = new Counter(); // this.counter = 4; nextNumber = 4;
Counter c2 = new Counter(); // this.counter = 3; nextNumber = 3;
Counter.nextNumber = 10; // nextNumber = 10
c1 = new Counter(); // this.counter = 9; nextNumber = 9;
// c1.counter + c2.counter = 12
```
