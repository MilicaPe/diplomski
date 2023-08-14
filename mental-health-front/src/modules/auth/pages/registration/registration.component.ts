import { Component } from '@angular/core';
import {AbstractControl, FormBuilder, FormControl, FormGroup, ValidatorFn, Validators} from "@angular/forms";
import {ErrorStateMatcher} from "@angular/material/core";
import {MessageService} from "primeng/api";
import {RegistrationRequest} from "../../model/registration-request";
import {RegistrationService} from "../../services/registration.service";

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.scss'],
  providers: [MessageService]
})
export class RegistrationComponent {

  registerFormGroup: FormGroup
  nameFormControl = new FormControl('', [Validators.required, Validators.pattern('[A-ZČĆŠĐŽ][a-zčćšđž]{2,20}'), Validators.minLength(2), Validators.maxLength(20)])
  surnameFormControl = new FormControl('', [Validators.required, Validators.pattern('[A-ZČĆŠĐŽ][a-zčćšđž]{2,20}'), Validators.minLength(2), Validators.maxLength(20)])
  emailFormControl = new FormControl('', [Validators.required, Validators.email, Validators.minLength(9), Validators.maxLength(40)])
  passwordFormControl: FormControl = new FormControl('', [Validators.required, Validators.pattern('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-8])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{3,}')])
  passwordAgainFormControl: FormControl

  jobFormControl = new FormControl('', [Validators.required, Validators.pattern('[A-ZČĆŠĐŽa-zčćšđž ]{2,30}'), Validators.minLength(2), Validators.maxLength(30)])
  yearOfBirthFormControl = new FormControl('', [Validators.required, Validators.pattern('[0-9]{4}')])

  matcher = new ErrorStateMatcher();

  constructor(private readonly fb: FormBuilder,
              private readonly messageService: MessageService,
              private registrationService: RegistrationService
              ) {
    this.passwordAgainFormControl = new FormControl('', [Validators.required, this.createPasswordMatchingValidator(this.passwordFormControl)])

    this.registerFormGroup = fb.group({
      name: this.nameFormControl,
      surname: this.surnameFormControl,
      email: this.emailFormControl,
      password: this.passwordFormControl,
      passwordAgain: this.passwordAgainFormControl,
      job: this.jobFormControl,
      yearOfBirth: this.yearOfBirthFormControl
    })
  }

  submit() {
    if (!this.registerFormGroup) return
    //show message
    var userType = (<HTMLInputElement>document.getElementById("userType")).value;
    var gender = (<HTMLInputElement>document.getElementById("gender")).value;
    let myRequest: RegistrationRequest = {
      name: this.nameFormControl.value,
      surname: this.surnameFormControl.value,
      email: this.emailFormControl.value,
      password: this.passwordFormControl.value,

      type: userType,
      gender: gender,
      job: this.jobFormControl.value,
      yearOfBirth: this.yearOfBirthFormControl.value
    }
    console.log("SUBMIT")
    console.log(myRequest)
    // return;

    this.registrationService.sendRequest(myRequest).subscribe({
      next: result => {
        console.log('REGISTER')
        console.log(result)
        if (result)
          this.messageService.add({
            key: 'vimm-message',
            severity: 'success',
            summary: 'Uspešno ste poslali zahtev',
            detail: 'Ulogujte se u našu aplikaciju'
          })
        else
          this.messageService.add({
            key: 'vimm-message',
            severity: 'info',
            summary: 'Nismo uspeli da Vas registrujemo',
            detail: 'Proverite podatke ili da li imate već nalog'
          })
      },

      error: (e) => {
        console.log("ERROR");
        console.log(e)
        this.messageService.add({
          key: 'vimm-message',
          severity: 'info',
          summary: 'Nismo uspeli da pošaljemo Vaš zahtev',
          detail: 'Proverite podatke koje ste uneli ili probajte da pošaljete kasnije Vaš zahtev.'
        })
        console.log(e.status)
      }
    })
  }

  createPasswordMatchingValidator (passwordFormControl: FormControl): ValidatorFn {
    {
      return (control: AbstractControl): Record<string, string> | null =>
        control.value === passwordFormControl.value
          ? null
          : { wrongValue: control.value }
    }
  }
}
