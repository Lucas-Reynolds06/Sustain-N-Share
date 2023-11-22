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

-- Create Locations table
CREATE TABLE Locations (
    LocationID INT PRIMARY KEY AUTO_INCREMENT,
    Address VARCHAR(255),
    City VARCHAR(255),
    StateID INT,
    ZipCode VARCHAR(10),
    GeoLocation GEOMETRY,
    FOREIGN KEY (StateID) REFERENCES States(StateID)

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
    LocationID INT,
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
    FOREIGN KEY (DonorID) REFERENCES Users(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES Users(UserID),
    FOREIGN KEY (LocationID) REFERENCES Locations(LocationID),
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

