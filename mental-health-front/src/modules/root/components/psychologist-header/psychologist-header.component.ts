import {Component, Input} from '@angular/core';
import {AuthService} from "../../../auth/services/auth.service";

@Component({
  selector: 'app-psychologist-header',
  templateUrl: './psychologist-header.component.html',
  styleUrls: ['./psychologist-header.component.scss']
})
export class PsychologistHeaderComponent {

  @Input() pageTitle: string | undefined

  constructor(private authService: AuthService) {
  }

  logout() {
    this.authService.logout();
  }
}
