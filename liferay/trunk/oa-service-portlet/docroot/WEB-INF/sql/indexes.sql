create index IX_8494C0D on oa_DeptWork (deptName);
create index IX_7C6E7D13 on oa_DeptWork (userName);

create index IX_6C5391C1 on oa_DeptWorkItem (deptWorkId);

create index IX_93A71FFB on oa_Dispatch (title);

create index IX_37CD3B3D on oa_OfficeSupply (name);

create index IX_14106DF8 on oa_OfficeSupplyApplication (userId);

create index IX_C7CE445F on oa_OfficeSupplyApplicationItem (officeSupplyApplicationId);

create index IX_EE166386 on oa_VehicleApplication (applicantName);