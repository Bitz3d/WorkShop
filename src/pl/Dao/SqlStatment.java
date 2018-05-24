package pl.Dao;

class SqlStatment {
	
 private static final String CUSTOMER_TABLE="Create table Customer \n" + 
 		" 		(\n" + 
 		" 		customer_id int auto_increment,\n" + 
 		" 		user_name varchar(255) not null,\n" + 
 		" 		user_lastName varchar(255) not null, \n" + 
 		" 		dateOfBirth date not null, \n" + 
 		" 		primary key(customer_id) \n" + 
 		"        )";
	

 private static final String EMPLOYEE_TABLE="Create table Employee \n" + 
 		"(\n" + 
 		"employee_id int auto_increment,\n" + 
 		"employee_name varchar(255) NOT NULL,\n" + 
 		"employee_lastName varchar(255) NOT NULL,\n" + 
 		"employee_adress varchar(255),\n" + 
 		"employee_phoneNumber int unique,\n" + 
 		"note text COLLATE utf8_polish_ci,\n" + 
 		"price_per_hour decimal NOT NULL,\n" + 
 		"\n" + 
 		"primary key(employee_id)\n" + 
 		"\n" + 
 		")";
 
 private static final String VEHICLE_TABLE="Create table Vehicles(\n" + 
 		"\n" + 
 		"vehicle_id int auto_increment,\n" + 
 		"model varchar(255) NOT NULL,\n" + 
 		"trademark varchar(255) NOT NULL,\n" + 
 		"productionYear int not null,\n" + 
 		"registration_number varchar(255) not null unique,\n" + 
 		"technical_reviw date not null,\n" + 
 		"customer_id int not null,\n" + 
 		"\n" + 
 		"primary key(vehicle_id),\n" + 
 		"foreign key(customer_id) references Customer(customer_id)\n" + 
 		"\n" + 
 		")";
 
 
 private static final String STATUS_TABLE ="CREATE table Status \n" + 
 		"(\n" + 
 		"status_id int auto_increment,\n" + 
 		"status_text varchar(20),\n" + 
 		"\n" + 
 		"primary key(status_id)\n" + 
 		"\n" + 
 		"\n" + 
 		")";
 
 
 private static final String ORDER_TABLE="create table Orders ( \n" + 
 		" 		order_id int auto_increment,\n" + 
 		"        order_date Date not null ,\n" + 
 		" 		plannig_working_date Date, \n" + 
 		" 		start_of_work Date,\n" + 
 		" 		who_will_fix int not null,\n" + 
 		" 		problem_description text not null, \n" + 
 		" 		after_fix_description text,\n" + 
 		" 		order_status varchar(250) not null,\n" + 
 		" 		vehicle_to_fix int not null,\n" + 
 		" 		total_cost decimal(10,2),\n" + 
 		" 		parts_cost decimal(10,2), \n" + 
 		" 		\n" + 
 		" 		primary key(order_id), \n" + 
 		" 		foreign key(who_will_fix) references Employee(employee_id), \n" + 
 		" 		foreign key(vehicle_to_fix) references Vehicles(vehicle_id)\n" + 
 		" 		)";
 
 
}
