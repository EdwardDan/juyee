create table sys_Dictionary (
	dictionaryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createTime DATE null,
	modifiedTime DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	isLeaf BOOLEAN,
	sortNo INTEGER,
	desc_ STRING null,
	tag VARCHAR(75) null,
	isValid BOOLEAN,
	treePath VARCHAR(75) null,
	sortPath VARCHAR(75) null,
	customContent STRING null,
	parentId LONG
);

create table sys_SMS (
	smsId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createTime DATE null,
	modifiedTime DATE null,
	content VARCHAR(200) null,
	senderId LONG,
	senderName VARCHAR(75) null,
	receiver STRING null,
	sendTime DATE null
);