INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_PUBLIC');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_PS');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_SVR');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_MODERATOR');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_ADMIN');

INSERT INTO `users` (`email`, `name`, `password`, `readOnlyPermission`, `userRole_role`) VALUES ('admin@admin.com', 'admin', 'admin', '0', 'ROLE_ADMIN');
INSERT INTO `users` (`email`, `name`, `password`, `readOnlyPermission`, `userRole_role`) VALUES ('vojdan@admin.com', 'vojdan', 'vojdan', '0', 'ROLE_PUBLIC');

INSERT INTO `DropDownListKey` (`ddlkKey`, `dependency`) VALUES ('PS', 'SVR');
INSERT INTO `DropDownListKey` (`ddlkKey`, `dependency`) VALUES ('SVR', NULL);




INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`) VALUES ('SVR', 'SVR 1');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`) VALUES ('SVR', 'SVR 2');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`) VALUES ('SVR', 'SVR 3');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`) VALUES ('SVR', 'SVR 4');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`) VALUES ('SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 1', 'SVR', 'SVR 1');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 2', 'SVR', 'SVR 1');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 3', 'SVR', 'SVR 1');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 4', 'SVR', 'SVR 1');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 5', 'SVR', 'SVR 2');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 6', 'SVR', 'SVR 2');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 7', 'SVR', 'SVR 3');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 8', 'SVR', 'SVR 3');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 9', 'SVR', 'SVR 3');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 10', 'SVR', 'SVR 3');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 11', 'SVR', 'SVR 3');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 12', 'SVR', 'SVR 4');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 13', 'SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 14', 'SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 15', 'SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 16', 'SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 17', 'SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 18', 'SVR', 'SVR 5');
INSERT INTO `DropDownList` (`ddlKey`, `ddlValue`, `dependencyKey`, `dependencyValue`) VALUES ('PS', 'PS 19', 'SVR', 'SVR 5');