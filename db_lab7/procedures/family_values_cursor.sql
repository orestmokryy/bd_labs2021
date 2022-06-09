CREATE DEFINER=`kasyanka`@`localhost` PROCEDURE `create_more_family_values`()
BEGIN
  declare done int default false;
  declare value_table varchar(45);
  declare ValueCursor cursor
    for select name from family_values;
    declare continue handler
    for not found set done = true;
    OPEN ValueCursor;
    myLoop: LOOP
    fetch ValueCursor into value_table;
        if done = true then LEAVE myLoop;
        end if;
        set @columns_count = RAND()*((9-1+1)+1);
        set @n = 0;
    set @temp_query = concat('drop table if exists `',value_table,'`');
    prepare myquery from @temp_query;
        execute myquery;
        deallocate prepare myquery;
    SET @temp_query = concat('create table if not exists `',value_table,'` (');
        while_loop: while @n < @columns_count do
      SET @temp_query = concat(@temp_query,'random',@N,' int ');
      IF @n < @columns_count -1
        then SET @temp_query = concat(@temp_query,', ');
      END IF;
      SET @n = @n+1;
        end while while_loop;
        SET @temp_query = concat(@temp_query,');');
    PREPARE myquery FROM @temp_query;
        EXECUTE myquery;
        DEALLOCATE PREPARE myquery;
  END LOOP;
    CLOSE ValueCursor;
END