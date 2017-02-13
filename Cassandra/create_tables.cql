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
devid test,
dev_macid text,
devname text,
map<attname,state>,
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
map<devid, dev_macid>,
PRIMARY KEY (username)
);

CREATE TABLE device_events(
eventid int,
devid text,
userid int,
event_time timestamp,
payload text,	
PRIMARY KEY(eventid)
);


//if devise send message, userid is null
//INSERT INTO device_events(devid,userid,event_time,payload) VALUES ('ABC011022017',null'13-02-2017 08:01:00','<payload>');

//if user send message to device,userid is login userid
//INSERT INTO device_events(devid,userid,event_time,payload) VALUES ('ABC011022017',1'13-02-2017 08:11:00','<payload>');

//need to think on device and device user mapping