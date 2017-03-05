DROP KEYSPACE IF EXISTS iotevents_v1;

CREATE KEYSPACE iotevents_v1 WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };

use iotevents_v1;

CREATE TABLE category(
catId UUID,
name text,
description text,
lastModified timestamp,
PRIMARY KEY (catId)
);

CREATE TABLE location(
locId UUID,
name text,
latitude text,
longitude text,
description text,
lastModified timestamp,
status boolean,
PRIMARY KEY (locId)
);

CREATE TABLE organization(
orgId UUID, 
name text,
description text,
lastModified timestamp,
status boolean,
PRIMARY KEY (orgId)
);

CREATE TABLE gateway(
gId UUID,
name text,
macId text,
description text,
lastModified timestamp,
status boolean,
locId UUID,
orgId UUID,
PRIMARY KEY (gId)
);

CREATE TABLE device(
devId UUID,
macId text,
name text,
attributes map<text,text>,
status boolean,
lastModified timestamp,
catId UUID,
gId UUID,
locId UUID,
PRIMARY KEY (devId)
);


CREATE TABLE user(
userId UUID,
userName text,
firstName text,
lastName text,
email text,
mobileNo text,
password text,
status boolean,
lastModified timestamp,
orgId UUID,
device list<UUID>,
gId UUID,
PRIMARY KEY (username)
);


CREATE TABLE device_events(
eventId UUID,
devId text,
loginId text,
type text,
eventTime timestamp,
attributes map<text, text>,
PRIMARY KEY (eventId)
);

//DESCRIBE keyspaces;
//use iotevents_v1
//describe tables; 
