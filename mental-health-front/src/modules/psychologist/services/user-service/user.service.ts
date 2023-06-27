import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserDto} from "../../model/user-dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private path = environment.api_path+'users';

  constructor(private httpclient:HttpClient) { }

  getClients():Observable<UserDto[]>{
    return this.httpclient.get<UserDto[]>(`${this.path}/clients`)
  }

  getJobs():Observable<string[]>{
    return this.httpclient.get<string[]>(`${this.path}/job`)
  }
}
