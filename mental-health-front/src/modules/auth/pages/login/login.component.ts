import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {MessageService} from "primeng/api";
import {AuthService} from "../../services/auth.service";
import {HttpErrorResponse} from "@angular/common/http";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
  providers: [MessageService]
})
export class LoginComponent {
  type = 'password';
  isText = false;
  eyeIcon = 'fa-eye-slash';

  codeType = 'password';
  codeIsTxt = false;
  codeEyeIcon = 'fa-eye-slash';

  loginForm!: FormGroup;

  constructor(
    private router: Router,
    private fb: FormBuilder,
    private auth: AuthService,
    private messageService: MessageService,
  ) { }

  hideShowPass() {
    this.isText = !this.isText;
    this.isText ? (this.eyeIcon = 'fa-eye') : (this.eyeIcon = 'fa-eye-slash');
    this.isText ? (this.type = 'text') : (this.type = 'password');
  }

  hideShowCode() {
    this.codeIsTxt = !this.codeIsTxt;
    this.codeIsTxt ? (this.codeEyeIcon = 'fa-eye') : (this.codeEyeIcon = 'fa-eye-slash');
    this.codeIsTxt ? (this.codeType = 'text') : (this.codeType = 'password');
  }

  ngOnInit(): void {
    // sessionStorage.removeItem('jwt');

    this.loginForm = this.fb.group({
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required],
    });
  }

  onLogin() {
    if (!this.loginForm.valid) return;

    this.auth.login(this.loginForm.value).subscribe({
      next: () => {
        this.auth.navigateForRole();
        // this.router.navigate(['/user/home']);
      },
      error: (err: HttpErrorResponse) => {
        this.loginError(err);
      },
    });
  }


  loginError(err: HttpErrorResponse) {
    if (err.status === 401)
      this.messageService.add({
        key: 'vimm-message',
        severity: 'error',
        summary: 'Pogrešan e-mail, lozinka ili kod'
      })
    else if (err.status === 403)
      this.messageService.add({
        key: 'vimm-message',
        severity: 'error',
        summary: 'Vaš sertifikat je povučen ili zahtev još uvek nije prihvaćen'
      })
    else if (err.status === 423) { // locked
      let message = "";
      if (err.error) message = 'Nalog je blokiran zbog previse pokusaja. Pokusajte kasnije!';
      else message = 'Vas nalog je odblokiran. Molimo Vas prijavite se ponovo.';

      this.messageService.add({
        key: 'vimm-message',
        severity: 'error',
        summary: message
      });
    }
    else
      this.messageService.add({
        key: 'vimm-message',
        severity: 'error',
        summary: 'Greška pri prijavljivanju na sistem'
      })
  }
}
