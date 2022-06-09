DROP TRIGGER IF EXISTS AfterDeleteFamilyTree;
DROP TRIGGER IF EXISTS AfterUpdateFamilyTree;
DROP TRIGGER IF EXISTS AfterInsertFamilyTree;
DELIMITER //
CREATE TRIGGER AfterDeleteFamilyTree
After DELETE ON family_tree For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	Declare value3 int;

	select count(tree_id) into value1 from family_tree where family_tree.tree_id = old.id;
    select count(tree_id) into value2 from family_life_partners where family_life_partners.tree_id = old.id;
	select count(family_tree_id) into value3 from family_has_value where family_has_value.family_tree_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in family tree).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in family tree).';    
    end if;
	if value3 > 0 then
		signal sqlstate '45000' set message_text = 'DELETE Error (Foreign key in family has value).';    
    end if;
End//
CREATE TRIGGER AfterUpdateFamilyTree
After UPDATE ON family_tree For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
	Declare value3 int;

	select count(tree_id) into value1 from family_tree where family_tree.tree_id = old.id;
    select count(tree_id) into value2 from family_life_partners where family_life_partners.tree_id = old.id;
	select count(family_tree_id) into value3 from family_has_value where family_has_value.family_tree_id = old.id;
	if value1 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in family tree).';
	end if;
	if value2 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in family tree).';    
    end if;
	if value3 > 0 then
		signal sqlstate '45000' set message_text = 'UPDATE Error (Foreign key in family has value).';    
    end if;
End//
CREATE TRIGGER AfterInsertFamilyTree
After INSERT ON family_tree For Each row 
Begin
	Declare value1 int;
    Declare value2 int;
    Declare value3 varchar(100);
    Declare value4 Date;
	select count(id) into value1 from family_tree where family_tree.id = new.tree_id;
	select count(id) into value2 from sex where sex.id = new.sex_id;
	select death_place into value3 from family_tree where family_tree.death_place = new.death_place;
	select birth_date into value4 from family_tree where family_tree.birth_date = new.birth_date;
	if value1 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No tree for this family tree).';
    end if;
	if value2 = 0 then
		signal sqlstate '45000' set message_text = 'INSERT Error (No sex for this family tree).';
    end if;
    
	if new.death_place NOT  RLIKE "Strilky|Pidkopane|Yariw" then
			signal sqlstate '45000' set message_text = "INSERT Error (Wrong death place).";
	end if;
    if CURDATE()-birth_date <0 then
    	signal sqlstate '45000' set message_text = 'INSERT Error (Are you dumb?).';
    end if;
   

End//

DELIMITER ;