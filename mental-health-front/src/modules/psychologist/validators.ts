import {Validators} from "@angular/forms";

export const emailValidator = Validators.email
export const stringValidator = Validators.pattern('[A-ZŠĆČĐŽa-zšđčćž][a-zšđčćž]*')
export const stringAndNumber = Validators.pattern('[A-ZŠĆČĐŽa-zšđčćž0-9]*')
export const numberValidator = Validators.pattern('[0-9]{1, 4}')
/*
*   [a-zšđčćž\s0-9]
* */
