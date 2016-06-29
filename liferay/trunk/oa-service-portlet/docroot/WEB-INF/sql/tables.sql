create table oa_LeaderWork (
	userId LONG not null,
	workDate LONG not null,
	amOrPm LONG not null,
	userName VARCHAR(75) null,
	createTime DATE null,
	modifiedTime DATE null,
	content VARCHAR(75) null,
	primary key (userId, workDate, amOrPm)
);

create table oa_OfficeSupply (
	officeSupplyId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createTime DATE null,
	modifiedTime DATE null,
	name VARCHAR(75) null,
	model VARCHAR(75) null,
	unit VARCHAR(75) null,
	unitPrice DOUBLE,
	quantity INTEGER
);