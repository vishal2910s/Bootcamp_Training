----------------------------------------Question 1

--create the table

CREATE TABLE user_roles (
  id INT NOT NULL,
  rolename VARCHAR(45) NULL,
  userid INT NULL,
  PRIMARY KEY (id));
  
  --create the procedure
  
 DELIMITER $$
 CREATE PROCEDURE insert_values()
   BEGIN
   insert into user_roles values (1, 'admin',1), (2, 'employee',1),(3,'learner',1);
   END $$
 DELIMITER ;
 
 --call the procedure
 
 call insert_values();
 
 select * from user_roles;
 
 --Drop the procedure
 
 DROP PROCEDURE insert_values;
 
 --procedure with variable pkvalue
 
DELIMITER $$
 CREATE PROCEDURE insert_values()
   BEGIN
   DECLARE pkvalue int;
   select max(id) into pkvalue from user_roles;
   insert into user_roles values (pkvalue+1, 'admin',1), (pkvalue+2, 'employee',1),(pkvalue+3,'learner',1);
   END $$
 DELIMITER;
 
 
 ----------------------------------------------------Question-2
 
 --Drop Procedure
 
DROP PROCEDURE insert_values; 

--PROCEDURE with Argument

DELIMITER $$
 CREATE PROCEDURE insert_values(usr_id int)
   BEGIN
   DECLARE pkvalue int ;
   select max(id) into pkvalue from user_roles;
   insert into user_roles values (pkvalue+1, 'admin',usr_id), (pkvalue+2, 'employee',usr_id),(pkvalue+3,'learner',usr_id);
   END $$
DELIMITER ;

--calling the procedure with agrument.
call insert_values(10);


----------------------------------------------------Question-3

DELIMITER $$
CREATE PROCEDURE conditional_flow(val varchar(10))
BEGIN
CASE val
    WHEN 'first' THEN select 'First condition executed';
    WHEN 'second'  THEN select 'Second condition executed';
    WHEN 'third'  THEN select 'Third condition executed';
    ELSE select 'Else condition executed';
END CASE;
END $$
DELIMITER ;

CALL conditional_flow('first');
CALL conditional_flow('second');
CALL conditional_flow('third');
CALL conditional_flow('fourth');


---------------------------------------------------------Question-4

CREATE TABLE student_info(
student_id INT,
marks INT,
grade VARCHAR(100),
PRIMARY KEY(student_id)
);


 DELIMITER $$
 CREATE PROCEDURE insert_student_info()
   BEGIN
   insert into student_info values (1, 27,NULL), (2, 65,NULL),(3,94,NULL),(4, 83,NULL), (5, 54,NULL),(6,77,NULL);
   END $$
 DELIMITER ;
 
 CALL insert_student_info();
 
 DELIMITER $$
 CREATE PROCEDURE check_marks()
BEGIN
  DECLARE done INT DEFAULT FALSE;
  DECLARE sid int;
  DECLARE mks int;
  DECLARE cursor1 CURSOR FOR select student_id,marks from student_info;
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
  OPEN cursor1;
  read_loop: LOOP
    FETCH cursor1 INTO sid, mks;
    IF  done THEN LEAVE read_loop;
	END IF;
    IF mks>90 THEN update student_info set grade ='Excellent' where student_id = sid;
	ELSEIF mks>60 && mks<=90 THEN update student_info set grade ='Average' where student_id = sid;
	ELSEIF mks>35 && mks<=60 THEN update student_info set grade ='Poor' where student_id = sid;
	ELSE update student_info set grade ='Fail' where student_id = sid;
    END IF;
  END LOOP;
  CLOSE cursor1;
END $$
DELIMITER ;




----------------------------------------------------------Question-5

CREATE TABLE author(
id INT PRIMARY KEY,
name VARCHAR(20),
age INT
);

CREATE TABLE author_audit (
    id INT AUTO_INCREMENT PRIMARY KEY,
    authorId INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    changedate DATETIME DEFAULT NULL,
    action VARCHAR(50) DEFAULT NULL
);
 
 DELIMITER $$
CREATE TRIGGER before_author_insert
    BEFORE INSERT ON author
    FOR EACH ROW
BEGIN
	INSERT INTO author_audit
	SET authorId = NEW.id,
	name =NEW.name,
	changedate = NOW(),
	action = 'before_insert';
END $$
DELIMITER ;

 
 DELIMITER $$
CREATE TRIGGER after_author_insert
    AFTER INSERT ON author
    FOR EACH ROW
BEGIN
    INSERT INTO author_audit
    SET authorId = NEW.id,
        name = NEW.name,
        changedate = NOW(),
		action = 'after_insert';
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER before_author_update
    BEFORE UPDATE ON author
    FOR EACH ROW
BEGIN
    INSERT INTO author_audit
    SET authorId = OLD.id,
        name = OLD.name,
        changedate = NOW(),
		action = 'before_update';
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER after_author_update
    AFTER UPDATE ON author
    FOR EACH ROW
BEGIN
    INSERT INTO author_audit
    SET authorId = OLD.id,
        name = OLD.name,
        changedate = NOW(),
		action = 'after_update';
END $$
DELIMITER ;

DELIMITER $$
CREATE TRIGGER before_author_delete
    BEFORE DELETE ON author
    FOR EACH ROW
BEGIN
    INSERT INTO author_audit
    SET authorId = OLD.id,
        name = OLD.name,
        changedate = NOW(),
		action = 'before_delete';
END $$
DELIMITER ;


DELIMITER $$
CREATE TRIGGER after_author_delete
    AFTER DELETE ON author
    FOR EACH ROW
BEGIN
    INSERT INTO author_audit
    SET authorId = OLD.id,
        name = OLD.name,
        changedate = NOW(),
		action = 'after_delete';
END $$
DELIMITER ;


INSERT INTO author(id,name,age) VALUES(1,'Vishal',22),(2,'Rohit',25),(3,'Vickey',30);
UPDATE author SET age=28 where id=3;
DELETE FROM author WHERE name='Vickey';




