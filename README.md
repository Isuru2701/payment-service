# Payment Service

LAST UPDATED on 17-10-2023 by @Isuru

---

Code for the payment management service for the e-commerce application.

## Flow
```mermaid
graph TD
    A(Customer checkout) -->|places order on| B(Shop)
    note1>store payment info in db] --- B
    B --> |forwards info to| C(Payment gateway) -.-> D(Risk check)
    note2>no need to worry about the following steps] --- E
    C --> E(Acquiring bank a.k.a Merchant's bank)
    E --> F(Card scheme ex. visa, master, etc)
    F --> G(Issuer bank a.ka. Customer's bank)
    G -.-> |response| A
    
```

## Database
```mysql
create database payment;

create table payment_record(
id int not null auto_increment,
user_id int not null,
amount int not null,
primary key(id)
);
```