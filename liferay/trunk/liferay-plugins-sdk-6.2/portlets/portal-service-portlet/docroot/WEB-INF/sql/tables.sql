create table portal_Feedback (
	feedbackId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	zt VARCHAR(75) null,
	lx VARCHAR(75) null,
	fkrId LONG,
	fkrq DATE null,
	fknr VARCHAR(75) null,
	hfrId LONG,
	hfrq DATE null,
	hfjg VARCHAR(75) null
);