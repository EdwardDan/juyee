create table cp_Contract (
	contractId VARCHAR(75) not null primary key,
	htlb VARCHAR(75) null,
	bjbh VARCHAR(75) null,
	bdh VARCHAR(75) null,
	cbfs VARCHAR(75) null,
	htmc VARCHAR(75) null
);

create table cp_Project (
	projectId VARCHAR(75) not null primary key,
	zzjgdm VARCHAR(75) null,
	bjrq DATE null,
	bjWebid VARCHAR(75) null,
	xmmc VARCHAR(75) null,
	bjwcbj VARCHAR(75) null,
	jsdwmc VARCHAR(75) null
);