-- Create Users table
CREATE TABLE Users (
    UserID INT PRIMARY KEY AUTO_INCREMENT,
    Username VARCHAR(255),
    Email VARCHAR(255),
    Password VARCHAR(255),
    Address VARCHAR(255),
    Phone VARCHAR(20),
    City VARCHAR(255),
    State VARCHAR(255),
    ZipCode VARCHAR(10),
    GeoLocation GEOMETRY
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
    State VARCHAR(255),
    ZipCode VARCHAR(10),
    GeoLocation GEOMETRY
);

-- Create Items table
CREATE TABLE Items (
    ItemID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    Description TEXT,
    CategoryID INT,
    Condition VARCHAR(100),
    DonorID INT,
    ReceiverID INT NULL,
    DateListed DATE,
    DateClaimed DATE NULL,
    LocationID INT,
    FOREIGN KEY (CategoryID) REFERENCES Categories(CategoryID),
    FOREIGN KEY (DonorID) REFERENCES Users(UserID),
    FOREIGN KEY (ReceiverID) REFERENCES Users(UserID),
    FOREIGN KEY (LocationID) REFERENCES Locations(LocationID)
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

-- Create States table
CREATE TABLE States (
    StateID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255)
);

-- Create Cities table
CREATE TABLE Cities (
    CityID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(255),
    StateID INT,
    FOREIGN KEY (StateID) REFERENCES States(StateID)
);

