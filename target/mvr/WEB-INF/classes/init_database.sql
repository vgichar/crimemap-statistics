INSERT INTO `usertypes` (`role`) VALUES ('PUBLIC');
INSERT INTO `usertypes` (`role`) VALUES ('PS');
INSERT INTO `usertypes` (`role`) VALUES ('SVR');
INSERT INTO `usertypes` (`role`) VALUES ('MODERATOR');
INSERT INTO `usertypes` (`role`) VALUES ('ADMIN');

INSERT INTO `users` (`userId`, `email`, `name`, `password`, `readOnlyPermission`, `usertype_usertypeId`) VALUES ('1', 'admin@admin.com', 'admin', 'admin', '0', '5');