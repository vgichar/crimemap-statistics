INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_PUBLIC');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_PS');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_SVR');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_MODERATOR');
INSERT INTO `UserRoles` (`role`) VALUES ('ROLE_ADMIN');

INSERT INTO `users` (`email`, `name`, `password`, `readOnlyPermission`, `userRole_role`) VALUES ('admin@admin.com', 'admin', 'admin', '0', 'ROLE_ADMIN');
INSERT INTO `users` (`email`, `name`, `password`, `readOnlyPermission`, `userRole_role`) VALUES ('vojdan@admin.com', 'vojdan', 'vojdan', '0', 'ROLE_PUBLIC');