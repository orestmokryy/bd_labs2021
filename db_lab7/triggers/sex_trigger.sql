DROP TRIGGER IF EXISTS AfterDeleteSex;
DROP TRIGGER IF EXISTS AfterUpdateSex;
DELIMITER //
CREATE TRIGGER AfterDeleteSex
After DELETE ON sex For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(sex_id) into value1 from family_tree where family_tree.sex_id = old.id;
    select count(sex_id) into value2 from family_life_partners where family_life_partners.sex_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in family  tree).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in family partner).';    
    end if;
	
End//
CREATE TRIGGER AfterUpdateSex
After Update ON sex For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(sex_id) into value1 from family_tree where family_tree.sex_id = old.id;
    select count(sex_id) into value2 from family_life_partners where family_life_partners.sex_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'Update Error (Foreign key in family  tree).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'Update Error (Foreign key in family partner).';    
    end if;
	
End//