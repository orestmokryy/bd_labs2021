CREATE DEFINER=`kasyanka`@`localhost` FUNCTION `get_max_estimated_price`() RETURNS int(11)
begin
return (
	select MAX(estimated_price)
    from family_values
);
end