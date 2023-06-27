import {Injectable} from "@angular/core";
import {ActivatedRouteSnapshot, CanActivate, Router} from "@angular/router";
import { JwtHelperService } from '@auth0/angular-jwt'
import {AuthService} from "../../services/auth.service";

@Injectable({
  providedIn: 'root'
})// ROLE_ADMIN, OWNER, INMATE
export class RoleGuard implements CanActivate {
  constructor (public auth: AuthService, public router: Router) {}

  canActivate (route: ActivatedRouteSnapshot): boolean {
    const expectedRoles: string = route.data['expectedRoles']
    const token = this.auth.getToken()
    const jwt: JwtHelperService = new JwtHelperService()

    if (!token) {
      console.log("No token")
      return false
    }
    const info = jwt.decodeToken(token)


    const roles: string[] = expectedRoles.split('|', 3)
    for (const r of roles) {
      console.log(info.role[0][r])
      if (info.role === r)
      { return true }
    }
    this.router.navigate(['/home'])
    return false
  }
}
