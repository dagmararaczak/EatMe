insert into RESTAURANT(name) values('VAFANAPOLI');
insert into MENU(restaurant_id) values (1);

insert into MEAL(name,PRICE,MENU_ID) values('CEZAR Z KURCZAKIEM',21.5,1);
insert into MEAL(name,PRICE) values('PIERŚ Z KACZKI',35.0);
insert into MEAL(name,PRICE) values('CHRUPIĄCU KURCZAK',22.99);
insert into MEAL(name,PRICE) values('SAŁATKA Z ORZECHAMI',18.99);


insert into Ingredients(name,MEAL_ID) values('czosnek',1);
insert into Ingredients(name) values('kurczak');
insert into Ingredients(name) values('orzechy');
insert into Ingredients(name) values('pomidor');
insert into Ingredients(name) values('ryż');
insert into Ingredients(name) values('makaron');
insert into Ingredients(name) values('cukinia');
insert into Ingredients(name) values('kaczka');

insert into restaurant_cuisine(restaurant_id, cuisine) VALUES (1,'ITALIAN')








/*insert into RESTAURANT_CUISINE(restaurant_id, cuisine) values (1,' ITALIAN');*/




