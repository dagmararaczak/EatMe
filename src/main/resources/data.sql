insert into RESTAURANT(name) values('VAFANAPOLI');
insert into RESTAURANT(name) values('PASIBUS');
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









/*insert into RESTAURANT_CUISINE(restaurant_id, cuisine) values (1,' ITALIAN');*/




