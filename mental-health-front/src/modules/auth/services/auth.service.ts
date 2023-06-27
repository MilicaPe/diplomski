import { Injectable } from '@angular/core';
import {Router} from "@angular/router";
import {HttpClient} from "@angular/common/http";
import { map } from 'rxjs';
import {JwtHelperService} from "@auth0/angular-jwt";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private baseUrl = 'http://localhost:8080/auth/';
  private access_token = null;

  constructor(private router: Router, private http: HttpClient) { }

  login(loginInfo: any) {
    return this.http.post<any>(`${this.baseUrl}login`, loginInfo)
      .pipe(map((res) => {
        console.log("RESULT")
        console.log(res);
        this.access_token = res.accessToken;
        sessionStorage.setItem("jwt", res.accessToken)
      }));
  }

  getToken() {
    return sessionStorage.getItem("jwt");//this.access_token;
  }

  navigateForRole() {
    const token = this.getToken()
    if (token == null)
      return;
    const jwt: JwtHelperService = new JwtHelperService()
    const info = jwt.decodeToken(token)

    if (info.role === "PSIHOLOG") ///////// TODO: Update
      this.router.navigate(['psychologist/home']);
    else
      this.router.navigate(['client/questionnaire'])
  }


  tokenIsPresent() {
    return sessionStorage.getItem("jwt") != undefined;
  }


  logout() {
    this.http.get<any>(`${this.baseUrl}logout`).subscribe() // TODO: update
    this.access_token = null;
    sessionStorage.removeItem("jwt");
    this.router.navigate(['/auth/login']);
  }
}
