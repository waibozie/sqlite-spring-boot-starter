# sqlite-spring-boot-start

Integrate SQLite into Spring Boot by a starter way, which is auto-configured. You can use SQLite out of box through JPA
like other data source.

## Usage

1. Declare dependency on `sqlite-spring-boot-start` in your build tool metadata file. For example, Maven is shown below:

```xml

<dependency>
    <groupId>com.github.waibozie</groupId>
    <artifactId>sqlite-spring-boot-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

2. Change some configuration to satisfy you scene

```properties
sqlite.user=<todo: specify yours>
sqlite.password=<todo: specify yours>
sqlite.file=<todo: specify yours>
```

3. No further code configuration required, just enjoy it !

## Configuration

`sqlite-spring-boot-start` supported configurations list below:

- sqlite.user  
  User for sqlite, if be not configured explicitly, use "_**sqliteAnonymousUser**_" as default

- sqlite.password  
  Password for sqlite, if be not configured explicitly, use "_**sqliteAnonymousUserPasswd**_" as default

- sqlite.file  
  Location of sqlite file, if `sqlite.url` and `sqlite.file` are not configured explicitly, use "_**sqlite_default.db**_" as default filename which in program work directory.

- sqlite.url  
  Optional and advanced configuration, by which you can adjust some features as you want. If `sqlite.url` explicitly, `sqlite.file`
  will be ignored