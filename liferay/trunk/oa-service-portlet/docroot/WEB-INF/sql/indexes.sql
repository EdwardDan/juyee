create index IX_8494C0D on oa_DeptWork (deptName);
create index IX_7C6E7D13 on oa_DeptWork (userName);

create index IX_6C5391C1 on oa_DeptWorkItem (deptWorkId);

create index IX_93A71FFB on oa_Dispatch (title);

create index IX_37CD3B3D on oa_OfficeSupply (name);

create index IX_C4DEFA41 on oa_OfficeSupplyApply (applicantName);
create index IX_BB2AFEC0 on oa_OfficeSupplyApply (deptName);

create index IX_75394CD3 on oa_OfficeSupplyRequisition (applicantName);
create index IX_B47D8EE on oa_OfficeSupplyRequisition (deptName);

create index IX_D0E357DF on oa_OfficeSupplyRequisitionItem (officeSupplyRequisitionId);

create index IX_F44F99BA on oa_VehicleRequisition (applicantName);