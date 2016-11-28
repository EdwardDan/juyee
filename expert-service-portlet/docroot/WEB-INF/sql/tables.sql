create table expert_Expert (
	expertId LONG not null primary key,
	userId LONG,
	xm VARCHAR(75) null,
	xb VARCHAR(75) null,
	sfzh VARCHAR(75) null,
	csny DATE null,
	gzdw VARCHAR(75) null,
	dzyx VARCHAR(75) null,
	txdz VARCHAR(75) null,
	yzbm VARCHAR(75) null,
	xrzw VARCHAR(75) null,
	zc VARCHAR(75) null,
	zyzg VARCHAR(75) null,
	cszy VARCHAR(75) null,
	zygznx VARCHAR(75) null,
	sjhm VARCHAR(75) null,
	lxdh VARCHAR(75) null,
	cz VARCHAR(75) null,
	sqbz INTEGER
);

create table expert_Gzjl (
	GzjlId LONG not null primary key,
	expertId LONG,
	gzdw VARCHAR(75) null,
	qzny VARCHAR(75) null,
	cszyzygz VARCHAR(75) null,
	zw VARCHAR(75) null
);

create table expert_Jbxx (
	jbxxId LONG not null primary key,
	xm VARCHAR(75) null,
	xb VARCHAR(75) null,
	sfzh VARCHAR(75) null,
	csny DATE null,
	gzdw VARCHAR(75) null,
	dzyx VARCHAR(75) null,
	txdz VARCHAR(75) null,
	yzbm VARCHAR(75) null,
	xrzw VARCHAR(75) null,
	zc VARCHAR(75) null,
	zyzg VARCHAR(75) null,
	cszy VARCHAR(75) null,
	zygznx VARCHAR(75) null,
	sjhm VARCHAR(75) null,
	lxdh VARCHAR(75) null,
	cz VARCHAR(75) null
);

create table expert_Xlxx (
	xlxxId LONG not null primary key,
	expertId LONG,
	byyx VARCHAR(75) null,
	sxzy VARCHAR(75) null,
	xlhxw VARCHAR(75) null,
	zxsj VARCHAR(75) null
);

create table expert_Zqtzjkrzqk (
	zqtzjkrzqkId LONG not null primary key,
	expertId LONG,
	zjkxtlsdw VARCHAR(75) null,
	sqzy VARCHAR(75) null,
	pzrq DATE null
);

create table expert_Zysqlb (
	zysqlbId LONG not null primary key,
	expertId LONG,
	sx VARCHAR(75) null,
	zy VARCHAR(2000) null,
	zt INTEGER,
	shyj VARCHAR(75) null,
	shr VARCHAR(75) null,
	shrq DATE null
);

create table expert_Zzjl (
	zzjlId LONG not null primary key,
	expertId LONG,
	gzdw VARCHAR(75) null,
	qzny VARCHAR(75) null,
	cszyzygz VARCHAR(75) null,
	zw VARCHAR(75) null
);