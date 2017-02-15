DROP KEYSPACE IF EXISTS iotevents_v1;

CREATE KEYSPACE iotevents_v1 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

use iotevents_v1;

CREATE TABLE organization(
orgid int, 
orgname text,
description text,
updated_time timestamp,
PRIMARY KEY (orgname)
);

CREATE TABLE device(
devid text,
dev_macid text,
devname text,
attributes map<text,text>,
updated_time timestamp,
PRIMARY KEY (devid)
);


CREATE TABLE user(
userid int,
username text,
first_name text,
last_name text,
email text,
mobileno text,
password text,
updated_time timestamp,
orgid int,
device map<text, text>,
PRIMARY KEY (username)
);


CREATE TABLE iot_events(
devid text,
devloginid text,
devtype text,
event_time timestamp,
attributes map<text, text>,
PRIMARY KEY (event_time)
);

//DESCRIBE keyspaces;
//use iotevents_v1
//describe tables; 
//describe columnfamily
//insert into iot_events JSON '{"devid": "1234","devloginid": "8766","devtype": "sensor","event_time": "2017-02-14 15:04:30","attributes": {"temp": "23", "humi": "12","x-axis": "12", "y-axis": "321","z-axis": "98"}}';

