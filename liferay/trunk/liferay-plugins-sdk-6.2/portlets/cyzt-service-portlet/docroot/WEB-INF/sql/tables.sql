create table cyzt_LEOCertificate (
	certificateId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	xm VARCHAR(75) null,
	zjbh VARCHAR(75) null,
	zylx VARCHAR(75) null,
	yxq DATE null,
	fzrq DATE null
);

create table cyzt_LEOTraining (
	trainingId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	certificateId LONG,
	pxsj DATE null,
	xcjysj DATE null,
	pxnr VARCHAR(75) null
);