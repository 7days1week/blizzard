insert into book(title, author, price, category) values('title1', 'author1', 10.1, 'category1');
insert into book(title, author, price, category) values('title2', 'author2', 10.1, 'category2');
insert into book(title, author, price, category) values('title3', 'author3', 10.1, 'category3');
insert into book(title, author, price, category) values('title4', 'author4', 10.1, 'category4');
insert into book(title, author, price, category) values('title5', 'author5', 10.1, 'category5');
insert into book(title, author, price, category) values('title6', 'author6', 10.1, 'category6');

insert into cart_item(book_id, shopping_cart_id, quantity) values (1, 1, 2);
insert into cart_item(book_id, shopping_cart_id, quantity) values (2, 1, 1);
insert into cart_item(book_id, shopping_cart_id, quantity) values (3, 1, 5);
insert into cart_item(book_id, shopping_cart_id, quantity) values (6, 1, 4);
insert into cart_item(book_id, shopping_cart_id, quantity) values (4, 1, 1);
insert into cart_item(book_id, shopping_cart_id, quantity) values (1, 2, 2);

insert into shopping_cart(user_id) values (1);
insert into shopping_cart(user_id) values (2);
