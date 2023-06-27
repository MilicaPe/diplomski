import { Component } from '@angular/core';
import {JwtHelperService} from "@auth0/angular-jwt";
import {Router} from "@angular/router";
import {AuthService} from "../../../auth/services/auth.service";
import {TitleService} from "../../services/title.service";

@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['./root.component.scss']
})
export class RootComponent {
  public role: string = ''
  public pageTitle: string= '';

  constructor (private router: Router, private authService: AuthService,
               private titleService: TitleService){//, private titleService: TitleService) {
  }


  ngOnInit () : void {
    this.pageTitle = this.titleService.getTitle(this.router.url)

    this.router.events.subscribe(() => {
      this.pageTitle = this.titleService.getTitle(this.router.url)
    })
  }

  checkRole () : void {
    const item = this.authService.getToken();
    if (item) {
      const jwt: JwtHelperService = new JwtHelperService()
      const info = jwt.decodeToken(item)
      this.role = info.role;
      // for (const key in info.role[0]) {
      //   if (info.role[0][key]) {
      //     console.log('IMAM ROLU: ' + key)
      //     this.role = key
      //   }
      // }
    } else {
      this.role = ''
    }
    console.log("ROLEEEEEEEe");
    console.log(this.role)
  }
}
