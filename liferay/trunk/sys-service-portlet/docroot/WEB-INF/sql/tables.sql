create table sys_Dictionary (
	dictionaryId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	code_ VARCHAR(75) null,
	name VARCHAR(75) null,
	isLeaf BOOLEAN,
	sortNo VARCHAR(75) null,
	desc_ VARCHAR(75) null,
	tag INTEGER,
	isValid BOOLEAN,
	parentId LONG
);