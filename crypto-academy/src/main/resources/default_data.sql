INSERT INTO `roles`(`id`, `name`) VALUES
(1, 'USER'),
(2, 'MODERATOR'),
(3, 'ADMIN');

INSERT INTO `users` (`id`, `username`, `first_name`, `last_name`, `email`, `password`) VALUES
( 10, 'wonderland', 'Gilbert', 'Direko', 'wonderland"abv.bg', 'password1' ),
( 20, 'nftking', 'Arhnods', 'Vale', 'nftking"abv.bg', 'password2');

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
( 10, 1 ),
( 10, 2 ),
( 10, 3 ),
( 20, 1 );