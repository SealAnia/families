ALTER TABLE `families`.`family_member`
ADD INDEX `family_FK_idx` (`family_id` ASC) VISIBLE;
;
ALTER TABLE `families`.`family_member`
ADD CONSTRAINT `family_FK`
  FOREIGN KEY (`family_id`)
  REFERENCES `families`.`family` (`familyid`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;