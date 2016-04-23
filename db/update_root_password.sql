/****************************************************************
* Update the password for the root user (only necessary for Mac)
*****************************************************************/

UPDATE mysql.user
SET Password=PASSWORD("1uat@M!1")
WHERE User='root' AND Host='localhost';


SELECT * FROM Download;
