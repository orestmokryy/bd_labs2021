CREATE DEFINER=`kasyanka`@`localhost` PROCEDURE `insertion_values_to_famile_partners`( in surname varchar(45),in name varchar(45),in birth_date date,in birth_place varchar(45),in death_date date, in death_place varchar(45),in marriage_date date,in tree_id int,in sex_id int)
begin
INSERT INTO family_life_partners(`surname` , `name`, `birth_date` , `birth_place`, `death_date`,`death_place`, `marriage_date`,`tree_id`, `sex_id`) VALUES
(surname,
	name,
	birth_date,
	birth_place,
	death_date,
	death_place,
	marriage_date,
    tree_id,
	sex_id);
end