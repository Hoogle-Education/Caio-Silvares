# Design de Soluções

## Motivação

Modela um streaming de músicas.
Toda mídia em todo lugar ao mesmo tempo.

Suponha que já exista a classe `UserData`.

## Pilares

- **Single Resposabilty Principle:** Só devemos ter um único motivo para mudar uma classe.

## Herança (_é_)

```java
public abstract class Media {

  private String name;
  private String coverUrl;
  private double duration;

}
```

```java
public class Movie extends Media {

  private String description;
  private double rottenTomatoesScore;
  private double metaCriticScore;

}
```

```java
public class Music extends Movie {

}
```

## Composição (_tem_)

- **um**: objeto

### um pra um

```java
public class User {

  private String name;
  private String username;

}

public class Listener extends User {

  // um pra um
  private PaymentMethod paymentMethod;

}

public class Artist extends User {

  // um pra um
  private RecordStudio recordStudio;

}
```

### um pra vários

```java
public class Listener {

  // um pra vários
  private List<Plalist> playlists;

}

public class Playlist {

  // vários pra um
  private Listener listener;

  // vários pra vários (...)
  private List<Music> musics;
}
```

### vários pra vários

```java
public class Playlist {

  // vários pra um
  private Listener listener;

  // vários pra vários (...)
  private List<Music> musics;
}

public class Music {

  private List<Playlist> playlists;

}
```

## Forçou composição acima de herança

```java
public class Listener {

  private UserData userData;

}
```

## Melhorando modelagens

```java
enum Currency {
  DLR,
  BLR,
  EUR
}

public class Money {
  "$ 12.23"

  private Currency currency;
  private BigDecimal value;

}

enum UnitMeasure {
  KELVIN,
  CELSIUS,
  FARENHEIT
}

public class Temperature {

  private UnitMeasure unitMeasure;
  private double value;

}
```
