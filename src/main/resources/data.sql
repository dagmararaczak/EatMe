insert into RESTAURANT(name,phone_number,email,google_map) values('VAFANAPOLI','696-331-424','dagmararaczak@gmail.com','embed?pb=!1m18!1m12!1m3!1d2505.0036998986875!2d17.022653274182616!3d51.1083919032671!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x470fc20b0b11b5c1%3A0x108e19847d58417e!2sVaffaNapoli!5e0!3m2!1spl!2spl!4v1562411893288!5m2!1spl!2spl');
insert into RESTAURANT(name) values('PASIBUS');

insert into adres(city,post_code,street,house_number,restaurant_id) values ('Wroclaw','50-357','Grunwaldzka','78/4',1);

insert into MENU(restaurant_id) values (1);
insert into MENU(restaurant_id) values (2);

insert into MEAL(name,PRICE,MENU_ID) values('CEZAR Z KURCZAKIEM',21.5,1);
insert into MEAL(name,PRICE,MENU_ID) values('PIERŚ Z KACZKI',35.0,1);
insert into MEAL(name,PRICE,MENU_ID) values('CHRUPIĄCU KURCZAK',22.99,1);
insert into MEAL(name,PRICE,MENU_ID) values('SAŁATKA Z ORZECHAMI',18.99,1);


insert into Ingredients(name,MEAL_ID) values('czosnek',1);
insert into Ingredients(name,MEAL_ID) values('czosnek',2);
insert into Ingredients(name,MEAL_ID) values('kurczak',1);
insert into Ingredients(name,MEAL_ID) values('orzechy',1);
insert into Ingredients(name,MEAL_ID) values('pomidor',2);
insert into Ingredients(name,MEAL_ID) values('ryż',2);
insert into Ingredients(name) values('makaron');
insert into Ingredients(name) values('cukinia');
insert into Ingredients(name) values('kaczka');

insert into restaurant_cuisine(restaurant_id, cuisine) VALUES (1,'ITALIAN');
insert into restaurant_cuisine(restaurant_id, cuisine) VALUES (2,'AMERICAN');
insert into RESTAURANT_MEAL(restaurant_id, MEAL_TYPE) VALUES (1,'VEGETARIAN');
insert into RESTAURANT_MEAL(restaurant_id, MEAL_TYPE) VALUES (1,'GLUTENFREE');
insert into RESTAURANT_MEAL(restaurant_id, MEAL_TYPE) VALUES (2,'GLUTENFREE');









/*insert into RESTAURANT_CUISINE(restaurant_id, cuisine) values (1,' ITALIAN');*/




