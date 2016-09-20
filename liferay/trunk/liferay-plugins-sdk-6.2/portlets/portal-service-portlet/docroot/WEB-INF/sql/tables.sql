create table portal_Feedback (
	feedbackId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	zt VARCHAR(30) null,
	lxId LONG,
	fkrId LONG,
	fkrq DATE null,
	fknr VARCHAR(2000) null,
	hfrId LONG,
	hfrq DATE null,
	hfjg VARCHAR(2000) null
);