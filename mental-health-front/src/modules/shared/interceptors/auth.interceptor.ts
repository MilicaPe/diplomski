import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor,
  HttpErrorResponse, HttpHeaders,
} from '@angular/common/http';
import { Observable, tap } from 'rxjs';
import { Router } from '@angular/router';
import {AuthService} from "../../auth/services/auth.service";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {
  constructor(private router: Router, private authService: AuthService) { }

  intercept(
    req: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {

    const authToken = this.authService.getToken();
    // const cookie = this.authService.getCookie();
    // console.log("COKKIE");
    // console.log(cookie)
    if (authToken && req.url.startsWith('http://localhost:8080')) {
      const header = new HttpHeaders({ Authorization: 'Bearer ' + authToken});
      //req.headers.set('Authorization', 'Bearer ' + authToken)//
        // 'userFingerprint': cookie});

      const cloned = req.clone({
        headers: header,
        withCredentials: true,
      });

      return next.handle(cloned).pipe(
        tap(
          (err) => {
            if (err instanceof HttpErrorResponse) {
              if (err.status !== 401) {
                return;
              }
              // this.authService.logout();
            }
          }
        )
      );
    } else {
      const cloned = req.clone({
        withCredentials: true,
      })
      return next.handle(cloned);
    }
  }
}
