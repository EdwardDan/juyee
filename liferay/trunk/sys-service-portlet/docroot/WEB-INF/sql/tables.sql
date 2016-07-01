create table sys_Dictionary (
	dictionaryId LONG not null primary key,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
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