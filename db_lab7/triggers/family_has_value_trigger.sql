DROP TRIGGER IF EXISTS AfterInsertFamilyHasValue;
DELIMITER //
CREATE TRIGGER AfterInsertFamilyHasValue
After INSERT ON family_has_value For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	select count(id) into value1 from family_tree where family_tree.id = new.family_tree_id;
	select count(id) into value2 from family_values where family_values.id = new.family_values_id;
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No family tree).';
    end if;
	if value2 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No family  value).';
    end if;
End//

DELIMITER ;