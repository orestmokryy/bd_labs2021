DROP TRIGGER IF EXISTS AfterInsertFamilyPartners;
DELIMITER //
CREATE TRIGGER AfterInsertFamilyPartners
After INSERT ON family_life_partners For Each row 
Begin

	Declare value1 int;
    Declare value2 int;
    Declare value3 int;

	select count(id) into value1 from family_tree where family_tree.id = new.tree_id;
	select count(id) into value2 from sex where sex.id = new.sex_id;
        select count(*) into value3 from family_life_partners;


	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No tree for this family partner).';
    end if;
	if value2 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No sex for this family partner).';
    end if;
    if value3 >6 then
		signal sqlstate '45000' set message_text = 'Error Cardinality (Should be  less than 6 partners).';
    end if;
End//

DELIMITER ;