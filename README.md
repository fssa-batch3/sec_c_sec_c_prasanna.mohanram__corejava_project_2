# sec_c_sec_c_prasanna.mohanram__corejava_project_2

# MILESTONE 1
## ** BIKE MODULE**

BIKE Model

BIKE Validator

BIKE Dao

BIKE ServiceLayer

BIKE Test cases

# ** BIKE MODULE FEATURES**
-Add bike -Read all bike -Find bikes by brand -Update bike -Delete bike

### Bike Table

This table stores information about bikes, including their brand, model, pricing, ownership status, location, and manufacture date.

#### Table Schema

| Field         | Data Type    | Constraints           | Description                     |
| ------------- | ------------ | ----------------------| --------------------------------|
| id            | INT          | NOT NULL, AUTO_INCREMENT, PRIMARY KEY | Unique identifier for each bike |
| brand         | VARCHAR(100) | NOT NULL              | Brand of the bike               |
| model         | VARCHAR(100) | NOT NULL, UNIQUE      | Model of the bike               |
| price         | DOUBLE       | NOT NULL              | Price of the bike               |
| ownership     | VARCHAR(100) | NOT NULL              | Ownership status of the bike    |
| location      | VARCHAR(100) |                      | Location of the bike            |
| manufactureDate | DATE      | NOT NULL              | Manufacture date of the bike    |
