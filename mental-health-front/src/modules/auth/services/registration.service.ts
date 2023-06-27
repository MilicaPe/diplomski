import { Injectable } from '@angular/core';
import {RegistrationRequest} from "../model/registration-request";
import {Observable} from "rxjs";
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private readonly API_PATH = environment.api_path + 'auth/registration'

  constructor (private readonly httpClient: HttpClient) {
  }

  sendRequest(myRequest: RegistrationRequest) : Observable<any>{
    return this.httpClient.post(`${this.API_PATH}`, myRequest)
  }
}
