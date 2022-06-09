CREATE DEFINER=`kasyanka`@`localhost` FUNCTION `get_sex_of_family_partner`(family_partners_id int) RETURNS varchar(45) CHARSET latin1
begin
return (
	select sex.name  from family_life_partners 
    JOIN sex on sex.id=family_life_partners.sex_id
    where family_partners_id = family_life_partners.id
);
end