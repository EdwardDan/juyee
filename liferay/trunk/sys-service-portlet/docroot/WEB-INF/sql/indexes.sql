create index IX_956EB3D6 on sys_Dictionary (code_, groupId);
create index IX_12AC8186 on sys_Dictionary (groupId, code_);
create index IX_30C35755 on sys_Dictionary (groupId, parentId);
create index IX_F29A0FED on sys_Dictionary (groupId, parentId, isValid);
create index IX_DA76306E on sys_Dictionary (groupId, parentId, name, code_);
create index IX_C5F19EC7 on sys_Dictionary (parentId);
create index IX_349C85C3 on sys_Dictionary (parentId, groupId);
create index IX_784008BB on sys_Dictionary (parentId, isValid);
create index IX_2F740E4F on sys_Dictionary (parentId, isValid, groupId);