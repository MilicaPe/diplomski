import { Injectable } from '@angular/core';
import {environment} from "../../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HistoryDto} from "../../../client/model/history-dto";
import {RuleDto} from "../../model/rule-dto";

@Injectable({
  providedIn: 'root'
})
export class RuleService {
  private path = environment.api_path;

  constructor(private httpClient:HttpClient) { }

  addRule(param: RuleDto): Observable<any> {
    return this.httpClient.post<any>(`${this.path}new/rules`, param)
  }

}
