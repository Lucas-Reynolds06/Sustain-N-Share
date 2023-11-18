--Insert states
Insert into States (Name) values ('Alabama')
Insert into States (Name) values ('Alaska')
Insert into States (Name) values ('Arizona')
Insert into States (Name) values ('Arkansas')
Insert into States (Name) values ('California')
Insert into States (Name) values ('Colorado')
Insert into States (Name) values ('Connecticut')
Insert into States (Name) values ('Delaware')
Insert into States (Name) values ('Florida')
Insert into States (Name) values ('Georgia')
Insert into States (Name) values ('Hawaii')
Insert into States (Name) values ('Idaho')
Insert into States (Name) values ('Illinois')
Insert into States (Name) values ('Indiana')
Insert into States (Name) values ('Iowa')
Insert into States (Name) values ('Kansas')
Insert into States (Name) values ('Kentucky')
Insert into States (Name) values ('Louisiana')
Insert into States (Name) values ('Maine')
Insert into States (Name) values ('Maryland')
Insert into States (Name) values ('Massachusetts')
Insert into States (Name) values ('Michigan')
Insert into States (Name) values ('Minnesota')
Insert into States (Name) values ('Mississippi')
Insert into States (Name) values ('Missouri')
Insert into States (Name) values ('Montana')
Insert into States (Name) values ('Nebraska')
 Insert into States (Name) values ('Nevada')
 Insert into States (Name) values ('New Hampshire')
 Insert into States (Name) values ('New Jersey')
 Insert into States (Name) values ('New Mexico')
 Insert into States (Name) values ('New York')
 Insert into States (Name) values ('North Carolina')
 Insert into States (Name) values ('North Dakota')
 Insert into States (Name) values ('Ohio')
 Insert into States (Name) values ('Oklahoma')
 Insert into States (Name) values ('Oregon')
 Insert into States (Name) values ('Pennsylvania')
 Insert into States (Name) values ('Rhode Island')
 Insert into States (Name) values ('South Carolina')
 Insert into States (Name) values ('South Dakota')
 Insert into States (Name) values ('Tennessee')
 Insert into States (Name) values ('Texas')
 Insert into States (Name) values ('Utah')
 Insert into States (Name) values ('Vermont')
 Insert into States (Name) values ('Virginia')
 Insert into States (Name) values ('Washington')
 Insert into States (Name) values ('West Virginia')
 Insert into States (Name) values ('Wisconsin')
 Insert into States (Name) values ('Wyoming')
 --Insert categories
 Insert into Categories (Name) values ('Appliances')
 Insert into Categories (Name) values ('Electronics')
 Insert into Categories (Name) values ('Furniture')
 Insert into Categories (Name) values ('Clothing')
 Insert into Categories (Name) values ('Toys & Games')
 Insert into Categories (Name) values ('Vehicles')
 Insert into Categories (Name) values ('Books')
 Insert into Categories (Name) values ('Sports Equipment')
 Insert into Categories (Name) values ('Gardening Tools')
 Insert into Categories (Name) values ('Kitchenware')
 Insert into Categories (Name) values ('Arts & Crafts Supplies')
 Insert into Categories (Name) values ('Other')
 --Insert conditions
 Insert into Conditions (Name) values ('New')
 Insert into Conditions (Name) values ('Used - Excellent Quality')
 Insert into Conditions (Name) values ('Used - Minimal Wear')
 Insert into Conditions (Name) values ('Used - Normal Wear')
 Insert into Conditions (Name) values ('Used - Significant Wear')
 Insert into Conditions (Name) values ('Used - Damaged')
 Insert into Conditions (Name) values ('Not Applicable')
 --Create default user
 Insert into Users (Username, Email, Password, Address, Phone, City, StateID, ZipCode, Geolocation) values ('Lucas','lucasreynolds@email.com','password1', '123 North Street', '801-555-1234','Salt Lake City', 44, '12345','POINT(40.524 111.8638)')
 --Create default location
 Insert into Locations (Address, City, StateID, ZipCode, Geolocation) values ('123 North Street', 'Salt Lake City', 44, '12345', 'POINT(40.524 111.8638)')
--Create default item
 Insert into Items (Name, Description, CategoryID, ConditionID, DonorID, DateListed, LocationID) values ('Nintendo Switch','Comes with some games such as Mario Cart 8 Deluxe', 2, 2, 1,'2023-11-16',1)

