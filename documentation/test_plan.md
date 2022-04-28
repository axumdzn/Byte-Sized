# Test Plan
## Technologies Used
 - Languages: PostgresSQL, Java, HTML, CSS, JS
 - IDE/Other: IntelliJ, DBeaver, Postman, GitHub, AWS Database, EC2 system, VSCode
 - Packages: Cucumber slf4j, testNG, mockito, javalin, gson, cucumber, selenium, junit
https://docs.google.com/spreadsheets/d/1981rtniR6Yi3MMdKTKwHFtxuJ4jrTVfFsKAVwMC9vZk/edit?usp=sharing
## Deadlines
### Timeline: 3 Weeks
    [1-3] Writing the documentation for the project
    [4-8] Each person is responsible for their part on the from dal to api so these 4-5 days will be for making the parts they are responsible to work
    [9-10]  Implementing the front end html, css and javascript
    [10-13] This will be the finishing of the javascript and writing/implementing the e2e testing. During this time is also crucial to make sure everything works together
    [14] Making all of the last minute finishes to the project and practicing the presentation to make it correct
    [15] Present
    Due Date: April 29, 2022



## Entities
    Create table Users(
    userId serial primary key,
    username varchar(20),
    password varchar(20),
    isBuyer boolean,
    isSeller boolean
    );

    Create Table products(
    ProductId serial primary key,
    Title varchar(150),
    Description varchar(500),
    Price dec(5,2),
    inventory int,
    SellerId int
    )


    Create table ratings(
    RatingId serial primary key,
    Rate int,
    Comment varchar(100),
    BuyerId,
    SellerId int
    )

    Create table transactions(
    TransactionId serial primary key,
    Amount int,
    Size varchar(20),
    Status varchar(20),
    ProductId int,
    BuyerId int,
    )

    Create table messages(
    messageId: serial primary key,
    message varchar(250),
    dateCreated date,
    buyerId int,
    sellerId int,
    senderId int
    
    );

## User Stories
 - AS a buyer, I should be able to buy an item so that I can get items I need or want(createTransaction)
 - As a buyer, I should be able to leave a review so that the next potential buyer knows how good they are(createRating)
 - As a buyer, I should be able to see the progress of my item so that I know the current status(getTransactionInfo)


## Business Rules:
- rating between 0-5 increments of 1
- sellers has a 10 item limit at a time
- limit price of each item 100,000
- Limit title for each item 150
- character limit to messages 250
