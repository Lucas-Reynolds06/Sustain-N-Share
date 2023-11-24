--Create Conditions table
CREATE TABLE Conditions (
    ConditionID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255)
);
-- Create States table
CREATE TABLE States (
    StateID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255)
);

-- Create Avatar table
CREATE TABLE Avatar (
    AvatarID INT PRIMARY KEY AUTO_INCREMENT,
    Location VARCHAR(100)
);

-- Create Users table
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255),
    FirstName VARCHAR(25),
    LastName VARCHAR(50),
    AccountNonExpired BIT,
    AccountNonLocked BIT,
    CredentialsNonExpired BIT,
    Enabled BIT,
    Email VARCHAR(255),
    Password VARCHAR(255),
    Address VARCHAR(255),
    Phone VARCHAR(20),
    City VARCHAR(255),
    StateID INT,
    ZipCode VARCHAR(10),
    GeoLocation GEOMETRY,
    AvatarID INT,
    ScreenName VARCHAR(100),
    FOREIGN KEY (StateID) REFERENCES States(StateID),
    FOREIGN KEY (AvatarID) REFERENCES Avatar(AvatarID)
);

-- Create Categories table
CREATE TABLE Categories (
    CategoryID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255)
);

-- Create Items table
CREATE TABLE Items (
    ItemID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Description TEXT,
    CategoryID INT,
    ConditionID INT,
    DonorID INT,
    ReceiverID INT NULL,
    DateListed DATE,
    DateClaimed DATE NULL,
    GeoLocation GEOMETRY,
    ItemImage VARCHAR(255),
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
    FOREIGN KEY (DonorID) REFERENCES Users(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES Users(UserID),
    FOREIGN Key (ConditionID) REFERENCES Conditions(ConditionID)
);

-- Create Transactions table
CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY AUTO_INCREMENT,
    ItemID INT,
    DonorID INT,
    ReceiverID INT,
    DateInitiated DATE,
    DateCompleted DATE,
    Status VARCHAR(100),
    FOREIGN KEY (ItemID) REFERENCES Items(ItemID),
    FOREIGN KEY (DonorID) REFERENCES Users(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES Users(UserID)
);

-- Create the Blog table
CREATE TABLE BlogPost (
    BlogPostID INT PRIMARY KEY  AUTO_INCREMENT,
    Title VARCHAR(255),
    Abstract VARCHAR(500),
    Content TEXT,
    --PostedOn DATE,
    AuthorID INT,
    Category VARCHAR(100),
    FOREIGN KEY (AuthorID) REFERENCES  Users(UserID)
);

CREATE TABLE Authorities (
    AuthorityID INT PRIMARY KEY AUTO_INCREMENT,
    Authority VARCHAR(20)
);

CREATE TABLE UserAuthorities (
    UserID INT,
    AuthorityID INT,
    PRIMARY KEY (UserID,AuthorityID),
    FOREIGN KEY (UserID) REFERENCES Users(UserID),
    FOREIGN KEY (AuthorityID) REFERENCES Authorities(AuthorityID)
);

CREATE TABLE Contact (
    ContactID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(20),
    LastName VARCHAR(40),
    Email VARCHAR(50),
    StateID INT,
    Subject TEXT
);
