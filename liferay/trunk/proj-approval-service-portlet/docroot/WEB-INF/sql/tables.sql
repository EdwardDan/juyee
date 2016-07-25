create table projApproval_ConstructionParticipantUnits (
	constructionParticipantUnitsId LONG not null primary key,
	sortNo INTEGER,
	contractInfoSubmitNum VARCHAR(75) null,
	unitType LONG,
	unitName VARCHAR(200) null,
	projectLeader VARCHAR(75) null,
	telephoneNum VARCHAR(75) null,
	constructionPermitId LONG
);

create table projApproval_ConstructionPermit (
	constructionPermitId LONG not null primary key,
	userId LONG,
	userName VARCHAR(75) null,
	createTime DATE null,
	modifiedTime DATE null,
	projType LONG,
	projProperty LONG,
	county LONG,
	constructionCode VARCHAR(75) null,
	bidingCode VARCHAR(75) null,
	businessCode VARCHAR(75) null,
	projName VARCHAR(200) null,
	company VARCHAR(200) null,
	companyProperty VARCHAR(200) null,
	companyAddress VARCHAR(200) null,
	legalPerson VARCHAR(75) null,
	companyTel VARCHAR(75) null,
	companyContacts VARCHAR(75) null,
	companyContactPhone VARCHAR(75) null,
	companySite VARCHAR(200) null,
	companySiteCounty VARCHAR(75) null,
	engineerCategory VARCHAR(75) null,
	engineerAttribute LONG,
	engineerScale VARCHAR(200) null,
	nationalFundsProportion VARCHAR(75) null,
	contractPrice DOUBLE,
	contractSchedule DOUBLE,
	bidPrice DOUBLE,
	investBudget DOUBLE,
	planStartDate DATE null,
	planEndDate DATE null,
	workSituation VARCHAR(200) null,
	otherInfo STRING null,
	applyMaterial STRING null,
	receiptNum VARCHAR(75) null,
	certificationDate DATE null,
	constructionPermitCode VARCHAR(75) null
);

create table projApproval_ConstructionUnitProject (
	constructionUnitProjectId LONG not null primary key,
	sortNo INTEGER,
	unitProjectNum VARCHAR(75) null,
	unitProjectName VARCHAR(200) null,
	constructionContent VARCHAR(1000) null,
	constructionPermitId LONG
);