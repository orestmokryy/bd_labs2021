DROP TRIGGER IF EXISTS AfterDeleteFamilyValues;
DROP TRIGGER IF EXISTS AfterUpdateFamilyValues;

DELIMITER //
CREATE TRIGGER AfterDeleteFamilyValues
After DELETE ON family_values For Each row 
Begin
    Declare value1 int;
	select count(family_values_id) into value1 from family_has_value where family_has_value.family_values_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in family has value).';
	end if;

End//
CREATE TRIGGER AfterUpdateFamilyValues
After UPDATE ON family_values For Each row 
Begin
    Declare value1 int;

	select count(family_values_id) into value1 from family_has_value where family_has_value.family_values_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in family has value).';
	end if;

End//