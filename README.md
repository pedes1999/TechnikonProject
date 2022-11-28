# TechnikonProject
This is an application of a Renovation Contractor Agency, Technico.
It will enable the employees - managers of its platform to have access to information concerning customers and repairs. 
It will also enable its customers to oversee repair/renovation work progress on their property.
The different user types will be able to perform some services. (There will be proper validation for our new data).
The OWNER USERS will be able to :
	Add a property that he owns and read property data based on his vatNumber
and on propertyId and submit a repair on a property.
	Read property repairs based on the date of repair by giving a date or a range of dates. 
	Read property repairs based on vatNumber.
	Update his personal information (Address, Email, Password).
	Update property information concerning the property's Address, property's Construction Year, and property's Type.
        Update Repair's basic information.

The ADMINs will be able to :
	He has the functionality of a regular User-Owner plus the following:
	Add Owners in the system, search them by their VAT number and Email and delete them too.
	Add a Property and a Property repair and get all the Property Repairs that are submitted.
	Update Property Repair's start and end date, the actual dates, and the proposed cost, and also update and delete a Repair.

It is worth noticing tha the validation in the main java class,where:
        Owner can CRUD only his properties and repairs.
        Owner does not have the ability to CRUD another Owner's data,properties and repairs.
        Admin can manipulate evrything.

Every method run in the main is executed multiple times with different parameters in order to showcase the validations and the Exceptions thrown.

How to use it
A. Select one of the following options:
1.	Clone it
2.  Change the persistence file from validate to Create
3.  Uncomment the first 3 lines to import the data to db directly from the Csv files.
4.  Change back the persistence file to validate
5.  Uncomment everything you need to check and run!

Technologies
•	Java 17
•	JPA – Hibernate
•	MySQL

