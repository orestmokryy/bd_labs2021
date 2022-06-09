CREATE DEFINER=`kasyanka`@`localhost` PROCEDURE `member_of_family_has_value`()
BEGIN
select concat(family_tree.name," ", family_tree.surname) as member, concat(family_values.name," ", family_values.estimated_price) as value_and_estimated_price from family_has_value
 join family_tree on family_has_value.family_tree_id = family_tree.id 
 join family_values on family_has_value.family_values_id = family_values.id;

END