# Hands on 4: Difference between JPA, Hibernate and Spring Data JPA

## Java Persistence API (JPA)
- JSR 338 Specification for persisting, reading and managing data from Java objects
- Does NOT contain concrete implementation
- Hibernate is one implementation of JPA
- Just an interface/contract - no actual code

## Hibernate
- ORM Tool that implements JPA
- Converts Java objects to database tables automatically
- Handles SQL generation internally
- Requires manual session and transaction management

## Spring Data JPA
- Does NOT have JPA implementation
- Another level of abstraction OVER JPA providers like Hibernate
- Reduces boilerplate code significantly
- Manages transactions automatically
- Just extend JpaRepository - no SQL needed!

## Comparison
| Feature              | Hibernate          | Spring Data JPA     |
|----------------------|--------------------|---------------------|
| Code needed          | More boilerplate   | Minimal             |
| Transaction handling | Manual             | Automatic           |
| Session management   | Manual             | Automatic           |
| Query methods        | HQL/Criteria API   | Method name queries |
| Learning curve       | Steeper            | Easier              |
