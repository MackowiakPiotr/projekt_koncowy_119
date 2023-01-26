update city
set country_id=(select id from country where name='France')
where name='Paris'