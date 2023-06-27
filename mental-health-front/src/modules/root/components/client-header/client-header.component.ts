import {Component, Input} from '@angular/core';
import {AuthService} from "../../../auth/services/auth.service";

@Component({
  selector: 'app-client-header',
  templateUrl: './client-header.component.html',
  styleUrls: ['./client-header.component.scss']
})
export class ClientHeaderComponent {

  @Input() pageTitle: string | undefined

  constructor(private authService: AuthService) {
  }

  logout() {
    this.authService.logout();
  }
}
