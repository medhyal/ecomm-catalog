
insert into category (id, name, parent_category_id) values(88, 'CAT1', 100);

insert into category_products (category_id, product_id, seq_num) values(88, 4041, 1);
insert into category_products (category_id, product_id, seq_num) values(88, 4136, 1);
insert into category_products (category_id, product_id, seq_num) values(88, 4134, 1);
insert into category_products (category_id, product_id, seq_num) values(88, 5022, 1);
insert into category_products (category_id, product_id, seq_num) values(88, 5020, 1);
insert into category_products (category_id, product_id, seq_num) values(88, 6061, 1);

insert into product (id, name, description, parent_category,image_url) values(4041, 'Prod 1', 'Prod 1', 88, 'image1');
insert into product (id, name, description, parent_category,image_url) values(4136, 'Prod 2', 'Prod 2', 88, 'image2');
insert into product (id, name, description, parent_category,image_url) values(4134, 'Prod 3', 'Prod 3', 88, 'image3');
insert into product (id, name, description, parent_category,image_url) values(5022, 'Prod 4', 'Prod 4', 88, 'image4');
insert into product (id, name, description, parent_category,image_url) values(5020, 'Prod 5', 'Prod 5', 88, 'image5');
insert into product (id, name, description, parent_category,image_url) values(6061, 'Prod 6', 'Prod 6', 88, 'image6');

insert into sku (id) values(73110);
insert into sku (id) values(73106);
insert into sku (id) values(73104);
insert into sku (id) values(207462);
insert into sku (id) values(207460);
insert into sku (id) values(201221);

insert into product_skus (product_id, skus) values(4041, 73110);
insert into product_skus (product_id, skus) values(4136, 73106);
insert into product_skus (product_id, skus) values(4134, 73104);
insert into product_skus (product_id, skus) values(5022, 207462);
insert into product_skus (product_id, skus) values(5020, 207460);
insert into product_skus (product_id, skus) values(6061, 201221);


insert into category (id, name, parent_category_id) values(89, 'CAT2', 100);

insert into category_products (category_id, product_id, seq_num) values(89, 5026, 1);
insert into category_products (category_id, product_id, seq_num) values(89, 4162, 1);
insert into category_products (category_id, product_id, seq_num) values(89, 3449, 1);
insert into category_products (category_id, product_id, seq_num) values(89, 2491, 1);
insert into category_products (category_id, product_id, seq_num) values(89, 1965, 1);
insert into category_products (category_id, product_id, seq_num) values(89, 2429, 1);


insert into product (id, name, description, parent_category,image_url) values(5026, 'Prod 8', 'Prod 8', 89, 'image8');
insert into product (id, name, description, parent_category,image_url) values(4162, 'Prod 9', 'Prod 9', 89, 'image9');
insert into product (id, name, description, parent_category,image_url) values(3449, 'Prod 10', 'Prod 10', 89, 'image10');
insert into product (id, name, description, parent_category,image_url) values(2491, 'Prod 11', 'Prod 11', 89,'image11');
insert into product (id, name, description, parent_category,image_url) values(1965, 'Prod 12', 'Prod 12', 89,'image12');
insert into product (id, name, description, parent_category,image_url) values(2429, 'Prod 13', 'Prod 13', 89,'image13');

insert into sku (id) values(207466);
insert into sku (id) values(75106);
insert into sku (id) values(75120);
insert into sku (id) values(201215);
insert into sku (id) values(201281);
insert into sku (id) values(58138);

insert into product_skus (product_id, skus) values(5026, 207466);
insert into product_skus (product_id, skus) values(4162, 75106);
insert into product_skus (product_id, skus) values(3449, 75120);
insert into product_skus (product_id, skus) values(2491, 201215);
insert into product_skus (product_id, skus) values(1965, 201281);
insert into product_skus (product_id, skus) values(2429, 58138);


insert into category (id, name, parent_category_id) values(90, 'CAT3', 100);

insert into category_products (category_id, product_id, seq_num) values(90, 5609, 1);
insert into category_products (category_id, product_id, seq_num) values(90, 4205, 1);
insert into category_products (category_id, product_id, seq_num) values(90, 4200, 1);
insert into category_products (category_id, product_id, seq_num) values(90, 4201, 1);
insert into category_products (category_id, product_id, seq_num) values(90, 4202, 1);
insert into category_products (category_id, product_id, seq_num) values(90, 2590, 1);


insert into product (id, name, description, parent_category,image_url) values(5609, 'Prod 14', 'Prod 14', 90, 'image14');
insert into product (id, name, description, parent_category,image_url) values(4205, 'Prod 15', 'Prod 15', 90,'image15');
insert into product (id, name, description, parent_category,image_url) values(4200,'Prod 16','Prod 16', 90,'image16');
insert into product (id, name, description, parent_category,image_url) values(4201,'Prod 17','Prod 17',90,'image17');
insert into product (id, name, description, parent_category,image_url) values(4202,'Prod 18', 'Prod 18',90,'image18');
insert into product (id, name, description, parent_category,image_url) values(2590,'Prod 19','Prod 19',90,'image19');


insert into sku (id) values(76142);
insert into sku (id) values(76115);
insert into sku (id) values(76110);
insert into sku (id) values(76111);
insert into sku (id) values(76112);
insert into sku (id) values(76136);


insert into product_skus (product_id, skus) values(5609, 76142);
insert into product_skus (product_id, skus) values(4205, 76115);
insert into product_skus (product_id, skus) values(4200, 76110);
insert into product_skus (product_id, skus) values(4201, 76111);
insert into product_skus (product_id, skus) values(4202, 76112);
insert into product_skus (product_id, skus) values(2590, 76136);




insert into category (id, name, parent_category_id) values(91, 'CAT4', 100);

insert into category_products (category_id, product_id, seq_num) values(91, 5024, 1);
insert into category_products (category_id, product_id, seq_num) values(91, 5028, 1);
insert into category_products (category_id, product_id, seq_num) values(91, 4249, 1);
insert into category_products (category_id, product_id, seq_num) values(91, 2497, 1);
insert into category_products (category_id, product_id, seq_num) values(91, 4232, 1);
insert into category_products (category_id, product_id, seq_num) values(91, 4254, 1);


insert into product (id, name, description, parent_category,image_url) values(5024,'Prod 20','Prod 20', 91,'image20');

insert into product (id, name, description, parent_category,image_url) values(5028,'Prod 21','Prod 21', 91,'image21');

insert into product (id, name, description, parent_category,image_url) values(4249, 'Prod 22', 'Prod 22', 91, 'image22');

insert into product (id, name, description, parent_category,image_url) values(2497, 'Prod 23', 'Prod 23', 91, 'image23');


insert into product (id, name, description, parent_category,image_url) values(4232, 'Prod 24', 'Prod 24', 91, 'image24');

insert into product (id, name, description, parent_category,image_url) values(4254, 'Prod 25', 'Prod 25', 91, 'image25');



insert into sku (id) values(207464);
insert into sku (id) values(207468);
insert into sku (id) values(74107);
insert into sku (id) values(201245);
insert into sku (id) values(44137);
insert into sku (id) values(74112);

insert into product_skus (product_id, skus) values(5024, 207464);
insert into product_skus (product_id, skus) values(5028, 207468);
insert into product_skus (product_id, skus) values(4249, 74107);
insert into product_skus (product_id, skus) values(2497, 201245);
insert into product_skus (product_id, skus) values(4232, 44137);
insert into product_skus (product_id, skus) values(4254, 74112);








 
