# Payment Service

LAST UPDATED on 20-10-2023 by @Isuru

---

Code for the payment management service for the e-commerce application.

## Flow
```mermaid
graph TD
    A(Customer checkout) -->|places order on| B(Shop)
    B --- note1>store payment info in db]
    B --> |forwards info to| C(Payment gateway) -.-> D(Risk check)
    note2>no need to worry about the following steps] ---E
    C --> E(Acquiring bank a.k.a Merchant's bank)
    E --> F(Card scheme ex. visa, master, etc)
    F --> G(Issuer bank a.ka. Customer's bank)
    G --> if{approved?} --> |yes| H(update ledger & wallet)
    
    if --> |no| I(halt) --> |failure| A
    H --> |success|A
    
```

## Database
```mysql
create database payment;

create table payment_record(
   id INT not null auto_increment,
   user_id INT not null,
   amount DECIMAL not null,
   datetime TIMESTAMP not null,
   status VARCHAR(10) not null,
   primary key(id)
);

```

## Important
>  Sensitive credentials are stored in the .env file. 
> <br>
> In order to run the application, create a .env file at the root folder, sign up for a sandbox paypal account
> and add the CLIENT_ID and CLIENT_SECRET to the .env file.