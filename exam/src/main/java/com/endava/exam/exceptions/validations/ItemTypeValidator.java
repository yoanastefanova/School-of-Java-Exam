package com.endava.exam.exceptions.validations;

import com.endava.exam.model.enums.ItemType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ItemTypeValidator implements ConstraintValidator<ValidItemType, ItemType> {


    //TODO
    @Override
    public boolean isValid(ItemType itemType, ConstraintValidatorContext context){
        for(ItemType type : ItemType.values()){
            if(type.equals(itemType)){
                return true;
            }
        }
        return customMessageForConstraint(context, "Not an existing item type!");
    }


    private boolean customMessageForConstraint(ConstraintValidatorContext context, String message) {
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(message)
                .addConstraintViolation();
        return false;
    }
}
