--SET SCHEMA  "MTAMS";
--grep -i "DROP " ./mtams.create.sql | tac | cut -d" " -f2-
-- see notes in cat.script.sh for table order
-- Sepcial notes where grep does not work
-- table X comess >> after table Y

DROP TABLE "CITIES"; 
DROP TABLE "COUNTRIES"; 
DROP TABLE "REGIONS"; 
DROP TABLE "CURRENCY";
--DROP SCHEMA "MTAMS" restrict;


