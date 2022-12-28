# Repetição

```
  1. inicialização
  2. verificação
  3. atualização
```

```java
int i = 0;

while( i < 10 ) {
  int x = 10;
  // faça algo
  i++;
}
```

```java
for(/*inicialização*/;/*verificação*/; /*atualização*/){
  
}
```

```java
for(int i = 1; i <= 10; i++){
  
}
```

```java
boolean continue = false;

do {
  // faça algo
} while(continue);
```

# Recursão

## bottom up

De baixo pra cima, também chamada de solução iterativa.

complexidade: `n`

```java
int soma = 0;

for(int i = 0; i <= 100; i++) {
  soma += i; // soma = soma + i
}
```

## top down

De cima pra baixo, também chamada de solução recursiva.

complexidade: `n`

```java
public static int somaRecursiva(int n) {

  // base case == verificação
  if ( n == 0 ) 
    return 0;

  // recursive case
  return n + somaRecursiva(n-1);
}
```
